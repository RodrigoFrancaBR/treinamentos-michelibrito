package com.eventosapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventosapp.models.Evento;
import com.eventosapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	private EventoRepository eventoRepository;
	
	public EventoController(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento){		
		
		eventoRepository.save(evento);
		
		return "redirect:/cadastrarEvento";
	}

}
