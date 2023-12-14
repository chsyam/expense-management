package com.expenses.expensemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.expensemanagement.bean.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}