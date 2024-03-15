package com.expenses.expensemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.dto.OtpRequest;
import com.expenses.expensemanagement.dto.OtpResponseDto;
import com.expenses.expensemanagement.dto.OtpValidationRequest;
import com.expenses.expensemanagement.service.SmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/otp")
@Slf4j
public class OtpController {

	@Autowired
	private SmsService smsService;

	@GetMapping
	public String processSMS() {
		return "SMS Sent";
	}

	@PostMapping("/send-otp")
	public OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) {
		return SmsService.sendSMS(otpRequest);
	}

	@PostMapping("/validate-otp")
	public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		return smsService.validateOtp(otpValidationRequest);
	}
}
