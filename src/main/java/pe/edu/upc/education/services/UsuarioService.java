package pe.edu.upc.education.services;

import java.util.Optional;

import pe.edu.upc.education.models.entities.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer>{

	Optional<Usuario> findByUsername(String username) throws Exception;
}
