package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        Reservation created = reservationService.addReservation(reservation);
        return ResponseEntity.created(URI.create("/reservations/" + created.getIdReservation())).body(created);
    }

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id) {
        Reservation reservation = reservationService.findReservationById(id);
        return reservation == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation reservation) {
        if (reservationService.findReservationById(id) == null) return ResponseEntity.notFound().build();
        reservation.setIdReservation(id);
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (reservationService.findReservationById(id) == null) return ResponseEntity.notFound().build();
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
