package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.config.JwtUtil;
import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.exception.EmailAlreadyExistsException;
import br.com.TecHelpAPI.exception.ResourceNotFoundException;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;
import br.com.TecHelpAPI.model.User;
import br.com.TecHelpAPI.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final Logger logger = LoggerFactory.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO create(UserDTO user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Já existe um usuário com o e-mail: " + user.getEmail());
        }

        User entity = parseObject(user, User.class);

        // Criptografa a senha antes de salvar
        entity.setPassword(passwordEncoder.encode(user.getPassword()));

        return parseObject(repository.save(entity), UserDTO.class);
    }

    public UserDTO update(UserDTO user) {
        logger.info("Updating one user!");
        User entity = repository.findById(user.getIdUser())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setNameUser(user.getNameUser());
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setDept(user.getDept());
        entity.setEmail(user.getEmail());

        return parseObject(repository.save(entity), UserDTO.class);
    }

    public void delete(Long id) {
        logger.info("Delete one user!");
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

    public String authenticateAndGetToken(String nameUser, String password) {
    var optionalUser = repository.findByNameUser(nameUser);

    if (optionalUser.isEmpty()) {
        return null; // usuário não existe
    }

    User user = optionalUser.get();

   if (passwordEncoder.matches(password, user.getPassword())) {
    return JwtUtil.generateToken(user); // passa o user inteiro
}

    return null; // senha inválida
}

public User authenticateAndGetUser(String nameUser, String rawPassword) {
    Optional<User> optionalUser = repository.findByNameUser(nameUser);

    if (optionalUser.isPresent()) {
        User user = optionalUser.get();

        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        }
    }

    return null; // credenciais inválidas
}

}
