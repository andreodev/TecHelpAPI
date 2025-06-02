package br.com.TecHelpAPI.data.dto;

import java.util.List;
// Importe anotações de validação se for usar (ex: jakarta.validation.constraints.*)

public class CreateTicketDTO {

    private String nameTicket; // Equivalente ao 'title'
    private String description;
    private Integer requesterId; // Mantendo Integer como no seu TicketDTO para idUser
    private Integer categoryId;  // Mantendo Integer como no seu TicketDTO para idCategory
    private String coldTicket;   // O que é este campo? Ele é enviado na criação?
    private List<Long> skillIds; // Você precisa associar skills na criação do ticket?

    // Construtores, Getters e Setters

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

    public String getColdTicket() {
        return coldTicket;
    }

    public void setColdTicket(String coldTicket) {
        this.coldTicket = coldTicket;
    }

    public List<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Long> skillIds) {
        this.skillIds = skillIds;
    }
}