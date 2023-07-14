package com.smartHome.solution.controller;

import com.smartHome.solution.model.Booking;
import com.smartHome.solution.model.BookingRequest;
import com.smartHome.solution.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking savedBooking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(savedBooking);
    }
}


