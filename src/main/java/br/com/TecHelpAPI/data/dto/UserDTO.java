package br.com.TecHelpAPI.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"idUser", "nameUser", "dept", "email"})
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long idUser;
    private String nameUser;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String dept;
    private String email;

    public UserDTO(){ }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserDTO userDTO)) return false;
        return Objects.equals(getIdUser(), userDTO.getIdUser()) && Objects.equals(getNameUser(), userDTO.getNameUser()) && Objects.equals(getPassword(), userDTO.getPassword()) && Objects.equals(getDept(), userDTO.getDept()) && Objects.equals(getEmail(), userDTO.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getNameUser(), getPassword(), getDept(), getEmail());
    }
}
