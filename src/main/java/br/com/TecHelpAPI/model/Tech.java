package br.com.TecHelpAPI.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedStoredProcedureQuery(
        name = "Tech.spTechSelect",
        procedureName = "sp_Tech_Select",
        parameters = {
                @StoredProcedureParameter(name = "idTech", mode = ParameterMode.IN, type = Integer.class)
        },
        resultClasses = Tech.class
)
public class Tech {

    @Id
    @Column
    private Long idTech;

    @Column
    private String nameTech;

    @Column
    private String password;

    @Column
    private String dept;

    @Column
    private String email;

    @Column
    private String nameSkill;

    public Tech(){ }

    public Long getIdTech() {
        return idTech;
    }

    public void setIdTech(Long idTech) {
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
        if (!(o instanceof Tech tech)) return false;
        return Objects.equals(getIdTech(), tech.getIdTech()) && Objects.equals(getNameTech(), tech.getNameTech()) && Objects.equals(getPassword(), tech.getPassword()) && Objects.equals(getDept(), tech.getDept()) && Objects.equals(getEmail(), tech.getEmail()) && Objects.equals(getNameSkill(), tech.getNameSkill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTech(), getNameTech(), getPassword(), getDept(), getEmail(), getNameSkill());
    }
}
