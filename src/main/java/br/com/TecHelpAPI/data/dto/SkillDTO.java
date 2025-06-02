package br.com.TecHelpAPI.data.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"idSkill", "nameSkill"})
public class SkillDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long idSkill;
    private String nameSkill;

    public SkillDTO(){ }

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
        if (o == null || getClass() != o.getClass()) return false;
        SkillDTO skillDTO = (SkillDTO) o;
        return Objects.equals(getIdSkill(), skillDTO.getIdSkill()) && Objects.equals(getNameSkill(), skillDTO.getNameSkill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSkill(), getNameSkill());
    }
}
