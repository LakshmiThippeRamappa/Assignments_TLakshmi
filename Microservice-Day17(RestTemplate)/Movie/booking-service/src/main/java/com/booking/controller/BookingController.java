package com.booking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.booking.dto.BookingDTO;
import com.booking.model.Booking;
import com.booking.service.BookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create Booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // Get All Bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get Booking by ID
    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // Update Booking
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    // Delete Booking
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking deleted successfully";
    }

    // Get Booking with details from other services
    @GetMapping("/{id}/details")
    public BookingDTO getBookingDetails(@PathVariable Long id) {
        return bookingService.getBookingDetails(id);
    }
    
    // 🔹 Custom search endpoints
    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }

    @GetMapping("/movie/{movieId}")
    public List<Booking> getBookingsByMovieId(@PathVariable Long movieId) {
        return bookingService.getBookingsByMovieId(movieId);
    }

    @GetMapping("/theater/{theaterId}")
    public List<Booking> getBookingsByTheaterId(@PathVariable Long theaterId) {
        return bookingService.getBookingsByTheaterId(theaterId);
    }
}