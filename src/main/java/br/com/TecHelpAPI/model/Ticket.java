package br.com.TecHelpAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NamedStoredProcedureQuery(
        name = "Ticket.spTicketSelect",
        procedureName = "sp_Ticket_Select",
        parameters = {
                @StoredProcedureParameter(name = "idTicket", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "dateTicket", mode = ParameterMode.IN, type = java.sql.Date.class),
                @StoredProcedureParameter(name = "status", mode = ParameterMode.IN, type = String.class)
        },
        resultClasses = Ticket.class
)

@NamedStoredProcedureQuery(
        name = "Ticket.spTicketInsert",
        procedureName = "sp_Ticket_Insert",
        parameters = {
                @StoredProcedureParameter(name = "nameTicket", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "dateTicket", mode = ParameterMode.IN, type = java.sql.Date.class),
                @StoredProcedureParameter(name = "idUser", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "description", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "idCategory", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "status", mode = ParameterMode.IN, type = String.class)
        },
        resultClasses = Ticket.class
)

@Table(name = "Ticket", schema = "dbo")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket")
    private Integer idTicket;

    @Column(name = "nameTicket", nullable = false)
    @Size(max = 100)
    private String nameTicket;

    @Column(name = "dateTicket", nullable = false)
    private LocalDate dateTicket;

    @Column(name = "idUser", nullable = false)
    private Integer idUser;

    @Column(name = "description", length = 800)
    @Size(max = 800)
    private String description;

    @Column(name = "idCategory", nullable = false)
    private Integer idCategory;

    @Column(name = "status", nullable = false)
    @Size(max = 15)
    private String status;

    @Column(name = "nameUser", length = 100)
    @Size(max = 100)
//    @Transient
    private String nameUser;

    @Column(name = "nameCategory", length = 100)
    @Size(max = 100)
    private String nameCategory;

//    @Column(name = "coldTicket", length = 10)
//    @Size(max = 10)
//    private String coldTicket;

    public Ticket() {}

    // Getters e setters
    public Integer getIdTicket() { return idTicket; }
    public void setIdTicket(Integer idTicket) { this.idTicket = idTicket; }

    public String getNameTicket() { return nameTicket; }
    public void setNameTicket(String nameTicket) { this.nameTicket = nameTicket; }

    public LocalDate getDateTicket() { return dateTicket; }
    public void setDateTicket(LocalDate dateTicket) { this.dateTicket = dateTicket; }

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getIdCategory() { return idCategory; }
    public void setIdCategory(Integer idCategory) { this.idCategory = idCategory; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNameUser() { return nameUser; }
    public void setNameUser(String nameUser) { this.nameUser = nameUser; }

    public String getNameCategory() { return nameCategory; }
    public void setNameCategory(String nameCategory) { this.nameCategory = nameCategory; }

//    public String getColdTicket() { return coldTicket; }
//    public void setColdTicket(String coldTicket) { this.coldTicket = coldTicket; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(idTicket, ticket.idTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTicket);
    }
}
