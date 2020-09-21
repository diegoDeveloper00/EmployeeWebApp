package it.corso.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corso.webapp.entities.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo,Long>{

	Ruolo findByDescrizione(String descrizione);
	
}
