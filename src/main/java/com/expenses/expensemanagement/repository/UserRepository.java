package com.expenses.expensemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.expensemanagement.bean.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}