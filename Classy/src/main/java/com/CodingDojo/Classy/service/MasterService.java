package com.CodingDojo.Classy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.CodingDojo.Classy.models.Course;
import com.CodingDojo.Classy.models.Enrolled;
import com.CodingDojo.Classy.models.User;
import com.CodingDojo.Classy.repositories.CourseRepo;
import com.CodingDojo.Classy.repositories.EnrolledRepo;
import com.CodingDojo.Classy.repositories.UserRepo;

@Service
public class MasterService {
	private final CourseRepo cR;
	private final UserRepo uR;
	private final EnrolledRepo eR;
	
	public MasterService(CourseRepo cR, UserRepo uR, EnrolledRepo eR) {
		this.cR = cR;
		this.uR = uR;
		this.eR = eR;
	}
	
	
	
	

//CREATE ====================================================================================================================================
	public Course createCourse(Course course) {
		return cR.save(course);
	}
	
	public void enroll(Enrolled e) {
		eR.save(e);
	}
	
	
//SHOW BY ID ====================================================================================================================================
	public Course getCourseById(Long id) {
		Optional<Course> course = cR.findById(id);
		if(course.isPresent()){
			return course.get();
		} else {
			System.out.println("Course does not exist");
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
	public List<User> getEnrolledStudents(Long id) {
		Course c = getCourseById(id);
		List<User> students = c.getUsers();
		List<String> names = new ArrayList<String>();
		if(students.size() == 0) {
			names.add("");
		}
		for(User u : students) {
			names.add(u.getName());
		}
		System.out.println(names);
		return uR.findByNameIn(names);
	}

	
	
//SHOW ALL ====================================================================================================================================
	public List<Course> getAllCourses(){
		List<Course> courses = cR.findAll();
		return courses;
	}
	public List<User> getAllUsers(){
		List<User> users = uR.findAll();
		return users;
	}

//UPDATE ====================================================================================================================================
	public Course updateCourse(Course course, Long id) {
		Course c = cR.findById(id).get();
		c.setTitle(course.getTitle());
		c.setInstructor(course.getInstructor());
		c.setMax(course.getMax());
		return cR.save(c);
	}
	
	
	
	
//DELETE ====================================================================================================================================
	
	public void deleteCourse(Long id) {
		cR.deleteById(id);
	}
	public void unEnroll(Long id) {
		eR.deleteById(id);
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
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
