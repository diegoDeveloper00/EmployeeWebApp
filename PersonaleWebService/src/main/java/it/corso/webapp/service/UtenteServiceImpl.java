package it.corso.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.webapp.entities.Utente;
import it.corso.webapp.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	private UtenteRepository utenteRepository;
	

	@Override
	public void insert(Utente utente) {
		utenteRepository.save(utente);
		
	}

	@Override
	public void update(Utente utente) {
		utenteRepository.flush();
		
	}

	@Override
	public void remove(Utente utente) {
		utenteRepository.delete(utente);
	}

	@Override
	public Utente findByUsername(String username) {
		
		return utenteRepository.findByUsername(username);
	}

	
	
}
