package it.corso.webapp.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.webapp.MyUserDetailsService;
import it.corso.webapp.entities.Dipendente;
import it.corso.webapp.service.DipendenteService;
import it.java.model.AuthenticationRequest;
import it.java.model.AuthenticationResponse;
import it.java.util.JwtUtil;

@RestController
//@RequestMapping("/api/dipendenti")
public class DipendenteController {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private DipendenteService dipendenteService;

	@Autowired
    private JwtUtil jwtUtil;
	
    @Autowired
    private AuthenticationManager authenticationManager;
	
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Dipendente>> getAllDipendenti(){
		
		List<Dipendente> dipendenti=dipendenteService.findAll();
		
		if(dipendenti.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Dipendente>>(dipendenti,HttpStatus.OK);
		
	}

    @PostMapping(value="/authenticate",produces =  "application/json")
    public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authRequest.getUsername());

		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
	
	@GetMapping(value = "/cerca/{idDipendente}",produces = "application/json")
	public ResponseEntity<Dipendente> getDipendenteById(@PathVariable("idDipendente") int idDipendente){
		
		Dipendente dipendente=dipendenteService.findByIdDipendente(idDipendente);
		
		if(dipendente==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<Dipendente>(dipendente,HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/inserisci",produces =  "application/json")
	public ResponseEntity<?> insDipendente(@RequestBody Dipendente dipendente){
		
		String fiscalCodeRegex="[A-Za-z]{6}[0-9]{2}[A-za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}";
		
		String msg="";
		
		if(dipendente.getIdDipendente()==0) {
			String fiscalCode=dipendente.getCodiceFiscale();
			if(Pattern.matches(fiscalCodeRegex, fiscalCode)){
			
		dipendenteService.insert(dipendente);
		return new ResponseEntity<>(new HttpHeaders(),HttpStatus.CREATED);
			}else {
				msg="Codice Fiscale invalido";
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
				
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping(value="/modifica" ,produces = "application/json")
	public ResponseEntity<?> updateDipendente(@RequestBody Dipendente dipendente){
		
		if(dipendente.getIdDipendente()!=0) {
			dipendenteService.update(dipendente);
			return new ResponseEntity<>(new HttpHeaders(),HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value="/elimina/{id}",produces = "application/json")
	public ResponseEntity<?> deleteDipendente(@PathVariable("id") int id){
		
		Dipendente dipendente =dipendenteService.findByIdDipendente(id);
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper mapper=new ObjectMapper();
		ObjectNode node=mapper.createObjectNode();
		
		if(dipendente==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		dipendenteService.remove(dipendente);
		
		node.put("codice", HttpStatus.OK.toString());
		node.put("messaggio","rimosso dipendente con id: "+id);
		
		return new ResponseEntity<>(node,headers,HttpStatus.OK);
		
	}

	
}
