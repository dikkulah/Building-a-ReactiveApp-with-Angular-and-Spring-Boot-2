package com.dikkulah.training.service.impl;

import com.dikkulah.training.model.Reservation;
import com.dikkulah.training.repository.ReservationRepository;
import com.dikkulah.training.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public Mono<Reservation> getReservationById(String id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Mono<Reservation> createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Mono<Reservation> updateReservationById(String id, Reservation reservation) {
        return reservationRepository.findById(id)
                .flatMap(foundReservation ->
                {
                    if (reservation.getCheckIn() != null) foundReservation.setCheckIn(reservation.getCheckIn());
                    if (reservation.getCheckOut() != null) foundReservation.setCheckOut(reservation.getCheckOut());
                    if (reservation.getPrice() != null) foundReservation.setPrice(reservation.getPrice());
                    if (reservation.getRoomNumber() != null)
                        foundReservation.setRoomNumber(reservation.getRoomNumber());
                    return reservationRepository.save(foundReservation);
                });
    }
    @Override
    public Mono<Boolean> deleteReservationById(String id) {
        return reservationRepository.findById(id)
                .flatMap(reservation -> reservationRepository.deleteById(id).then(Mono.just(true)));
    }
}
