package newdev.project01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import newdev.project01.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
