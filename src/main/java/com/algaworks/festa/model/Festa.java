package com.algaworks.festa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("deprecation")
@Entity
public class Festa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome é obrigatória")
	@Size(max = 30, message = "O Nome não pode conter mais de 30 caracteres")
	private String nome;
	
	@OneToMany(mappedBy = "festa", cascade = CascadeType.ALL)
	private Set<Convidado> convidados;
	
	
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
	
	public Set<Convidado> getConvidados() {
		return convidados;
	}
	public void setConvidados(Set<Convidado> convidados) {
		this.convidados = convidados;
	}
	
	
}
