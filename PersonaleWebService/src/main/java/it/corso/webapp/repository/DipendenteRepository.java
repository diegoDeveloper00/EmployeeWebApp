package it.corso.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corso.webapp.entities.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Integer>{

	Dipendente findByIdDipendente(int idDipendente);
	
}
