package it.corso.webapp;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.corso.webapp.entities.Utente;

public class MyUserDetails implements UserDetails {

	private String username;
	private String password;
	private String roles;
	private String permission;
	
	 public MyUserDetails(Utente utente) {
		this.username=utente.getUsername();
		this.password=utente.getPassword();
		this.roles=utente.getRoles();
		this.permission=utente.getPermissions();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
