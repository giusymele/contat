package com.example.contat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@EnableAutoConfiguration
//@NoArgsConstructor
//@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@TableGenerator(name = "contatti")
public class Contatti {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false) Long id;
	private @Column(nullable = false) String descrizione;
	private @Column(nullable = true) Long idUtente;

	public Contatti() {}
	
	public Contatti(Long id2, String descrizione2, Long idUtente) {
		this.id = id2;
		this.descrizione = descrizione2;
		this.idUtente=idUtente;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public Long getIdUtente(){

		return this.idUtente;
	}
}
