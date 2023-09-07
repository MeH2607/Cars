package dat3.car.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //A must for @Builder
@Builder  //I will demo it's purpose in the class
//It's really IMPORTANT that you understand the purpose of this annotation
@JsonInclude(JsonInclude.Include.NON_NULL) //
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
