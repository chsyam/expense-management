package com.expenses.expensemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.bean.Users;
import com.expenses.expensemanagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/get/all")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/save")
	public String saveUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

	@GetMapping("/get/{id}")
	public Object getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/delete/{id}")
	public Object deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}

	@PostMapping("/update")
	public Object updateUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}
}