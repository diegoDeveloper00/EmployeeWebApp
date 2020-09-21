package it.corso.webapp.service;

import it.corso.webapp.entities.Ruolo;

public interface RuoloService {

	Ruolo findByDescrizione(String descrizione);
	
}
