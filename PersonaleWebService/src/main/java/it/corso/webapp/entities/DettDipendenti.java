package it.corso.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Dett_Dipendenti")
public class DettDipendenti {

	@Id
	@Column(name = "idDettDipendenti")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDettDipendenti;

	@Column(name = "livelloAnzianita")
	private int livelloAnzianita;

	@OneToOne
	@JoinColumn(name = "idDipendente",referencedColumnName = "Id")
	//@JsonManagedReference
	private Dipendente idDipendente;

	public int getIdDettDipendenti() {
		return idDettDipendenti;
	}

	public void setIdDettDipendenti(int idDettDipendenti) {
		this.idDettDipendenti = idDettDipendenti;
	}

	public int getLivelloAnzianita() {
		return livelloAnzianita;
	}

	public void setLivelloAnzianita(int livelloAnzianita) {
		this.livelloAnzianita = livelloAnzianita;
	}

	public Dipendente getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(Dipendente idDipendente) {
		this.idDipendente = idDipendente;
	}
	
	

}