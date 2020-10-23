package pe.edu.upc.education.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Ejercicio;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
	List<Ejercicio> findByNombreContaining(String nombre) throws Exception;
}