package dat3.car.api;

import dat3.car.DTO.ReservationRequest;
import dat3.car.DTO.ReservationResponse;
import dat3.car.Service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    //TODO Find all reservations made by a certain member
    @GetMapping(path="/reservations/{user}")
    List<ReservationResponse> reservationsFromUser(String user){
       return reservationService.reservationsFromUser(user);
    }
}
