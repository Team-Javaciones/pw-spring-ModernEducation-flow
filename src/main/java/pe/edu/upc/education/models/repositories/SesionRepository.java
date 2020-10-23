package pe.edu.upc.education.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer> {
	List<Sesion> findByTemaContaining(String tema) throws Exception;
}
