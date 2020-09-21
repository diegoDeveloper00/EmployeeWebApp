package it.corso.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corso.webapp.entities.DettDipendenti;
import it.corso.webapp.entities.Dipendente;
import it.corso.webapp.service.DettDipendenteService;

@RestController
@RequestMapping("/api/dettDipendente")
public class DettDipendenteController {

	@Autowired
	private DettDipendenteService dettDipendenteService;
	
	@GetMapping(value="/livello/{livelloAnzianita}",produces = "application/json")
	public ResponseEntity<List<DettDipendenti>> getDipendenteByLivello(@PathVariable("livelloAnzianita") int livello){
		
		List<DettDipendenti> details=dettDipendenteService.findBylivelloAnzianita(livello);
		
		if(details.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DettDipendenti>>(details,HttpStatus.OK);
	}
	
	@GetMapping(value="/dettaglio/{idDipendente}",produces = "application/json")
	public ResponseEntity<?> getDettDipendenteById(@PathVariable(required = true,name="idDipendente") Dipendente idDipendente){
		
		DettDipendenti detail=dettDipendenteService.findByidDipendente(idDipendente);
		if(detail!=null) {
			return new ResponseEntity<>(detail,HttpStatus.OK);
			
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<DettDipendenti>> getAllDetails(){
		
		List<DettDipendenti> details=dettDipendenteService.findAll();
		
		if(details==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<DettDipendenti>>(details,HttpStatus.OK);
		
	}
	
	
}
