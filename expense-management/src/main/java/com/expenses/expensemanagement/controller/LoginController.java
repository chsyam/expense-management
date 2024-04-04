package com.expenses.expensemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.bean.LoginRequest;
import com.expenses.expensemanagement.bean.LoginResponse;
import com.expenses.expensemanagement.bean.Member;
import com.expenses.expensemanagement.repository.UserRepository;
import com.expenses.expensemanagement.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Member member) {
		Member savedMember = null;
		ResponseEntity<String> response = null;
		try {
			savedMember = userRepository.save(member);
			if (savedMember.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user details are successfully registered");
			}
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to " + ex.getMessage());
		}
		return response;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		Member loginMember = (Member) userService.getUserByUsername(loginRequest.getUsername());
		if (loginMember.getPassword().equals(loginRequest.getPassword())) {
			LoginResponse response = new LoginResponse();
			response.setFirstName(loginMember.getFirstName());
			response.setLastName(loginMember.getLastName());
			response.setUsername(loginMember.getUsername());
			response.setEmail(loginMember.getEmail());
			response.setRole(loginMember.getRole());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	}
}