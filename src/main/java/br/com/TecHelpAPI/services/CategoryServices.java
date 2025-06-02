package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.data.dto.CategoryDTO;
import br.com.TecHelpAPI.exception.ResourceNotFoundException;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;
import br.com.TecHelpAPI.model.Category;
import br.com.TecHelpAPI.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoryServices {

    private final Logger logger = LoggerFactory.getLogger(CategoryServices.class.getName());

    @Autowired
    CategoryRepository repository;

    public List<CategoryDTO> findAll(){
        logger.info("Finding all categories!");

        return parseListObjects(repository.findAll(), CategoryDTO.class);
    }

    public CategoryDTO findById(Long id){
        logger.info("Finding one category!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        return parseObject(entity, CategoryDTO.class);
    }

    public CategoryDTO create(CategoryDTO category){
        logger.info("Create one user!");

        var entity = parseObject(category, Category.class);

        return parseObject(repository.save(entity), CategoryDTO.class);
    }

    public CategoryDTO update(CategoryDTO category){
        logger.info("Updating one category!");
        Category entity = repository.findById(category.getIdCategory())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setNameCategory(category.getNameCategory());

        return parseObject(repository.save(entity), CategoryDTO.class);
    }

    public void delete(Long id){
        logger.info("Delete one category!");

        Category entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

}
