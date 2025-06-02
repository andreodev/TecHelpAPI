package br.com.TecHelpAPI.data.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"idCategory", "nameCategory"})
public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long idCategory;
    private String nameCategory;

    public CategoryDTO(){ }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO CategoryDTO = (CategoryDTO) o;
        return Objects.equals(getIdCategory(), CategoryDTO.getIdCategory()) && Objects.equals(getNameCategory(), CategoryDTO.getNameCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCategory(), getNameCategory());
    }
}
