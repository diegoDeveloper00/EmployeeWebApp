package it.corso.webapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.webapp.entities.Ruolo;
import it.corso.webapp.repository.RuoloRepository;

@Service
@Transactional
public class RuoloServiceImpl implements RuoloService{

	@Autowired
	private RuoloRepository ruoloRepository;
	
	@Override
	public Ruolo findByDescrizione(String descrizione) {
		return ruoloRepository.findByDescrizione(descrizione);
	}

}
