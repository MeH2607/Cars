package dat3.car.entity;

import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import dat3.car.entity.Reservation;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "Member")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles{


    @Column(length = 30)
    private String firstName;
    @Column(length = 30)
    private String lastName;
    @Column(length = 60)
    private String street;
    @Column(length = 163)
    private String city;
    @Column(length = 10)
    private String zip;
    private boolean approved;
    private int ranking;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation){
        if(reservation != null){
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }


    public Member(String user, String password, String email,
                  String firstName, String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

}
