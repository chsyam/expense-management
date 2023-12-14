package com.expenses.expensemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.expensemanagement.bean.Feedback;
import com.expenses.expensemanagement.repository.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;

	public Object saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
		if (feedbackRepository.findById(feedback.getId()) != null) {
			return "feedback saved successfully";
		}
		return "feedback not saved...!";
	}

	public List<Feedback> getAll() {
		return feedbackRepository.findAll();
	}

	public Object getFeedbackById(int id) {
		if (feedbackRepository.findById(id) == null) {
			return "User not found by this id = " + id;
		}
		return feedbackRepository.findById(id);
	}

	public Object deleteFeedback(int id) {
		Object feeback = feedbackRepository.findById(id);
		if (feeback == null) {
			return "User not found by this id = " + id;
		}
		feedbackRepository.deleteById(id);
		return "User deleted by this id = " + id;
	}

	public Object updateFeedback(Feedback feedback) {
		if (feedbackRepository.findById(feedback.getId()) == null) {
			return "Feedback doesn't exist. New Feedback uploaded...!";
		}
		return saveFeedback(feedback);
	}
}
