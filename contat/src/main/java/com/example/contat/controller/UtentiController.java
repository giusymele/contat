package com.example.contat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contat.entity.Utenti;
import com.example.contat.service.UtenteService;

@RestController	
@RequestMapping(value="/rest/")
public class UtentiController {
	
	@Autowired
	UtenteService utenteService;
	
	
	@GetMapping("/utenti")
	public ResponseEntity<?> getAllUtenti()
	{
	
		List<Utenti> lista = utenteService.getAllUtenti();
		
		if(lista.isEmpty()) {
			
			return ResponseEntity //
					 .status(HttpStatus.NOT_FOUND) //
				        .header(HttpHeaders.CONTENT_TYPE) //
				        .body("Nessun cliente");
		}
		else {
			
			return ResponseEntity //
					 .status(HttpStatus.OK) //
				        .header(HttpHeaders.CONTENT_TYPE) //
				        .body(lista);
		}
	}
}
