package com.expenses.expensemanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.bean.Email;
import com.expenses.expensemanagement.bean.Transaction;
import com.expenses.expensemanagement.service.EmailService;
import com.expenses.expensemanagement.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private EmailService emailService;

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/save")
	public ResponseEntity<Object> saveTransaction(@RequestBody Transaction transaction) {
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		String formattedDate = sdf.format(currentDate);
		transaction.setTransactionDate(formattedDate);
		Long epochTime = System.currentTimeMillis();
		transaction.setTransactionTime(epochTime);
		boolean saved = transactionService.saveTransaction(transaction);

		if (saved) {
			String recepeint = "19131a0543@gvpce.ac.in";
			String subject = "New Transaction added for you";
			String body = "Syam added you in a transaction." + "Amount : $" + transaction.getAmount() + "Description : "
					+ transaction.getDescription();
			Email email = new Email(recepeint, subject, body);
			String res = emailService.sendEmail(email);
			return ResponseEntity.status(HttpStatus.CREATED).body("Transaction Saved Successfully" + res);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving the Transaction");
	}

	@GetMapping("/get/all")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAll();
	}

	@GetMapping("/get/{id}")
	public Object getTransactionById(@PathVariable("int") int id) {
		return transactionService.getTransactionById(id);
	}

	@GetMapping("/delete/{id}")
	public Object delete(@PathVariable("int") int id) {
		return transactionService.deleteTransaction(id);
	}

	@PostMapping("/update")
	public Object updateUser(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}
}