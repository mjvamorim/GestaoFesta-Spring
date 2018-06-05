package com.algaworks.festa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private Convidados convidados;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject(new Convidado());
		mv.addObject("convidados", convidados.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirConvidadoByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.convidados.deleteById(id);
		return "redirect:/convidados";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarConvidadoByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaConvidados");
		Convidado convidado = convidados.getOne(id);
		mv.addObject(convidado);
		mv.addObject("convidados", convidados.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}
