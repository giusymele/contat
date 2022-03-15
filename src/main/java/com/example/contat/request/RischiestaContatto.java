package com.example.contat.request;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import com.example.contat.dto.ContattoDTO;

public class RischiestaContatto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonbProperty("contatto")
	private ContattoDTO contatto;

	public ContattoDTO getContatto() {
		return contatto;
	}

	public void setContatto(ContattoDTO contatto) {
		this.contatto = contatto;
	}

	public RischiestaContatto(ContattoDTO contatto) {
		super();
		this.contatto = contatto;
	}

	
	
}
