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
import com.example.contat.request.RischiestaContatto;
import com.example.contat.risposta.RispostaContatti;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

@Service
public class ContatService {

	@Autowired
	private ContatRepositoryextends contRepository;
	
	@Autowired
	private UtentiRepository utentiRepository;

//creare
	public ResponseEntity<?> creaContat(ContattoDTO cont) {
		
		if(utentiRepository.findById(cont.getId()).isPresent()) {
			
			Contatti contattoEntity = new Contatti(cont.getId(), cont.getDescrizione());
			
			ContattoDTO contattoDTO = new ContattoDTO(contattoEntity.getId(),contattoEntity.getDescrizione());

			// creo la risposta 

			RispostaContatti rispostaContatti = new RispostaContatti(contattoDTO);

			contRepository.save(contattoEntity);
			
			 return ResponseEntity // 
				        .status(HttpStatus.OK) //
				        .header(HttpHeaders.CONTENT_TYPE) //
				        .body(rispostaContatti.getContattoDTO());
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

	
	
	public ResponseEntity<?> getContatById(Long id){
		
		if(id> 0 && utentiRepository.findById(id).isPresent()) {
			//recupero il contatto e lo passo a oggetto di Contatti
		Optional<Contatti> contattoEntity = contRepository.findById(id);

			Contatti c=	contattoEntity.get();
				
			ContattoDTO contatto=new ContattoDTO(c.getId(),c.getDescrizione());
			//lo passo alla risposta
			RispostaContatti rispostaContatti = new RispostaContatti(contatto);
			
			 return ResponseEntity //
			        .status(HttpStatus.OK) //
			        .header(HttpHeaders.CONTENT_TYPE) //
			        .body(rispostaContatti);
			
	}	else {
				 return ResponseEntity //
					        .status(HttpStatus.INTERNAL_SERVER_ERROR) //
					        .header(HttpHeaders.CONTENT_TYPE) //
					        .body("utente non trovato, non è stato possibile trovare l'elemento desiderato");
			}
		}
		
		public ResponseEntity<?> deletebyId(Long id){

			ResponseEntity<?> esisteID = getContatById(id);
			HttpStatus status =esisteID.getStatusCode();
			if(status.is2xxSuccessful()){

				contRepository.deleteById(id);

				return ResponseEntity //
				.status(HttpStatus.OK) //
				.header(HttpHeaders.CONTENT_TYPE) //
				.body("eliminato");

			}
			else
			{					
				return ResponseEntity //
				.status(HttpStatus.INTERNAL_SERVER_ERROR) //
				.header(HttpHeaders.CONTENT_TYPE) //
				.body("eliminato");
			}
		}

		

		public ResponseEntity<?> upDateById(ContattoDTO contattoDto){

		if(utentiRepository.findById(contattoDto.getId()).isPresent()) {
			
			RispostaContatti rischiestaContatto= new RispostaContatti(contattoDto);

			Contatti contattoModificato=new Contatti (contattoDto.getId() ,contattoDto.getDescrizione());

			contRepository.save(contattoModificato);
			return ResponseEntity //
			.status(HttpStatus.OK) //
			.header(HttpHeaders.CONTENT_TYPE) //
			.body(rischiestaContatto);

		}
		else
		{
				
			return ResponseEntity //
			.status(HttpStatus.INTERNAL_SERVER_ERROR) //
			.header(HttpHeaders.CONTENT_TYPE) //
			.body("l'id non esiste");


		}
		
	}
}