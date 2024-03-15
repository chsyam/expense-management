package com.expenses.expensemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.expenses.expensemanagement.config.TwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication
@EnableConfigurationProperties
public class ExpenseManagementApplication {
	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void setup() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApplication.class, args);
	}
}