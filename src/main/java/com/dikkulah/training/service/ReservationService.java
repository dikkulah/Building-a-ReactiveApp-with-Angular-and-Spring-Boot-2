package com.dikkulah.training.service;


import com.dikkulah.training.model.Reservation;
import reactor.core.publisher.Mono;

public interface ReservationService {

    Mono<Reservation> getReservationById(String id);

    Mono<Reservation> createReservation(Reservation reservation  );

    Mono<Reservation> updateReservationById(String id, Reservation reservation);

    Mono<Boolean> deleteReservationById(String id);

}
