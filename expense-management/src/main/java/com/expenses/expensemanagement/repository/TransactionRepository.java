package com.expenses.expensemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.expensemanagement.bean.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}