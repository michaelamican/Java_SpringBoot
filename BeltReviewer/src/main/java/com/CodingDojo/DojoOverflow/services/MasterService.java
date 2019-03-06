package com.CodingDojo.DojoOverflow.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.CodingDojo.DojoOverflow.models.Event;
import com.CodingDojo.DojoOverflow.models.User;
import com.CodingDojo.DojoOverflow.models.UserEvent;
import com.CodingDojo.DojoOverflow.repositories.CommentRepo;
import com.CodingDojo.DojoOverflow.repositories.EventRepo;
import com.CodingDojo.DojoOverflow.repositories.UserEventRepo;
import com.CodingDojo.DojoOverflow.repositories.UserRepo;

@Service
public class MasterService {
	private final UserRepo uR;
	private final EventRepo eR;
	private final UserEventRepo ueR;
	private final CommentRepo cR;
	public MasterService(UserRepo uR, EventRepo eR, UserEventRepo ueR, CommentRepo cR) {
		this.uR = uR;
		this.eR = eR;
		this.ueR = ueR;
		this.cR = cR;
	}
	
	//User -------------------------------------------------------------
	public User createUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return uR.save(user);
	}
	public User findByEmail(String email) {
        return uR.findByEmail(email);
    }
	public User getUserById(Long id) {
		Optional<User> user = uR.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			System.out.println("Couldn't find user");
			return null;
		}
	}
	public User findUserById(Long id) {
    	Optional<User> u = uR.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
	}
	public boolean authenticateUser(String email, String password) {
        User user = uR.findByEmail(email);
        if(user == null) {
            return false;
        } else {
        	if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
	
	//Event -------------------------------------------------------------
	public Event createEvent(Event event) {
		return eR.save(event);
	}
	public Event getEventById(Long id) {
		Optional<Event> event = eR.findById(id);
		if(event.isPresent()) {
			return event.get();
		} else {
			System.out.println("Couldn't find user");
			return null;
		}
	//UserEvent ---------------------------------------------------------
//	public UserEvent createUserEvent(UserEvent userevent) {
//		return ueR.save(userevent);
//	}
	

	
	}
	
}
