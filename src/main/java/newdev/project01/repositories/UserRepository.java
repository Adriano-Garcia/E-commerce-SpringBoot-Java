package newdev.project01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import newdev.project01.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
