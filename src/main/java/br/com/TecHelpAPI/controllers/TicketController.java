package br.com.TecHelpAPI.controllers;

import br.com.TecHelpAPI.data.dto.TicketDTO;
import br.com.TecHelpAPI.services.TicketServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private final TicketServices service;

    @Autowired
    public TicketController(TicketServices service) {
        this.service = service;
    }

    @PostMapping("/search")
    public ResponseEntity<List<TicketDTO>> getTicketData(@RequestBody TicketDTO request) {
        logger.info("Requisição recebida no Controller - idTicket: {}, dateTicket: {}, status: {}",
                request.getIdTicket(), request.getDateTicket(), request.getStatus());

        List<TicketDTO> tickets = service.getTicketData(
                request.getIdTicket(),
                request.getDateTicket(),
                request.getStatus()
        );

        return ResponseEntity.ok(tickets);
    }
}
