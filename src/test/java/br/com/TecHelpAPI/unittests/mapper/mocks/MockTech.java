package br.com.TecHelpAPI.unittests.mapper.mocks;

import br.com.TecHelpAPI.data.dto.TechDTO;
import br.com.TecHelpAPI.model.Tech;

import java.util.ArrayList;
import java.util.List;

public class MockTech {


    public Tech mockEntity() {
        return mockEntity(0);
    }

    public TechDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Tech> mockEntityList() {
        List<Tech> Techs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Techs.add(mockEntity(i));
        }
        return Techs;
    }

    public List<TechDTO> mockDTOList() {
        List<TechDTO> Techs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Techs.add(mockDTO(i));
        }
        return Techs;
    }

    public Tech mockEntity(Integer number) {
        Tech tech = new Tech();
        tech.setIdTech((long) number);
        tech.setNameTech("Tech Name Test" + number);
        tech.setPassword("Tech Password Test" + number);
        tech.setDept("Tech Dept Test" + number);
        tech.setEmail("Tech Email Test" + number);
        return tech;
    }

    public TechDTO mockDTO(Integer number) {
        TechDTO tech = new TechDTO();
        tech.setIdTech(number);
        tech.setNameTech("Tech Name Test" + number);
        tech.setPassword("Tech Password Test" + number);
        tech.setDept("Tech Dept Test" + number);
        tech.setEmail("Tech Email Test" + number);
        return tech;
    }

}