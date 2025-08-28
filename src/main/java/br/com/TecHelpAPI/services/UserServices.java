package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.config.JwtUtil;
import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.exception.EmailAlreadyExistsException;
import br.com.TecHelpAPI.exception.ResourceNotFoundException;
import br.com.TecHelpAPI.model.User;
import br.com.TecHelpAPI.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;

@Service
public class UserServices {

    private final Logger logger = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> findAll() {
        logger.info("Finding all users!");
        return parseListObjects(repository.findAll(), UserDTO.class);
    }

    public UserDTO findById(Long id) {
        logger.info("Finding one user!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return parseObject(entity, UserDTO.class);
    }

    public UserDTO create(UserDTO userDto) {
        logger.info("Attempting to create user with email: {}", userDto.getEmail());

        repository.findByEmail(userDto.getEmail())
                .ifPresent(u -> {
                    logger.warn("Email already exists: {}", userDto.getEmail());
                    throw new EmailAlreadyExistsException("E-mail já cadastrado!");
                });

        var entity = parseObject(userDto, User.class);

        if (entity.getPassword() == null || entity.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        User savedEntity = repository.save(entity);
        logger.info("User created successfully with ID: {}", savedEntity.getIdUser());
        return parseObject(savedEntity, UserDTO.class);
    }

    public UserDTO update(UserDTO userDto) {
        logger.info("Updating user with ID: {}", userDto.getIdUser());

        User entity = repository.findById(userDto.getIdUser())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setNameUser(userDto.getNameUser());
        entity.setDept(userDto.getDept());
        entity.setEmail(userDto.getEmail());

        if (userDto.getPassword() != null && !userDto.getPassword().trim().isEmpty()) {
            logger.info("Updating password for user ID: {}", userDto.getIdUser());
            entity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        User updatedEntity = repository.save(entity);
        return parseObject(updatedEntity, UserDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting user with ID: {}", id);
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

    public boolean authenticate(String nameUser, String password) {
        logger.info("Authenticating user with username: {}", nameUser);

        Optional<User> optionalUser = repository.findByNameUser(nameUser);

        if (optionalUser.isEmpty()) {
            logger.warn("User not found for username: {}", nameUser);
            return false;
        }

        User user = optionalUser.get();
        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if (matches) {
            logger.info("User authenticated successfully: {}", nameUser);
        } else {
            logger.warn("Invalid password for username: {}", nameUser);
        }

        return matches;
    }

    public String authenticateAndGetToken(String nameUser, String password) {
        var optionalUser = repository.findByNameUser(nameUser);

        if (optionalUser.isEmpty()) return null;

        User user = optionalUser.get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return JwtUtil.generateToken(user);
        }

        return null;
    }

    public User authenticateAndGetUser(String nameUser, String rawPassword) {
        Optional<User> optionalUser = repository.findByNameUser(nameUser);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
