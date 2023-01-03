package com.dikkulah.training.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;


@Document
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
    private Long roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BigDecimal price;

    public Reservation(Long roomNumber, LocalDate checkIn, LocalDate checkOut, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
    }
}
