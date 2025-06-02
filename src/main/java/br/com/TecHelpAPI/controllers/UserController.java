package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.data.dto.LoginDTO;
import br.com.TecHelpAPI.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{idUser}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO findById(@PathVariable("idUser") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO create(@RequestBody UserDTO user) {
        return service.create(user);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO update(@RequestBody UserDTO user) {
        return service.update(user);
    }

    @DeleteMapping(value = "/{idUser}")
    public ResponseEntity<?> delete(@PathVariable("idUser") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Atualizado: endpoint para login usando nameUser
    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        boolean authenticated = service.authenticate(loginDTO.getNameUser(), loginDTO.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
