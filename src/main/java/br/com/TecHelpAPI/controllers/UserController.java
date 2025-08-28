package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.data.dto.LoginDTO;
import br.com.TecHelpAPI.model.User;
import br.com.TecHelpAPI.services.UserServices;
import br.com.TecHelpAPI.config.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO findById(@PathVariable("idUser") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getMe(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(401).build();
            }

            String token = authHeader.substring(7);
            Claims claims = JwtUtil.validateToken(token);
            Long userId = claims.get("id", Long.class);

            if (userId == null) {
                return ResponseEntity.status(401).build();
            }

            UserDTO user = service.findById(userId);
            return ResponseEntity.ok(user);

        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO create(@RequestBody UserDTO user) {
        return service.create(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO update(@RequestBody UserDTO user) {
        return service.update(user);
    }

    @DeleteMapping(value = "/{idUser}")
    public ResponseEntity<?> delete(@PathVariable("idUser") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = service.authenticateAndGetUser(loginDTO.getNameUser(), loginDTO.getPassword());

        if (user != null) {
            String token = JwtUtil.generateToken(user);
            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "nameUser", user.getNameUser()
            ));
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}
