package pe.edu.upc.education.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Unidad;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
	List<Unidad> findByNombreContaining(String nombre) throws Exception; 
}
