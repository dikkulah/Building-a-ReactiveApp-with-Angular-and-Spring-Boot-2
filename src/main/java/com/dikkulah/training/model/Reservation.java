package com.dikkulah.training.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


@Document
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    //@Setter(AccessLevel.NONE)
    private String id;
    private Long roomNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkIn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkOut;
    private BigDecimal price;

    public Reservation() {
    }

    public Reservation(Long roomNumber, LocalDate checkIn, LocalDate checkOut, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
    }

    public Reservation(String id, Long roomNumber, LocalDate checkIn, LocalDate checkOut, BigDecimal price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
    }
}
