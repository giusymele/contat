package com.example.contat.dto;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;



public class RispostaContatti implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonbProperty("listaContatti")
	List<ContattoDTO> listaContatti;
	


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
	
	
	public RispostaContatti() {}

	
	
}
