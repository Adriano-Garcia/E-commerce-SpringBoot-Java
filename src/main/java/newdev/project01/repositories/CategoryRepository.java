package newdev.project01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import newdev.project01.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}
