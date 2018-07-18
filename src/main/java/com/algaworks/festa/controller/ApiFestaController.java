package com.algaworks.festa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.festa.model.Festa;

import com.algaworks.festa.repository.Festas;

@RestController
@RequestMapping("/api/festas")
public class ApiFestaController {
	
	@Autowired
	private Festas festas;
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Festa> listaFestas() {
	   return festas.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Festa> getFesta(@PathVariable("id") Long id) {
		return this.festas.findById(id);
	}
}
