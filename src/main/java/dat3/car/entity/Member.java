package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Member")
public class Member extends AdminDetails{

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(unique = true, length = 50)
    private String email;
    @Column(length = 50)
    private String password;
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


    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = user;
        this.password= password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

}
