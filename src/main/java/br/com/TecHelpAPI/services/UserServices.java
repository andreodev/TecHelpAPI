package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.exception.ResourceNotFoundException;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;
import br.com.TecHelpAPI.model.User;
import br.com.TecHelpAPI.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserDTO create(UserDTO user) {
        logger.info("Create one user!");
        var entity = parseObject(user, User.class);
        return parseObject(repository.save(entity), UserDTO.class);
    }

    public UserDTO update(UserDTO user) {
        logger.info("Updating one user!");
        User entity = repository.findById(user.getIdUser())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setNameUser(user.getNameUser());
        entity.setPassword(user.getPassword());
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

    public boolean authenticate(String nameUser, String password) {
        logger.info("Authenticating user with username: {}", nameUser);

        var optionalUser = repository.findByNameUser(nameUser);

        if (optionalUser.isEmpty()) {
            logger.warn("User not found for username: {}", nameUser);
            return false;
        }

        User user = optionalUser.get();

        if (user.getPassword().equals(password)) {
            logger.info("User authenticated successfully");
            return true;
        } else {
            logger.warn("Invalid password for username: {}", nameUser);
            return false;
        }
    }
}
