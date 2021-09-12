package com.eventosapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.models.Event;
import com.eventosapp.repository.EventRepository;

@Controller
public class EventController {

	private EventRepository eventRepository;

	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@RequestMapping(value = "/registerEvent", method = RequestMethod.GET)
	public String form() {
		return "event/formEvent";
	}

	@RequestMapping(value = "/registerEvent", method = RequestMethod.POST)
	public String form(Event event) {

		eventRepository.save(event);

		return "redirect:/registerEvent";
	}
	
	@RequestMapping("/events")
	public ModelAndView listEvents(){
		ModelAndView modelAndView = new ModelAndView("index");
		Iterable<Event> events = eventRepository.findAll();
		modelAndView.addObject("events", events);
		return modelAndView;
	}
	
	@RequestMapping(value="/{code}", method=RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("code") long code){
		Event event = eventRepository.findByCode(code);
		ModelAndView modelAndView = new ModelAndView("event/eventDetails");
		modelAndView.addObject("event", event);			
		return modelAndView;
	}

}
