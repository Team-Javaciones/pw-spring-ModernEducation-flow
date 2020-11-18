package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.models.repositories.CursoRepository;
import pe.edu.upc.education.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Transactional
	@Override
	public Curso save(Curso entity) throws Exception {
		return cursoRepository.save(entity);
	}

	@Transactional
	@Override
	public Curso update(Curso entity) throws Exception {
		return cursoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		cursoRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Curso> findById(Integer id) throws Exception {
		return cursoRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Curso> findAll() throws Exception {
		return cursoRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Curso> findByNombre(String nombre) throws Exception {
		return cursoRepository.findByNombreContaining(nombre);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Curso> findByPopularidad(Float popularidad) throws Exception {
		return cursoRepository.findByPopularidadGreaterThanEqual(popularidad);
	}
	@Transactional(readOnly = true)
	public List<Curso> findByPrecio(Float precio) throws Exception {
		return cursoRepository.findByPrecioLessThanEqual(precio);
	}
}
