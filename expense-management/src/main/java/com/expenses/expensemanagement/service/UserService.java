package com.expenses.expensemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.expensemanagement.bean.Users;
import com.expenses.expensemanagement.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public String saveUser(Users user) {
		userRepository.save(user);
		if (userRepository.findById(user.getId()) != null) {
			return "User saved succcessfully";
		}
		return "Something went wrong...!";
	}

	public Object getUserById(int id) {
		if (userRepository.findById(id) == null) {
			return "User not found by this id = " + id;
		}
		return userRepository.findById(id);
	}

	public Object deleteUser(int id) {
		Optional<Users> user = userRepository.findById(id);
		if (user == null) {
			return "User not found by this id = " + id;
		}
		userRepository.deleteById(id);
		return "User deleted by this id = " + id;
	}

	public Object updateUser(Users user) {
		if (userRepository.findById(user.getId()) == null) {
			return "User doesn't exist. New User created...!";
		}
		return saveUser(user);
	}
}
