package pe.edu.upc.education.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Foro;

@Repository
public interface ForoRepository extends JpaRepository<Foro, Integer> {
	List<Foro> findByTemaContaining(String tema) throws Exception;
}
