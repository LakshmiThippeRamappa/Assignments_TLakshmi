package com.booking.dto;

public class BookingDTO {
    private Long bookingId;
    private String bookingDate;
    private int seats;
    private MovieDTO movie;
    private TheaterDTO theater;
    private CustomerDTO customer;
    
    // getters and setters
    public BookingDTO() {}
    public BookingDTO(Long bookingId, String bookingDate, int seats, MovieDTO movie, TheaterDTO theater, CustomerDTO customer) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.seats = seats;
        this.movie = movie;
        this.theater = theater;
        this.customer = customer;
    }
    
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public MovieDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}
	public TheaterDTO getTheater() {
		return theater;
	}
	public void setTheater(TheaterDTO theater) {
		this.theater = theater;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
    
}