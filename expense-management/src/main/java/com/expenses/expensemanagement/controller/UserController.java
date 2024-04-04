package com.expenses.expensemanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.bean.Member;
import com.expenses.expensemanagement.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("users/get/all")
	public List<Map<String, String>> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("users/get/{username}")
	public Object getUserById(@PathVariable("username") String username) {
		System.out.print(username);
		return userService.getUserByUsername(username);
	}

	@GetMapping("users/delete/{id}")
	public Object deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}

	@PostMapping("users/update")
	public Object updateUser(@RequestBody Member user) {
		return userService.updateUser(user);
	}
}