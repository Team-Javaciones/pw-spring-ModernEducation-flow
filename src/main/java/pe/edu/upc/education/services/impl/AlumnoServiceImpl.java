package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.repositories.AlumnoRepository;
import pe.edu.upc.education.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Transactional
	@Override
	public Alumno save(Alumno entity) throws Exception {		
		return alumnoRepository.save(entity);
	}

	@Transactional
	@Override
	public Alumno update(Alumno entity) throws Exception {		
		return alumnoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alumnoRepository.deleteById(id);
	}

	@Override
	public Optional<Alumno> findById(Integer id) throws Exception {
		return alumnoRepository.findById(id);
	}

	@Override
	public List<Alumno> findAll() throws Exception {
		return alumnoRepository.findAll();
	}

	@Override
	public List<Alumno> findByEntidadEducativa(String entidadEducativa) throws Exception {
		return alumnoRepository.findByEntidadEducativaContaining(entidadEducativa);
	}

	@Override
	public List<Alumno> findByNombreCompleto(String nombreCompleto) throws Exception {		
		return alumnoRepository.findByNombreCompletoContaining(nombreCompleto);
	}

	@Override
	public Optional<Alumno> findByUsername(String username) throws Exception {
		return alumnoRepository.findByUsername(username);
	}

}
