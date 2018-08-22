package com.algaworks.festa.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Collection<Festa> listaFestas() {
		return festas.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Festa> getFesta(@PathVariable("id") Long id) {
		return this.festas.findById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Festa>> listar() {
		return new ResponseEntity<List<Festa>>(new ArrayList<Festa>(festas.findAll()), 
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeFesta(@PathVariable("id") Long id) {
		Optional<Festa> c = festas.findById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		festas.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> saveFesta(@RequestBody Festa festa) {
		return new ResponseEntity<Festa> (festas.save(festa), HttpStatus.OK);
	}

}
