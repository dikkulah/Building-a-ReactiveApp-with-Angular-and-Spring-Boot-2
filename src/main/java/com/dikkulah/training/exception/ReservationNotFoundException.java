package com.dikkulah.training.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException() {
        super("Reservation not found");
    }
}
