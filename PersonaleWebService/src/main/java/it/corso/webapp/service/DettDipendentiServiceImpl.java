package it.corso.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.webapp.entities.DettDipendenti;
import it.corso.webapp.entities.Dipendente;
import it.corso.webapp.repository.DettDipendenteRepository;

@Service
@Transactional
public class DettDipendentiServiceImpl implements DettDipendenteService{

	@Autowired
	private DettDipendenteRepository dettDipendentiRepository;
	
	@Override
	public List<DettDipendenti> findBylivelloAnzianita(int livello) {
		
		return dettDipendentiRepository.findBylivelloAnzianita(livello);
	}

	@Override
	public List<DettDipendenti> findAll() {
		return dettDipendentiRepository.findAll();
	}

	@Override
	public void insert(DettDipendenti detail) {
		dettDipendentiRepository.save(detail);

	}

	@Override
	public void remove(DettDipendenti detail) {

		dettDipendentiRepository.delete(detail);
		
	}

	@Override
	public void update(DettDipendenti detail) {
	
		dettDipendentiRepository.flush();
		
	}

	@Override
	public DettDipendenti findByidDipendente(Dipendente idDipendente) {
		return  dettDipendentiRepository.findByidDipendente(idDipendente);
	}

}
