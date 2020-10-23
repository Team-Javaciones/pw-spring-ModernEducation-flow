package pe.edu.upc.education.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
	
}
