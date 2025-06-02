package br.com.TecHelpAPI.unittests.mapper.mocks;

import br.com.TecHelpAPI.data.dto.TicketDTO;
import br.com.TecHelpAPI.model.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockTicket {

    public Ticket mockEntity() {
        return mockEntity(0);
    }

    public TicketDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Ticket> mockEntityList() {
        List<Ticket> Techs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Techs.add(mockEntity(i));
        }
        return Techs;
    }

    public List<TicketDTO> mockDTOList() {
        List<TicketDTO> Techs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Techs.add(mockDTO(i));
        }
        return Techs;
    }

    public Ticket mockEntity(Integer number) {
        Ticket ticket = new Ticket();
        ticket.setIdTicket(number);
        ticket.setNameTicket("Ticket Name Test" + number);
        ticket.setDateTicket(LocalDate.parse("Ticket Date Test" + number));
        ticket.setIdUser(number);
        ticket.setDescription("Ticket Description Test" + number);
        ticket.setIdCategory(number);
        ticket.setStatus("Ticket Status Test" + number);
        ticket.setNameUser("Ticket NameUser Test" + number);
        ticket.setNameCategory("Ticket NameCategory Test" + number);
        return ticket;
    }

    public TicketDTO mockDTO(Integer number) {
        TicketDTO ticket = new TicketDTO();
        ticket.setIdTicket(number);
        ticket.setNameTicket("Ticket Name Test" + number);
        ticket.setDateTicket(LocalDate.parse("Ticket Date Test" + number));
        ticket.setIdUser(number);
        ticket.setDescription("Ticket Description Test" + number);
        ticket.setIdCategory(number);
        ticket.setStatus("Ticket Status Test" + number);
        ticket.setNameUser("Ticket NameUser Test" + number);
        ticket.setNameCategory("Ticket NameCategory Test" + number);
        return ticket;
    }

}