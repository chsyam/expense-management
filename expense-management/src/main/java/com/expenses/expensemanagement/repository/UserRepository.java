package com.expenses.expensemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.expenses.expensemanagement.bean.Member;

public interface UserRepository extends JpaRepository<Member, Integer> {
	Member findByUsername(String username);

	@Query("SELECT username from Member")
	List<Object> findAllUsers();
}
