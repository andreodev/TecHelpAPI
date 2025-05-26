package br.com.TecHelpAPI.repository;

import br.com.TecHelpAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
