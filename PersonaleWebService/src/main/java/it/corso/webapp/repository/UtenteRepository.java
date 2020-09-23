package it.corso.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corso.webapp.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	Utente findByUsername(String username);
	
	
	
}
