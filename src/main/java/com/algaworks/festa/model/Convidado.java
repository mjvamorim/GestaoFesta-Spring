package com.algaworks.festa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Convidado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer acompanhantes;
	
	
	@ManyToOne
    @JoinColumn(name = "festa_id")
	private Festa festa;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAcompanhantes() {
		return acompanhantes;
	}
	public void setAcompanhantes(Integer acompanhantes) {
		this.acompanhantes = acompanhantes;
	}
	public Festa getFesta() {
		return festa;
	}
	public void setFesta(Festa festa) {
		this.festa = festa;
	}

}
