package com.example.contat.dto;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

public class ContattoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonbProperty("id")
	private long id;

	@JsonbProperty("descrizione")
	private String descrizione;


	@JsonbProperty("idUtente")
	private long idUtente;


	public ContattoDTO(long id, String descrizione, long idUtente) {

		super();
		this.id = id;
		this.descrizione = descrizione;
		this.idUtente=idUtente;
	}

	public ContattoDTO() {}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public long getIdUtente() {
		return this.idUtente;
	}

}
