package com.example.contat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contat.entity.Utenti;
import com.example.contat.repository.UtentiRepository;

@Service
public class UtenteService {

	

    @Autowired
    UtentiRepository utenteRepository;        
	
    
    
    
    //creo nuova utenza
    
  
    public boolean nuovoUtente(Utenti utente) throws InstantiationException, IllegalAccessException {
    	
    	
    	if(getEmail(utente.getEmail())) {
    		
    	
    				utenteRepository.save(utente);
    				return true;
    	}
    
    	return false;
    	
    }
    
    
    public boolean getEmail(String email) {
    	
    	
    	Utenti utente =utenteRepository.findByEmail(email);
    	
    	if(email.equals(utente.getEmail())){
    		return true;
    		
    	}
    	else
    		return false;
    	
    }
    
    
    public List<Utenti> getAllUtenti(){
    	
     	return utenteRepository.findAll();
    	
    }
    
    
}
