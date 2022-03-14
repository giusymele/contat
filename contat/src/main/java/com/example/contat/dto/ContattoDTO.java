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

	public ContattoDTO(long id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
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

}
