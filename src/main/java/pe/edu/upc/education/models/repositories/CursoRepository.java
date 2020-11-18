package pe.edu.upc.education.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	List<Curso> findByNombreContaining(String nombre) throws Exception; 
	List<Curso> findByPopularidadGreaterThanEqual(Float popularidad) throws Exception; 
	List<Curso> findByPrecioLessThanEqual(Float precio) throws Exception; 
}