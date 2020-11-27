package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.models.repositories.UsuarioRepository;
import pe.edu.upc.education.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements  UsuarioService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Transactional
	@Override
	public Usuario save(Usuario entity) throws Exception {		
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public Usuario update(Usuario entity) throws Exception {		
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		usuarioRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		return usuarioRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() throws Exception {
		return usuarioRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findByUsername(String username) throws Exception {
		return usuarioRepository.findByUsername(username);
	}
}
