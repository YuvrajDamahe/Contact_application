package com.contact.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.application.exception.DuplicatePhoneNumberException;
import com.contact.application.exception.InvalidContactNumberException;
import com.contact.application.exception.InvalidEmailIdException;
import com.contact.application.exception.NoDuplicateEmailIdException;
import com.contact.application.exception.UserNotPresentException;
import com.contact.application.models.Contact;
import com.contact.application.models.User;
import com.contact.application.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

//	public User update(User user) {
//		// TODO Auto-generated method stub
//		return userRepository.saveAndFlush(user);
//	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	
	
	//duplicate
	public List<User> getAllUser1() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	//	duplicate
	
	
	
	
	public String deleteUser(Long id) throws UserNotPresentException {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw new UserNotPresentException("User is not present");
		}
		return "user is deleted " + id;

	}

	public User update(Long id, User user)
			throws UserNotPresentException, InvalidEmailIdException, NoDuplicateEmailIdException,InvalidContactNumberException,DuplicatePhoneNumberException {

		// ******************************check for the user*************************//
		try {
			Optional<User> checkuser = userRepository.findById(id);

			if (checkuser.isEmpty())
				throw new UserNotPresentException("User is not present");
		} catch (Exception e) {
			throw new UserNotPresentException("User is not present");
		}
		
		
		// ****************************************check for email
		
		
		if (user != null) {
			// ***************************Invalide Email*****************************//
			String emailFromPathVariable = user.getEmail();
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			boolean resultEmail = emailFromPathVariable.matches(regex);
			
			//********************** Regular Expression For phone Number******************8
			List<Contact> obj = user.getContacts();
			for(int i = 0;i<obj.size();i++) {
				String phoneFromPathVariable = Long.toString(obj.get(i).getPhoneNumber());
				String phoneRegex = "[6-9]{1}\\d{9}";
				
				boolean resultPhoneNumber = phoneFromPathVariable.matches(phoneRegex);
				System.out.println(i+","+phoneFromPathVariable);
				if (resultPhoneNumber == false) {
					throw new InvalidContactNumberException(obj.get(i).getPhoneNumber() + " is not valid Phone number");
				}
				
				//************checking duplicate for phone number*******************
				int j = i+1;
				while(j<obj.size()) {
					String nextPhoneNumberFromPathVariable = Long.toString(obj.get(j).getPhoneNumber());
					if(phoneFromPathVariable.equals(nextPhoneNumberFromPathVariable) ) {
						throw new DuplicatePhoneNumberException(phoneFromPathVariable+ " duplicate phone number for "+obj.get(i).getContactName()+" and "+obj.get(j).getContactName());
					}
					j++;
				}
				
				
				
			}
			
				if (resultEmail) {
					System.out.println("emailid is correct patteren");
					
					return userRepository.saveAndFlush(user);
				}
			
				else {
					throw new InvalidEmailIdException(user.getEmail() + " is not valid");
				}
			
			
		} else
			throw new InvalidEmailIdException(user.getEmail() + " is not valid");

	}

	public Optional<User> getUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		return u;
	}
	
	
	public User addContact(Long id, Contact contact) throws UserNotPresentException {
		try {
			Optional<User> findUser = userRepository.findById(id);
			if (findUser.isEmpty())
				throw new UserNotPresentException("User not found");
		} catch (Exception e) {
			throw new UserNotPresentException("User not found");
		}

		User u = userRepository.findById(id).get();
		
		
		
		List<Contact> newContact = new ArrayList<>();
		newContact.add(contact);
		newContact.addAll(u.getContacts());
		
		
		
		
		
		
		u.setContacts(newContact);
		userRepository.save(u);
		return u;
	}

}
