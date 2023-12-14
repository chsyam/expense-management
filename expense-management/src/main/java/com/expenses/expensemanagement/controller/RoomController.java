package com.expenses.expensemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.expensemanagement.bean.Room;
import com.expenses.expensemanagement.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping("/save")
	public Object saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@GetMapping("/get/all")
	public List<Room> getAllRooms() {
		return roomService.getAll();
	}

	@GetMapping("/get/{id}")
	public Object getRoomById(@PathVariable("int") int id) {
		return roomService.getRoomById(id);
	}

	@GetMapping("/delete/{id}")
	public Object delete(@PathVariable("int") int id) {
		return roomService.deleteRoom(id);
	}

	@PostMapping("/update")
	public Object updateRoomDetails(@RequestBody Room room) {
		return roomService.updateRoomDetails(room);
	}
}
