package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.SkillDTO;
import br.com.TecHelpAPI.services.SkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillServices service;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<SkillDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{idSkill}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SkillDTO findById(@PathVariable("idSkill") Long id) {
        return service.findById(id);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SkillDTO create(@RequestBody SkillDTO skill) {
        return service.create(skill);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SkillDTO update(@RequestBody SkillDTO skill) {
        return service.update(skill);
    }

    @DeleteMapping(value = "/{idSkill}")
    public ResponseEntity<?> delete(@PathVariable("idSkill") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
