package com.expenses.expensemanagement.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Transactions_Users {
	@Id
	private Integer id;

	@OneToOne
	@JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
	private Integer transaction_id;

//	@OneToOne
//	@JoinColumn(name = "users_id", referencedColumnName = "users_id")
//	private UserEntity user;
}