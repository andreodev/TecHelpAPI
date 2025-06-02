package br.com.TecHelpAPI.data.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {
    private String nameUser;
    private String password;

    public LoginDTO() { }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
