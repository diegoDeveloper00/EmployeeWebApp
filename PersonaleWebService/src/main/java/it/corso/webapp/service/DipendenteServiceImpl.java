package it.corso.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.webapp.entities.Dipendente;
import it.corso.webapp.repository.DipendenteRepository;

@Service
@Transactional
public class DipendenteServiceImpl implements DipendenteService{

	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Override
	public Dipendente findByIdDipendente(int idDipendente) {

		return dipendenteRepository.findByIdDipendente(idDipendente);
	}

	@Override
	public List<Dipendente> findAll() {
		return dipendenteRepository.findAll();
	}

	@Override
	public void insert(Dipendente dipendente) {
	
		dipendenteRepository.save(dipendente);
		
	}

	@Override
	public void update(Dipendente dipendente) {
		dipendenteRepository.flush();
	}

	@Override
	public void remove(Dipendente dipendente) {
		dipendenteRepository.delete(dipendente);
	}
	
}
