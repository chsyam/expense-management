package com.expenses.expensemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.expensemanagement.bean.Transaction;
import com.expenses.expensemanagement.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public Boolean saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		if (transactionRepository.findById(transaction.getId()) != null) {
			return true;
		}
		return false;
	}

	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}

	public Object getTransactionById(int id) {
		if (transactionRepository.findById(id) == null) {
			return "Transaction not found by this id = " + id;
		}
		return transactionRepository.findById(id);
	}

	public Object deleteTransaction(int id) {
		Object transaction = transactionRepository.findById(id);
		if (transaction == null) {
			return "Transaction not found by this id = " + id;
		}
		transactionRepository.deleteById(id);
		return "Transaction deleted by this id = " + id;
	}

	public Object updateTransaction(Transaction transaction) {
		if (transactionRepository.findById(transaction.getId()) == null) {
			return "Transaction doesn't exist. New Transaction uploaded...!";
		}
		return saveTransaction(transaction);
	}
}