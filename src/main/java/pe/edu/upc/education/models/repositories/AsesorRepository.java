package pe.edu.upc.education.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pe.edu.upc.education.models.entities.Asesor;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Integer> {
	List<Asesor> findByNombreCompletoContaining(String nombreCompleto) throws Exception;
	Optional<Asesor> findByUsername(String username) throws Exception;
	List<Asesor> findByCorreoContaining(String correo) throws Exception;
	Optional<Asesor> findByCorreoIs(String correo) throws Exception;
}
