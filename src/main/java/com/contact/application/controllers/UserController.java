package com.contact.application.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.application.exception.DuplicatePhoneNumberException;
import com.contact.application.exception.InvalidContactNumberException;
import com.contact.application.exception.InvalidEmailIdException;
import com.contact.application.exception.NoDuplicateEmailIdException;
import com.contact.application.exception.UserNotPresentException;
import com.contact.application.models.Contact;
import com.contact.application.models.User;
import com.contact.application.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
//	@PutMapping("/put/{id}")
//	public User updateUser(@PathVariable("id") Long id,@RequestBody User user) throws UserNotPresentException, InvalidEmailIdException, NoDuplicateEmailIdException,InvalidContactNumberException, DuplicatePhoneNumberException {
//		return userService.update(id,user);
//	}
	
	@GetMapping("/get")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/get/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}
	
	
	
//	@DeleteMapping("/delete/{id}")
//	public String deleteUser(@PathVariable("id") Long id) throws UserNotPresentException{
//		return userService.deleteUser(id);
//	}
	
	
	@PostMapping("/addcontact/{id}")
	public User addContact(@PathVariable("id") Long id, @RequestBody Contact contact) throws UserNotPresentException {

		return userService.addContact(id,contact);

	}
	
	
	
	
	

}
