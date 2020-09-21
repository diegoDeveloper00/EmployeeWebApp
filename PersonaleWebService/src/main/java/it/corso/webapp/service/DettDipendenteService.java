package it.corso.webapp.service;

import java.util.List;

import it.corso.webapp.entities.DettDipendenti;
import it.corso.webapp.entities.Dipendente;

public interface DettDipendenteService {

	List<DettDipendenti> findBylivelloAnzianita(int livello);
	
	List<DettDipendenti> findAll();
	
	public void insert(DettDipendenti detail);
	
	public void remove(DettDipendenti detail);
	
	public void update(DettDipendenti detail);
	
	DettDipendenti findByidDipendente(Dipendente idDipendente);
	
}
