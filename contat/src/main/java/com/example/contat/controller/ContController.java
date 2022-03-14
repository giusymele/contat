package com.example.contat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contat.entity.Contatti;
import com.example.contat.repository.ContatRepositoryextends;

@RestController
public class ContController {

	@Autowired
private final 	ContatRepositoryextends contRep;
	
	
	public ContController(ContatRepositoryextends contRep) {
		
		this.contRep=contRep;
	}
	
	
	@GetMapping("/cont")
	List<Contatti> listaCont(){
		
		return contRep.findAll();
	}
}
