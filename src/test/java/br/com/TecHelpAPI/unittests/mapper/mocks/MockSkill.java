package br.com.TecHelpAPI.unittests.mapper.mocks;

import br.com.TecHelpAPI.data.dto.SkillDTO;
import br.com.TecHelpAPI.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class MockSkill {


    public Skill mockEntity() {
        return mockEntity(0);
    }

    public SkillDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Skill> mockEntityList() {
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            skills.add(mockEntity(i));
        }
        return skills;
    }

    public List<SkillDTO> mockDTOList() {
        List<SkillDTO> skills = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            skills.add(mockDTO(i));
        }
        return skills;
    }

    public Skill mockEntity(Integer number) {
        Skill Skill = new Skill();
        Skill.setIdSkill(number.longValue());
        Skill.setNameSkill("Skill Name Test" + number);
        return Skill;
    }

    public SkillDTO mockDTO(Integer number) {
        SkillDTO Skill = new SkillDTO();
        Skill.setIdSkill(number.longValue());
        Skill.setNameSkill("Skill Name Test" + number);
        return Skill;
    }

}