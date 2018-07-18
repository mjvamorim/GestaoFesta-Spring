package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
@RequestMapping("/api/")
public class ApiConvidadoController {
	
	@Autowired
	private Convidados convidados;
	
	@RequestMapping(value = "/convidados", method = RequestMethod.GET)
	@ResponseBody
	public List<Convidado> listaConvidados() {
	   return convidados.findAll();
	}
}
