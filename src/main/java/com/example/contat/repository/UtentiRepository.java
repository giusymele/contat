package com.example.contat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contat.entity.Contatti;
import com.example.contat.entity.Utenti;

public interface UtentiRepository extends JpaRepository<Utenti, Long> {
	
	Utenti findByEmail(String email);
}
