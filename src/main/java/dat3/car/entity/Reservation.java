package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation extends AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Car car;

    private LocalDate reservationDate;

    public Reservation(Member member, Car car, LocalDate reservationDate) {
        this.member = member;
        this.car = car;
        this.reservationDate = reservationDate;
        car.addReservation(this);
        member.addReservation(this);
    }
}
