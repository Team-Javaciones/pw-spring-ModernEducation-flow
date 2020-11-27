package pe.edu.upc.education.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.education.models.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
}