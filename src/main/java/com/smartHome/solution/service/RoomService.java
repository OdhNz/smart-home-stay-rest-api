package com.smartHome.solution.service;

import com.smartHome.solution.model.Room;
import com.smartHome.solution.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailabilityTrue();
    }
}

