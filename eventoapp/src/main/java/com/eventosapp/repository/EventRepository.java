package com.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.models.Event;

public interface EventRepository extends CrudRepository<Event, String>{
	Event findByCode(long cod);

}
