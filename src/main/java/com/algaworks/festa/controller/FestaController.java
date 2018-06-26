

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

import com.algaworks.festa.model.Festa;
import com.algaworks.festa.repository.Festas;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/festas")
public class FestaController {

	@Autowired
	private Festas festas;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaFestas");
		mv.addObject(new Festa());
		mv.addObject("festas", festas.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Festa festa) {
		this.festas.save(festa);
		return "redirect:/festas";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirFestaByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.festas.deleteById(id);
		return "redirect:/festas";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarFestaByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaFestas");
		Festa festa = festas.getOne(id);
		mv.addObject(festa);
		mv.addObject("festas", festas.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}
