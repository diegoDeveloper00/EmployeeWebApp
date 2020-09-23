package it.corso.webapp.service;

import it.corso.webapp.entities.Utente;

public interface UtenteService {
	
	public void insert(Utente utente);

	public void update(Utente utente);
	
	public void remove(Utente utente);
	
	Utente findByUsername(String username);
	
}
