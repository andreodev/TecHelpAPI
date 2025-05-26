package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.CategoryDTO;
import br.com.TecHelpAPI.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServices service;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CategoryDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{idCategory}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoryDTO findById(@PathVariable("idCategory") Long id) {
        return service.findById(id);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoryDTO create(@RequestBody CategoryDTO category) {
        return service.create(category);
    }

    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CategoryDTO update(@RequestBody CategoryDTO category) {
        return service.update(category);
    }

    @DeleteMapping(value = "/{idCategory}")
    public ResponseEntity<?> delete(@PathVariable("idCategory") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
