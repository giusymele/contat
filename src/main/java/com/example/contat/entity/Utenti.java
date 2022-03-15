package com.example.contat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.Data;

@Entity
@EnableAutoConfiguration
@TableGenerator(name="utenti")

public class Utenti {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false) long id ;
	private  @Column(nullable = false) String email ;
	private  @Column(nullable = false) String password ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
