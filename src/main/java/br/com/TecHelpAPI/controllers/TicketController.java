package br.com.TecHelpAPI.controllers;

<<<<<<< HEAD
import br.com.TecHelpAPI.data.dto.CreateTicketDTO; // Importar o DTO de criação
=======
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
import br.com.TecHelpAPI.data.dto.TicketDTO;
import br.com.TecHelpAPI.services.TicketServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus; // Importar HttpStatus
=======
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/ticket") // Caminho base: /techelp/api/ticket
=======
@RequestMapping("/ticket")
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private final TicketServices service;

    @Autowired
    public TicketController(TicketServices service) {
        this.service = service;
    }

<<<<<<< HEAD

    @PostMapping("/search")
    public ResponseEntity<List<TicketDTO>> getTicketData(@RequestBody TicketDTO request) {
        logger.info("Controller: Requisição /search recebida - idTicket: {}, dateTicket: {}, status: {}",
=======
    @PostMapping("/search")
    public ResponseEntity<List<TicketDTO>> getTicketData(@RequestBody TicketDTO request) {
        logger.info("Requisição recebida no Controller - idTicket: {}, dateTicket: {}, status: {}",
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
                request.getIdTicket(), request.getDateTicket(), request.getStatus());

        List<TicketDTO> tickets = service.getTicketData(
                request.getIdTicket(),
                request.getDateTicket(),
                request.getStatus()
        );

        return ResponseEntity.ok(tickets);
    }
<<<<<<< HEAD


    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody CreateTicketDTO createTicketDTO) {

        logger.info("Controller: Recebida requisição para criar novo ticket com título: {}", createTicketDTO.getNameTicket());


        TicketDTO createdTicket = service.createTicket(createTicketDTO);


        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }
}
=======
}
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
