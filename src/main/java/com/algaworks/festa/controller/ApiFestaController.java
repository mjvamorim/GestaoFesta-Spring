package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.festa.model.Festa;

import com.algaworks.festa.repository.Festas;

@Controller
@RequestMapping("/api/festas")
public class ApiFestaController {
	

	@Autowired
	private Festas festas;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Festa> listaFestas() {
	   return festas.findAll();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Curso> buscar(@PathVariable("id") Integer id) {
//	  Curso curso = cursos.get(id);
//	 
//	  if (curso == null) {
//	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	  }
//	 
//	  return new ResponseEntity<Curso>(curso, HttpStatus.OK);
//	}
	 
}
