package dat3.car.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ReservationRequest {

    private int carId;
    private String userName;
    private LocalDate date;
}
