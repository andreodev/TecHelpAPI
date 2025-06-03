package br.com.TecHelpAPI.repository;

import br.com.TecHelpAPI.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Procedure(name = "Ticket.spTicketSelect")
    List<Ticket> executeTicketSelectSP( @Param("idTicket") Integer idTicket,
                                        @Param("dateTicket") LocalDate dateTicket,
                                        @Param("status") String status);

<<<<<<< HEAD

=======
//    Date date(java.sql.Date date);
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
}
