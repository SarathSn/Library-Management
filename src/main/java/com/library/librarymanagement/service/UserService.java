package com.library.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.librarymanagement.model.User;
import com.library.librarymanagement.repo.UserRepo;
@Service
public class UserService {

private final UserRepo userRepo;
	
	
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo=userRepo;
	}
	
	public User addUser(User user)
	{
		return userRepo.save(user);
	}
}
