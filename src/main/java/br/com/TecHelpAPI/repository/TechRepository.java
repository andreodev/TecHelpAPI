package br.com.TecHelpAPI.repository;

import br.com.TecHelpAPI.model.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechRepository extends JpaRepository<Tech, Long> {

    @Procedure(name = "Tech.spTechSelect")
    List<Tech> executeTechSelectSP(@Param("idTech") Integer idTech);

}
