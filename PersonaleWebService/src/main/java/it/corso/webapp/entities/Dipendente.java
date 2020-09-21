package it.corso.webapp.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Dipendente")
public class Dipendente {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDipendente;
	
	@Column(name="nome")
	private String nome;

	@Column(name="cognome")
	private String cognome;
	
	@Column(name="eta")
	private int eta;
	
	@Column(name="data_nascita")
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@Column(name="recapito")
	private String recapito;
	
	@Column(name="luogo_residenza")
	private String luogoResidenza;
	
	@Column(name="codiceFiscale")
	private String codiceFiscale;
	
	@OneToOne(mappedBy = "idDipendente",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonBackReference
	private DettDipendenti dettDipendenti;
	
	@OneToMany(mappedBy = "dipendente",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	//@JsonBackReference
	private Set<Ruolo> ruoli;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Utente utente;
	
	public int getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getRecapito() {
		return recapito;
	}

	public void setRecapito(String recapito) {
		this.recapito = recapito;
	}

	public String getLuogoResidenza() {
		return luogoResidenza;
	}

	public void setLuogoResidenza(String luogoResidenza) {
		this.luogoResidenza = luogoResidenza;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public DettDipendenti getDettDipendenti() {
		return dettDipendenti;
	}

	public void setDettDipendenti(DettDipendenti dettDipendenti) {
		this.dettDipendenti = dettDipendenti;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
}
