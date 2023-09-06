package dat3.car.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {

    private int carId;
    private String userName;
    private LocalDate date;
}
