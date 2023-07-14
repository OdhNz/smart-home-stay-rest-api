package com.smartHome.solution.repository;

import com.smartHome.solution.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailabilityTrue(); // Query method to find available rooms
}

