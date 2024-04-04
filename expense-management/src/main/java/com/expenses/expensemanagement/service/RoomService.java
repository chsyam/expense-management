package com.expenses.expensemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.expensemanagement.bean.Room;
import com.expenses.expensemanagement.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;

	public Object saveRoom(Room room) {
		roomRepository.save(room);
		if (roomRepository.findById(room.getId()) != null) {
			return "Room saved successfully";
		}
		return "Room not saved...!";
	}

	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	public Object getRoomById(int id) {
		if (roomRepository.findById(id) == null) {
			return "Room not found by this id = " + id;
		}
		return roomRepository.findById(id);
	}

	public Object deleteRoom(int id) {
		Object room = roomRepository.findById(id);
		if (room == null) {
			return "Room not found by this id = " + id;
		}
		roomRepository.deleteById(id);
		return "Room deleted by this id = " + id;
	}

	public Object updateRoomDetails(Room room) {
		if (roomRepository.findById(room.getId()) == null) {
			return "Room doesn't exist. New Room uploaded...!";
		}
		return saveRoom(room);
	}
}
