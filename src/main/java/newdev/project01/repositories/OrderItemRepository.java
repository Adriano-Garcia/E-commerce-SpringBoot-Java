package newdev.project01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import newdev.project01.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
