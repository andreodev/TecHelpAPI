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
                @StoredProcedureParameter(name = "dateTicket", mode = ParameterMode.IN, type = LocalDate.class),
                @StoredProcedureParameter(name = "status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "coldTicket", mode = ParameterMode.IN, type = String.class)
        },
        resultClasses = Ticket.class
)
<<<<<<< HEAD
@Table(name = "Ticket", schema = "dbo")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket")
    private Integer idTicket;

    @Column(name = "nameTicket", nullable = false)
    @Size(max = 100, message = "O nome do ticket não pode exceder 100 caracteres")
    private String nameTicket;

    @Column(name = "dateTicket", nullable = false)
    private LocalDate dateTicket;

    @Column(name = "idUser", nullable = false)
    private Integer idUser;

    @Column(name = "description", length = 800)
    @Size(max = 800, message = "A descrição não pode exceder 800 caracteres")
    private String description;

    @Column(name = "idCategory", nullable = false)
    private Integer idCategory;

    @Column(name = "status", nullable = false)
    @Size(max = 15, message = "O status não pode exceder 15 caracteres")
    private String status;

    @Transient
    @Size(max = 100, message = "O nome do usuário não pode exceder 100 caracteres")
    private String nameUser;

    @Transient
    @Size(max = 100, message = "O nome da categoria não pode exceder 100 caracteres")
    private String nameCategory;

    @Column(name = "ColdTicket", length = 10)
    @Size(max = 10, message = "O ColdTicket não pode exceder 10 caracteres")
=======
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "id_ticket")
    private Integer idTicket;

    @Column(name = "name_ticket", nullable = false)
    @Size(max = 100, message = "O nome do ticket não pode exceder 100 caracteres")
    private String nameTicket;

    @Column(name = "date_ticket", nullable = false)
    private LocalDate dateTicket;

    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(length = 500)
    @Size(max = 500, message = "A descrição não pode exceder 500 caracteres")
    private String description;

    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(nullable = false)
    @Size(max = 50, message = "O status não pode exceder 50 caracteres")
    private String status;

    @Column(name = "name_user")
    @Size(max = 100, message = "O nome do usuário não pode exceder 100 caracteres")
    private String nameUser;

    @Column(name = "name_category")
    @Size(max = 100, message = "O nome da categoria não pode exceder 100 caracteres")
    private String nameCategory;

    @Column(name = "cold_ticket", length = 100)
    @Size(max = 100, message = "O ColdTicket não pode exceder 100 caracteres")
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
    private String coldTicket;

    public Ticket() {}

<<<<<<< HEAD

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

    public String getColdTicket() { return coldTicket; }
    public void setColdTicket(String coldTicket) { this.coldTicket = coldTicket; }
=======
    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public LocalDate getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(LocalDate dateTicket) {
        this.dateTicket = dateTicket;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getColdTicket() {
        return coldTicket;
    }

    public void setColdTicket(String coldTicket) {
        this.coldTicket = coldTicket;
    }
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
<<<<<<< HEAD
        return Objects.equals(idTicket, ticket.idTicket);
=======
        return Objects.equals(idTicket, ticket.idTicket) &&
                Objects.equals(nameTicket, ticket.nameTicket) &&
                Objects.equals(dateTicket, ticket.dateTicket) &&
                Objects.equals(idUser, ticket.idUser) &&
                Objects.equals(description, ticket.description) &&
                Objects.equals(idCategory, ticket.idCategory) &&
                Objects.equals(status, ticket.status) &&
                Objects.equals(nameUser, ticket.nameUser) &&
                Objects.equals(nameCategory, ticket.nameCategory) &&
                Objects.equals(coldTicket, ticket.coldTicket);
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(idTicket);
=======
        return Objects.hash(idTicket, nameTicket, dateTicket, idUser, description,
                idCategory, status, nameUser, nameCategory, coldTicket);
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
    }
}
