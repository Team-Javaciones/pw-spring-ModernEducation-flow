package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.models.repositories.SesionRepository;
import pe.edu.upc.education.services.SesionService;

@Service
public class SesionServiceImpl implements SesionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SesionRepository sesionRepository;
	
	@Transactional
	@Override
	public Sesion save(Sesion entity) throws Exception {
		return sesionRepository.save(entity);
	}

	@Transactional
	@Override
	public Sesion update(Sesion entity) throws Exception {
		return sesionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		sesionRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Sesion> findById(Integer id) throws Exception {
		return sesionRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Sesion> findAll() throws Exception {
		return sesionRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Sesion> findByTema(String tema) throws Exception {
		return sesionRepository.findByTemaContaining(tema);
	}

}
