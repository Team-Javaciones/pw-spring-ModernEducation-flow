package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.AlumnoAsesor;
import pe.edu.upc.education.models.repositories.AlumnoAsesorRepository;
import pe.edu.upc.education.services.AlumnoAsesorService;

@Service
public class AlumnoAsesorServiceImpl implements AlumnoAsesorService, Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private AlumnoAsesorRepository alumnoAsesorRepository;
	
	@Transactional
	@Override
	public AlumnoAsesor save(AlumnoAsesor entity) throws Exception {
		return alumnoAsesorRepository.save(entity);
	}
	
	@Transactional
	@Override
	public AlumnoAsesor update(AlumnoAsesor entity) throws Exception {
		return alumnoAsesorRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alumnoAsesorRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<AlumnoAsesor> findById(Integer id) throws Exception {
		return alumnoAsesorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<AlumnoAsesor> findAll() throws Exception {
		return alumnoAsesorRepository.findAll();
	}

}
