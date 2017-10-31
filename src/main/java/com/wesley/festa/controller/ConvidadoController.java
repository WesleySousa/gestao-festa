package com.wesley.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wesley.festa.model.Convidado;
import com.wesley.festa.repository.ConvidadoRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject("convidados", convidadoRepository.findAll());
		mv.addObject(new Convidado());
		return mv;
	}
	
	@PostMapping
	public ModelAndView adicionar(Convidado convidado) {
		convidadoRepository.save(convidado);
		// return "redirect:/convidados";
		return listar();
	}

}
