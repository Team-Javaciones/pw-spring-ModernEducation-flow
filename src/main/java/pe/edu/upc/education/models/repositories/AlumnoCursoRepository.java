package pe.edu.upc.education.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.AlumnoCurso;

@Repository
public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Integer> {

}
