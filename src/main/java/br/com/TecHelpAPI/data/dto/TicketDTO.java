package br.com.TecHelpAPI.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TicketDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer idTicket;
    private String nameTicket;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTicket;

    private Integer idUser;
    private String description;
    private Integer idCategory;
    private String status;
    private String nameUser;
    private String nameCategory;

    public TicketDTO() {}

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

//    public String getColdTicket() {
//        return coldTicket;
//    }
//
//    public void setColdTicket(String coldTicket) {
//        this.coldTicket = coldTicket;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 🔥 faltava isso
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(idTicket, ticketDTO.idTicket) &&
                Objects.equals(nameTicket, ticketDTO.nameTicket) &&
                Objects.equals(dateTicket, ticketDTO.dateTicket) &&
                Objects.equals(idUser, ticketDTO.idUser) &&
                Objects.equals(description, ticketDTO.description) &&
                Objects.equals(idCategory, ticketDTO.idCategory) &&
                Objects.equals(status, ticketDTO.status) &&
                Objects.equals(nameUser, ticketDTO.nameUser) &&
                Objects.equals(nameCategory, ticketDTO.nameCategory);
//                Objects.equals(coldTicket, ticketDTO.coldTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTicket, nameTicket, dateTicket, idUser, description, idCategory, status, nameUser, nameCategory);
    }
}
