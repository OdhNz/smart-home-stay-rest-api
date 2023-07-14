package com.smartHome.solution.service;

import com.smartHome.solution.exception.ResourceNotFoundException;
import com.smartHome.solution.model.*;
import com.smartHome.solution.repository.BookingRepository;
import com.smartHome.solution.repository.FacilityRepository;
import com.smartHome.solution.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final FacilityRepository facilityRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, FacilityRepository facilityRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.facilityRepository = facilityRepository;
    }

    public Booking createBooking(BookingRequest bookingRequest) {
        // Retrieve user, room, and selected facilities from the request
        User user = bookingRequest.getUser();
        Room room = roomRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        Set<Facility> facilities = new HashSet<>();
        for (Long facilityId : bookingRequest.getFacilityIds()) {
            Facility facility = facilityRepository.findById(facilityId)
                    .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
            facilities.add(facility);
        }

        // Calculate total price based on room and selected facilities
        double totalPrice = room.getPrice();
        for (Facility facility : facilities) {
            totalPrice += facility.getPrice();
        }

        // Create a new booking and save it in the database
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setFacilities(facilities);
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate(bookingRequest.getCheckOutDate());
        booking.setTotalPrice(totalPrice);

        return bookingRepository.save(booking);
    }
}

