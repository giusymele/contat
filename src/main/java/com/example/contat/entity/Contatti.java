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

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false) long id;
	private @Column(nullable = false) String descrizione;

	public Contatti() {}
	
	public Contatti(long id2, String descrizione2) {
		this.id = id2;
		this.descrizione = descrizione2;
	}

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
