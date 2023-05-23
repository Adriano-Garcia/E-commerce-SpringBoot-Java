package newdev.project01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import newdev.project01.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
