package com.dikkulah.training.controller;

import com.dikkulah.training.exception.ReservationNotFoundException;
import com.dikkulah.training.model.Reservation;
import com.dikkulah.training.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ReservationResource {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";
    private final ReservationService reservationService;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Reservation>> getReservationById(@PathVariable String id) {
        return reservationService.getReservationById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.error(new ReservationNotFoundException()));
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Reservation>> createReservation(@RequestBody Mono<Reservation> reservationMono) {
        return reservationMono.flatMap(reservation -> reservationService.createReservation(reservation)
                .map(ResponseEntity::ok)
                .onErrorMap(throwable -> new RuntimeException(throwable.getMessage())));
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Reservation>> updateReservationById(@PathVariable String id,
                                                                   @RequestBody Mono<Reservation> reservationMono) {
        return reservationMono.flatMap(reservation -> reservationService.updateReservationById(id, reservation))
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.error(new ReservationNotFoundException()));
    }

    @DeleteMapping(path = "{id}")
    public Mono<ResponseEntity<Boolean>> deleteReservationById(@PathVariable String id) {
        return reservationService.deleteReservationById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.error(new ReservationNotFoundException()));
    }

}
