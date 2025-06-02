package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.data.dto.SkillDTO;
import br.com.TecHelpAPI.exception.ResourceNotFoundException;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;
import br.com.TecHelpAPI.model.Skill;
import br.com.TecHelpAPI.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SkillServices {

    private final Logger logger = LoggerFactory.getLogger(SkillServices.class.getName());

    @Autowired
    SkillRepository repository;

    public List<SkillDTO> findAll(){
        logger.info("Finding all skills!");

        return parseListObjects(repository.findAll(), SkillDTO.class);
    }

    public SkillDTO findById(Long id){
        logger.info("Finding one skill!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        return parseObject(entity, SkillDTO.class);
    }

    public SkillDTO create(SkillDTO skill){
        logger.info("Create one user!");

        var entity = parseObject(skill, Skill.class);

        return parseObject(repository.save(entity), SkillDTO.class);
    }

    public SkillDTO update(SkillDTO skill){
        logger.info("Updating one skill!");
        Skill entity = repository.findById(skill.getIdSkill())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setNameSkill(skill.getNameSkill());

        return parseObject(repository.save(entity), SkillDTO.class);
    }

    public void delete(Long id){
        logger.info("Delete one skill!");

        Skill entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

}
