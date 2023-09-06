package dat3.car.DTO;

import dat3.car.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationResponse {

    private int id;
    private int carId;
    private String brand;
    private String model;
    private String userName;
    private LocalDate reservationDate;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.carId = reservation.getCar().getId();
        this.brand = reservation.getCar().getBrand();
        this.model = reservation.getCar().getModel();
        this.userName = reservation.getMember().getFirstName() + " " + reservation.getMember().getLastName();
        this.reservationDate = reservation.getReservationDate();
    }
}
