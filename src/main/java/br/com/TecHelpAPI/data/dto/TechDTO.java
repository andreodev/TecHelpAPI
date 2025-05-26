package br.com.TecHelpAPI.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"idTech", "nameTech", "dept", "email", "nameSkill"})
public class TechDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer idTech;
    private String nameTech;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String dept;
    private String email;
    private String nameSkill;

    public TechDTO(){ }

    public Integer getIdTech() {
        return idTech;
    }

    public void setIdTech(Integer idTech) {
        this.idTech = idTech;
    }

    public String getNameTech() {
        return nameTech;
    }

    public void setNameTech(String nameTech) {
        this.nameTech = nameTech;
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

    public String getNameSkill() {
        return nameSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TechDTO techDTO = (TechDTO) o;
        return Objects.equals(getIdTech(), techDTO.getIdTech()) && Objects.equals(getNameTech(), techDTO.getNameTech()) && Objects.equals(getPassword(), techDTO.getPassword()) && Objects.equals(getDept(), techDTO.getDept()) && Objects.equals(getEmail(), techDTO.getEmail()) && Objects.equals(getNameSkill(), techDTO.getNameSkill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTech(), getNameTech(), getPassword(), getDept(), getEmail(), getNameSkill());
    }
}
