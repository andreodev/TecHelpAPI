package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.TechDTO;
import br.com.TecHelpAPI.services.TechServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/tech")
public class TechController {

    private static final Logger logger = LoggerFactory.getLogger(TechController.class);

    private final TechServices service;

    @Autowired
    public TechController(TechServices service) {
        this.service = service;
    }

    @PostMapping
    public List<TechDTO> getTechData(@RequestBody TechDTO request) {
        logger.info("Requisição recebida para buscar técnico idTech={}", request.getIdTech());
        List<TechDTO> result = service.getTechDataById(request.getIdTech());
        logger.info("Total de técnicos encontrados: {}", result.size());
        return result;
    }
}

