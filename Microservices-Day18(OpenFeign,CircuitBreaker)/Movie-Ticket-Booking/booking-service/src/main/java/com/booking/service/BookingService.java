package com.booking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booking.dto.BookingDTO;
import com.booking.dto.CustomerDTO;
import com.booking.dto.MovieDTO;
import com.booking.dto.TheaterDTO;
import com.booking.model.Booking;
import com.booking.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Fixed URLs for other services
    private final String MOVIE_SERVICE_URL = "http://localhost:1002/api/movies/";
    private final String THEATER_SERVICE_URL = "http://localhost:1001/api/theaters/";
    private final String CUSTOMER_SERVICE_URL = "http://localhost:1003/api/customers/";
    
    // Create Booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Get All Bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get Booking by ID
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Update Booking
    public Booking updateBooking(Long id, Booking booking) {
        if (bookingRepository.existsById(id)) {
            booking.setId(id);
            return bookingRepository.save(booking);
        }
        return null;
    }

    // Delete Booking
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    // Get Booking with Details from other services
    public BookingDTO getBookingDetails(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElse(null);

        MovieDTO movie = restTemplate.getForObject(MOVIE_SERVICE_URL + booking.getMovieId(), MovieDTO.class);
        TheaterDTO theater = restTemplate.getForObject(THEATER_SERVICE_URL + booking.getTheaterId(), TheaterDTO.class);
        CustomerDTO customer = restTemplate.getForObject(CUSTOMER_SERVICE_URL + booking.getCustomerId(), CustomerDTO.class);

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setSeats(booking.getSeats());
        bookingDTO.setMovie(movie);
        bookingDTO.setTheater(theater);
        bookingDTO.setCustomer(customer);

        return bookingDTO;
    }
    
    // 🔹 Custom repository method implementations
    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public List<Booking> getBookingsByMovieId(Long movieId) {
        return bookingRepository.findByMovieId(movieId);
    }

    public List<Booking> getBookingsByTheaterId(Long theaterId) {
        return bookingRepository.findByTheaterId(theaterId);
    }
}
