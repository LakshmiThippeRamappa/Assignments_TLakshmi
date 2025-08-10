package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	// Find all bookings by customer ID
    List<Booking> findByCustomerId(Long customerId);

    // Find all bookings for a movie
    List<Booking> findByMovieId(Long movieId);

    // Find all bookings for a theater
    List<Booking> findByTheaterId(Long theaterId);

}