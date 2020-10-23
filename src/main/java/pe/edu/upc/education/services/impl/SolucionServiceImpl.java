package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Solucion;
import pe.edu.upc.education.models.repositories.SolucionRepository;
import pe.edu.upc.education.services.SolucionService;

@Service
public class SolucionServiceImpl implements SolucionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SolucionRepository solucionRepository;
	
	@Transactional
	@Override
	public Solucion save(Solucion entity) throws Exception {
		return solucionRepository.save(entity);
	}

	@Transactional
	@Override
	public Solucion update(Solucion entity) throws Exception {
		return solucionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		solucionRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Solucion> findById(Integer id) throws Exception {
		return solucionRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Solucion> findAll() throws Exception {
		return solucionRepository.findAll();
	}

}
