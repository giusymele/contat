package com.example.contat.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contat.entity.Contatti;



public interface ContatRepositoryextends extends JpaRepository<Contatti, Long> {
}