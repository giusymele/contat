package com.example.contat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.contat.dto.ContattoDTO;
import com.example.contat.entity.Contatti;
import com.example.contat.repository.ContatRepositoryextends;
import com.example.contat.repository.UtentiRepository;
import com.example.contat.risposta.RispostaContatti;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatService {

	@Autowired
	private ContatRepositoryextends contRepository;
	
	@Autowired
	private UtentiRepository utentiRepository;

//creare
	public ResponseEntity<?> creaContat(ContattoDTO cont) {
		
		if(utentiRepository.findById(cont.getId()) != null) {
			
			Contatti contattoEntity = new Contatti(cont.getId(), cont.getDescrizione());
			
			contRepository.save(contattoEntity);
			
			 return ResponseEntity //
				        .status(HttpStatus.OK) //
				        .header(HttpHeaders.CONTENT_TYPE) //
				        .body("lista vuota");
		}
		else {
			 return ResponseEntity //
				        .status(HttpStatus.INTERNAL_SERVER_ERROR) //
				        .header(HttpHeaders.CONTENT_TYPE) //
				        .body("utente non trovato");
			
		}
	}

	
	// red

	public ResponseEntity<?> getContat() {
		List<ContattoDTO> listaContattiDTO = new ArrayList<ContattoDTO>();

		List<Contatti> listaContattiEntity = contRepository.findAll();

		RispostaContatti rispostaContatti = new RispostaContatti();
		ContattoDTO contatto;

		for (Contatti item : listaContattiEntity) {

			contatto = new ContattoDTO(item.getId(), item.getDescrizione());

			listaContattiDTO.add(contatto);

		}
		
		if(listaContattiDTO.isEmpty())
		{

			 return ResponseEntity //
				        .status(HttpStatus.INTERNAL_SERVER_ERROR) //
				        .header(HttpHeaders.CONTENT_TYPE) //
				        .body("lista vuota");
			
		}
		rispostaContatti.setListaContatti(listaContattiDTO);
			
		
		
				 return ResponseEntity //
					        .status(HttpStatus.OK) //
					        .header(HttpHeaders.CONTENT_TYPE) //
					        .body(rispostaContatti);
	}

	// delete

	public void deleteContat(Long id) {

		contRepository.deleteById(id);
	}

	public void upDateContatto(Long id, Contatti cont) {
		Contatti c = contRepository.getById(id);
		c.setDescrizione(cont.getDescrizione());

		contRepository.save(c);
	}
	
	
	
	public ResponseEntity<?> getContatById(Long id){
		
		if(utentiRepository.findById(id) != null) {
			//recupero il contatto e lo passo a oggetto di Contatti
		Optional<Contatti> contattoEntity = contRepository.findById(id);

			RispostaContatti rispostaContatti = new RispostaContatti();
		
			
			Contatti c=	contattoEntity.get();
				
			ContattoDTO contatto=new ContattoDTO(c.getId(),c.getDescrizione());
			//lo passo alla risposta
			
			
			 return ResponseEntity //
			        .status(HttpStatus.INTERNAL_SERVER_ERROR) //
			        .header(HttpHeaders.CONTENT_TYPE) //
			        .body(contatto);
			
	}	else {
				 return ResponseEntity //
					        .status(HttpStatus.INTERNAL_SERVER_ERROR) //
					        .header(HttpHeaders.CONTENT_TYPE) //
					        .body("utente non trovato, non è stato possibile trovare l'elemento desiderato");
			}
		}
		
		
	
}