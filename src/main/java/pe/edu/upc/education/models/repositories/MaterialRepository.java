package pe.edu.upc.education.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
	List<Material> findByNombreContaining(String nombre) throws Exception; 
}
