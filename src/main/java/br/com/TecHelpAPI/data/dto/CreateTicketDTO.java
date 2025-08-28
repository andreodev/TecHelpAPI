package br.com.TecHelpAPI.data.dto;

import java.time.LocalDate;

public class CreateTicketDTO {

    private String nameTicket;
    private String description;
    private Integer requesterId;
    private Integer categoryId;
    private LocalDate dateTicket; // Pode ser null, service define hoje se não enviado
    private String status;        // Pode ser null, service define "Aberto" se não enviado

    // Getters e Setters
    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Integer requesterId) {
        this.requesterId = requesterId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(LocalDate dateTicket) {
        this.dateTicket = dateTicket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
