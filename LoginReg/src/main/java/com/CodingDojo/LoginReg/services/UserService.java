//package com.CodingDojo.LoginReg.services;
//
//import org.apache.el.stream.Optional;
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.stereotype.Service;
//
//import com.CodingDojo.LoginReg.repositories.UserRepository;
//
//@Service
//public class UserService {
//	private final UserRepository userRepository;
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//	//register and hash
//	public User registerUser(User user) {
//		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//		user.setPassword(hashed);
//		return userRepository.save(user);
//	}
//	
//	//find by email
//	public User findByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
//	
//	//find by user id
//	public User findUserById(Long id) {
//		Optional<User> u = userRepository.findById(id);
//		if(u.isPresent()) {
//			return u.get();
//		} else {
//			return null;
//		}
//	}
//	
//	//authenticate user
//	public boolean authenticateUser(String email, String password) {
//		//find by email first
//		User user = userRepository.findByEmail(email);
//		//if we can't, return false
//		if(user == null) {
//			return false;
//		} else {
//			if(BCrypt.checkpw(password, user.getPassword())) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//	}
//}
