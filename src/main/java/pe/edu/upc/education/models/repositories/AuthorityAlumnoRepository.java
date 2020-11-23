package pe.edu.upc.education.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.education.models.entities.AuthorityAsesor;

public interface AuthorityAlumnoRepository  extends JpaRepository<AuthorityAsesor, Long> {

}
