package com.CodingDojo.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.DojoOverflow.models.Event;

public interface EventRepo extends CrudRepository<Event, Long> {

}
