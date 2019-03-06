package com.CodingDojo.ShowReviewer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.CodingDojo.ShowReviewer.models.Rating;
import com.CodingDojo.ShowReviewer.models.Show;
import com.CodingDojo.ShowReviewer.models.User;
import com.CodingDojo.ShowReviewer.repositories.RatingRepo;
import com.CodingDojo.ShowReviewer.repositories.ShowRepo;
import com.CodingDojo.ShowReviewer.repositories.UserRepo;

@Service
public class MasterService {
	private final ShowRepo sR;
	private final UserRepo uR;
	private final RatingRepo rR;
	
	public MasterService(ShowRepo sR, UserRepo uR, RatingRepo rR) {
		this.sR = sR;
		this.uR = uR;
		this.rR = rR;
	}
	
	
	
	

//CREATE ====================================================================================================================================
	public Show createShow(Show show) {
		return sR.save(show);
	}
	
	public void rate(Rating r) {
		rR.save(r);
	}
	
	
//SHOW BY ID ====================================================================================================================================
	public Show getShowById(Long id) {
		Optional<Show> show = sR.findById(id);
		if(show.isPresent()){
			return show.get();
		} else {
			System.out.println("Show does not exist");
			return null;
		}
	}
	
	public User getUserById(Long id) {
		Optional<User> user = uR.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			System.out.println("Does not exist");
			return null;
		}
	}
	
	
	
//SHOW ASSOCIATED ====================================================================================================================================
	public List<User> getRatingUsers(Long id) {
		Show s = getShowById(id);
		List<User> users = s.getUsers();
		List<String> names = new ArrayList<String>();
		if(users.size() == 0) {
			names.add("");
		}
		for(User u : users) {
			names.add(u.getName());
		}
		System.out.println(names);
		return uR.findByNameIn(names);
	}

	
	
//SHOW ALL ====================================================================================================================================
	public List<Show> getAllShows(){
		List<Show> shows = sR.findAll();
		return shows;
	}
	public List<User> getAllUsers(){
		List<User> users = uR.findAll();
		return users;
	}
	public Rating getRatings(Long id) {
		Rating r = rR.findAllByShowId(id).get();
		if(r == null) {
		}
		return r;
	}

//UPDATE ====================================================================================================================================
	public Show updateShow(Show show, Long id) {
		Show s = sR.findById(id).get();
		s.setTitle(show.getTitle());
		s.setNetwork(show.getNetwork());
		return sR.save(s);
	}
	
	
	
	
//DELETE ====================================================================================================================================
	
	public void deleteShow(Long id) {
		sR.deleteById(id);
	}
	public void unEnroll(Long id) {
		rR.deleteById(id);
	}
	

//LOGIN REG ====================================================================================================================================
	//register and hash ------------------------------------------------------------------
	public User makeUser(User user) {
			if(!(user.getPassword().equals(user.getPwConf()))) {
				System.out.println("Confirmation does not match");
				return user;
			} else {
			String hashed = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
			user.setPassword(hashed);
			return uR.save(user);
		}
	}
	//find by email ------------------------------------------------------------------
	public User findByEmails(String email) {
		return uR.findByEmail(email);
	}
	
	//find by user id ------------------------------------------------------------------
	public User findUserById(Long id) {
		Optional<User> u = uR.findById(id);
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	//authenticate user ------------------------------------------------------------------
	public boolean checkUser(String email, String password) {
		User user = uR.findByEmail(email);
		if(user == null) {
			System.out.println("No such user");
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				System.out.println("Invalid password");
				return false;
			}
		}
	}


	public void deleteRating(Rating x) {
		rR.delete(x);
		
	}
}
