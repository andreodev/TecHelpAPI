package br.com.TecHelpAPI.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Skill")
public class Skill implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSkill;

    @Column(nullable = false, length = 50)
    private String nameSkill;

    public Skill(){ }

    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Skill skill)) return false;
        return Objects.equals(getIdSkill(), skill.getIdSkill()) && Objects.equals(getNameSkill(), skill.getNameSkill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSkill(), getNameSkill());
    }
}
