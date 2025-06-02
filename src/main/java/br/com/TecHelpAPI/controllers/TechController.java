package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.TechDTO;
import br.com.TecHelpAPI.services.TechServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tech")
public class TechController {

    private final TechServices service;

    @Autowired
    public TechController(TechServices service) {
        this.service = service;
    }

    @PostMapping
    public List<TechDTO> getTechData(@RequestBody TechDTO request) {
        return service.getTechDataById(request.getIdTech());
    }
}
