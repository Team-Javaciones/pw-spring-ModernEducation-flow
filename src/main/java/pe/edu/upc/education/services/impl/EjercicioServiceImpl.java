package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.models.repositories.EjercicioRepository;
import pe.edu.upc.education.services.EjercicioService;

@Service
public class EjercicioServiceImpl implements EjercicioService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	@Transactional
	@Override
	public Ejercicio save(Ejercicio entity) throws Exception {
		return ejercicioRepository.save(entity);
	}

	@Transactional
	@Override
	public Ejercicio update(Ejercicio entity) throws Exception {
		return ejercicioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		ejercicioRepository.deleteById(id);
	}

	@Override
	public Optional<Ejercicio> findById(Integer id) throws Exception {
		return ejercicioRepository.findById(id);
	}

	@Override
	public List<Ejercicio> findAll() throws Exception {
		return ejercicioRepository.findAll();
	}

	@Override
	public List<Ejercicio> findByNombre(String nombre) throws Exception {
		return ejercicioRepository.findByNombreContaining(nombre);
	}

}
