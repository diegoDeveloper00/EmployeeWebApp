package it.corso.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corso.webapp.entities.DettDipendenti;
import it.corso.webapp.entities.Dipendente;

@Repository
public interface DettDipendenteRepository extends JpaRepository<DettDipendenti,Integer>{
	
	List<DettDipendenti> findBylivelloAnzianita(int livello);
	
	//@Query("SELECT d from DettDipendenti d WHERE d.idDipendente = :idDipendente")
	DettDipendenti findByidDipendente(Dipendente idDipendente);
	
}