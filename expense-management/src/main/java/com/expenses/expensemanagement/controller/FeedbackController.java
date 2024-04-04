package com.expenses.expensemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.bean.Feedback;
import com.expenses.expensemanagement.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;

	@GetMapping("/save")
	public Object saveFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}

	@GetMapping("/get/all")
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAll();
	}

	@GetMapping("/get/{id}")
	public Object getFeedbackById(@PathVariable("int") int id) {
		return feedbackService.getFeedbackById(id);
	}

	@GetMapping("/delete/{id}")
	public Object delete(@PathVariable("int") int id) {
		return feedbackService.deleteFeedback(id);
	}

	@PostMapping("/update")
	public Object updateUser(@RequestBody Feedback feedback) {
		return feedbackService.updateFeedback(feedback);
	}
}
