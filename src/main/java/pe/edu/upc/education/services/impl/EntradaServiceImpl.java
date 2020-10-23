package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Entrada;
import pe.edu.upc.education.models.repositories.EntradaRepository;
import pe.edu.upc.education.services.EntradaService;


public class EntradaServiceImpl implements EntradaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Transactional
	@Override
	public Entrada save(Entrada entity) throws Exception {
		return entradaRepository.save(entity);
	}

	@Transactional
	@Override
	public Entrada update(Entrada entity) throws Exception {
		return entradaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		entradaRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Entrada> findById(Integer id) throws Exception {
		return entradaRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Entrada> findAll() throws Exception {
		return entradaRepository.findAll();
	}
}
