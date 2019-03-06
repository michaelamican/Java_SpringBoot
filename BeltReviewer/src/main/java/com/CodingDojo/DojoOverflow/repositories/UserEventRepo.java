package com.CodingDojo.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.DojoOverflow.models.UserEvent;

public interface UserEventRepo extends CrudRepository<UserEvent, Long> {
//	
//	UserEvent createUserEvent(User user, Event event);
}
