package com.expenses.expensemanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.expensemanagement.bean.Member;
import com.expenses.expensemanagement.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<Map<String, String>> getAllUsers() {
		List<Object> users = userRepository.findAllUsers();
		List<Map<String, String>> usersList = new ArrayList<>();
		for (Object user : users) {
			Map<String, String> tempMap = new HashMap();
			tempMap.put("username", user.toString());
			usersList.add(tempMap);
		}
		return usersList;
	}

	public String saveUser(Member user) {
		userRepository.save(user);
		if (userRepository.findById(user.getId()) != null) {
			return "User saved succcessfully";
		}
		return "Something went wrong...!";
	}

	public Object getUserByUsername(String username) {
		if (userRepository.findByUsername(username) == null) {
			return "User not found by this username = " + username;
		}
		return userRepository.findByUsername(username);
	}

	public Object deleteUser(int id) {
		Optional<Member> user = userRepository.findById(id);
		if (user == null) {
			return "User not found by this id = " + id;
		}
		userRepository.deleteById(id);
		return "User deleted by this id = " + id;
	}

	public Object updateUser(Member user) {
		if (userRepository.findById(user.getId()) == null) {
			return "User doesn't exist. New User created...!";
		}
		return saveUser(user);
	}
}
