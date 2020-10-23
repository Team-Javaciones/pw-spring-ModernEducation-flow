package pe.edu.upc.education.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Solucion;

@Repository
public interface SolucionRepository extends JpaRepository<Solucion, Integer> {

}
