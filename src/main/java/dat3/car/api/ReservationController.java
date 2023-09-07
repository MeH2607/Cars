package dat3.car.api;

import dat3.car.DTO.ReservationRequest;
import dat3.car.DTO.ReservationResponse;
import dat3.car.Service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationResponse makeReservation(@RequestBody ReservationRequest body) {
        return reservationService.reserveCar(body);
    }
}
