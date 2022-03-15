package com.example.contat.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contat.dto.ContattoDTO;
import com.example.contat.entity.Contatti;
import com.example.contat.repository.ContatRepositoryextends;
import com.example.contat.service.ContatService;


@RestController
@RequestMapping("/contat/")
public class ContattiController {
	@Autowired
 ContatService contService;
	
//    @Autowired
//    private final ContatRepositoryextends contRepository;        
//
//    
//
//	public ContattiController(ContatRepositoryextends contRepository) {
//		this.contRepository=contRepository;
//	}
	
//	@PutMapping("/contat")
//	public ResponseEntity<?> creoContatto(@RequestBody Contatti cont) {
//		
//		contService.creaContat(cont);
//		
//		 return ResponseEntity //
//			        .status(HttpStatus.OK) //
//			        .header(HttpHeaders.CONTENT_TYPE) //
//			        .body("Salvato");
//			  }
//	
//		
	
	@PostMapping("/creaoContatti")
	public ResponseEntity<?> creoContatto(@RequestBody ContattoDTO contattoDto){
		return contService.creaContat(contattoDto);
	}
		
	@GetMapping("/all")
	public  ResponseEntity<?>  getContatti()
	{
		return contService.getContat();
			  
	}	 
	  
	@GetMapping("/contat/{id}")
	public ResponseEntity<?> getContatById(@PathVariable Long id){
		try{//recupero il contatto tramite id 
			
			return contService.getContatById(id);
		}
		catch(Exception e){ 
				
			return ResponseEntity //
			.status(HttpStatus.INTERNAL_SERVER_ERROR) //
			.header(HttpHeaders.CONTENT_TYPE) //
			.body(e.getMessage() + "  -----   " +  e.getStackTrace());
			
		}	 
	}
	@DeleteMapping("/cancello/{id}")
	public ResponseEntity<?> getContatByIdForDelete(@PathVariable Long id)
	{//recupero il contatto tramite id 
		return contService.deletebyId(id);
	}	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> upDate(@RequestBody ContattoDTO contattoDto){

		try{
		return contService.upDateById(contattoDto);
		}
		catch(Exception e){ 
			
			return ResponseEntity //
			.status(HttpStatus.INTERNAL_SERVER_ERROR) //
			.header(HttpHeaders.CONTENT_TYPE) //
			.body(e.getMessage() + "  -----   " +  e.getStackTrace());
			
		}
	}

}
