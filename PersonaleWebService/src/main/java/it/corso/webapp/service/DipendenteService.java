package it.corso.webapp.service;

import java.util.List;

import it.corso.webapp.entities.Dipendente;

public interface DipendenteService {

	List<Dipendente> findAll();
	
	Dipendente findByIdDipendente(int idDipendente);
	
	public void insert(Dipendente dipendente);

	public void update(Dipendente dipendente);
	
	public void remove(Dipendente dipendente);
	
}
