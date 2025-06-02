package br.com.TecHelpAPI.data.dto;

public class LoginResponseDTO {
    private String token;
    private String nameUser;
    private String email;

    // Construtor
    public LoginResponseDTO(String token, String nameUser) {
        this.token = token;
        this.nameUser = nameUser;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getEmail() {
        return email;
    }
}
