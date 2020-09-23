package it.corso.webapp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.corso.webapp.entities.Utente;
import it.corso.webapp.repository.UtenteRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utente utente=utenteRepository.findByUsername(username);
		
		return new MyUserDetails(utente);
	}
	
	
}
