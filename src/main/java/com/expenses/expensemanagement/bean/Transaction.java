package com.expenses.expensemanagement.bean;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "description")
	private String description;
	@Column(name = "amount")
	private double amount;
	@Column(name = "transaction_date")
	private String transactionDate;
	@Column(name = "transaction_time")
	private Long transactionTime;
	@Column(name = "owner")
	private String owner;

	@ElementCollection
	private List<String> users_included;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTransactionTime() {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(transactionTime), ZoneId.of("Asia/Kolkata"))
				.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)).toUpperCase();
	}

	public void setTransactionTime(Long transactionTime) {
		this.transactionTime = transactionTime;
	}

	public List<String> getUsers_included() {

		return users_included;
	}

	public void setUsers_included(List<String> users_included) {
		this.users_included = users_included;
	}

	public Transaction(Integer id, String description, double amount, String transactionDate, Long transactionTime,
			List<String> users_included, String owner) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.users_included = users_included;
		this.owner = owner;
	}

	public Transaction() {
	}

}