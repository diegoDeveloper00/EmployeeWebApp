package it.corso.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ruolo")
public class Ruolo {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="tipo_ruolo")
	private String tipoRuolo;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="stipendioBase")
	private String stipendioBase;

	@ManyToOne
	@JoinColumn(name = "id_dipendente",referencedColumnName = "id")
	//@JsonManagedReference
	private Dipendente dipendente;
	

	public String getTipoRuolo() {
		return tipoRuolo;
	}

	public void setTipoRuolo(String tipoRuolo) {
		this.tipoRuolo = tipoRuolo;
	}

	public String getStipendioBase() {
		return stipendioBase;
	}

	public void setStipendioBase(String stipendioBase) {
		this.stipendioBase = stipendioBase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	
}
