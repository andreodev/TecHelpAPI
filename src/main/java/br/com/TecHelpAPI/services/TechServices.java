package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.data.dto.TechDTO;
import br.com.TecHelpAPI.model.Tech;
import br.com.TecHelpAPI.repository.TechRepository;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechServices {

    private static final Logger logger = LoggerFactory.getLogger(TechServices.class.getName());

    private final TechRepository repository;

    @Autowired
    public TechServices(TechRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TechDTO> getTechDataById(Integer idTech) {

        logger.info("Iniciando busca de Técnico no banco de dados - idTech: {}", idTech);

         List<Tech> tech = repository.executeTechSelectSP(idTech);

        if (tech.isEmpty()) {
            logger.warn("Nenhum técnico encontrado para o parâmetro: idTech: {}", idTech);
        } else {
            logger.info("Total de técnico(s) encontrado(s): {}", tech.size());
        }

        return parseListObjects(tech, TechDTO.class);

    }

}
