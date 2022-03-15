package com.example.contat.risposta;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import com.example.contat.dto.ContattoDTO;



public class RispostaContatti implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonbProperty("listaContatti")
	List<ContattoDTO> listaContatti;
	
	@JsonbProperty("contatto")
	ContattoDTO contatto;

	public List<ContattoDTO> getListaContatti() {
		return listaContatti;
	}

	public void setListaContatti(List<ContattoDTO> listaContatti) {
		this.listaContatti = listaContatti;
	}

	public RispostaContatti(List<ContattoDTO> listaContatti) {
		super();
		this.listaContatti = listaContatti;
	}
	
	
	public RispostaContatti(ContattoDTO contatto) {
		super();
		this.contatto = contatto;
	}
	
	public RispostaContatti() {}
	
	
	
	
}
