package com.expenses.expensemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.expensemanagement.bean.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}