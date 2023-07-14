package com.smartHome.solution.model;

import java.time.LocalDate;
import java.util.List;

public class BookingRequest {
    private User user;
    private Long roomId;
    private List<Long> facilityIds;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    // Constructors,
    public BookingRequest(User user, Long roomId, List<Long> facilityIds, LocalDate checkInDate, LocalDate checkOutDate) {
        this.user = user;
        this.roomId = roomId;
        this.facilityIds = facilityIds;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // getters, and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<Long> getFacilityIds() {
        return facilityIds;
    }

    public void setFacilityIds(List<Long> facilityIds) {
        this.facilityIds = facilityIds;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}

