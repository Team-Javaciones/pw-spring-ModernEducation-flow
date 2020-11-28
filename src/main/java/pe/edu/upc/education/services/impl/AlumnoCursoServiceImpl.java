package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.AlumnoCurso;
import pe.edu.upc.education.models.repositories.AlumnoCursoRepository;
import pe.edu.upc.education.services.AlumnoCursoService;

@Service
public class AlumnoCursoServiceImpl implements AlumnoCursoService, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AlumnoCursoRepository alumnoCursoRepository;

	@Transactional
	@Override
	public AlumnoCurso save(AlumnoCurso entity) throws Exception {
		return alumnoCursoRepository.save(entity);
	}

	@Transactional
	@Override
	public AlumnoCurso update(AlumnoCurso entity) throws Exception {
		return alumnoCursoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alumnoCursoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<AlumnoCurso> findById(Integer id) throws Exception {
		return alumnoCursoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<AlumnoCurso> findAll() throws Exception {
		return alumnoCursoRepository.findAll();
	}

}
