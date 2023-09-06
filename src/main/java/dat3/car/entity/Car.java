package dat3.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car extends AdminDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "car_brand", unique = true, length = 50, nullable = false)
    private String brand;
    @Column(name = "car_model", unique = true, length = 60, nullable = false)
    private String model;
    @Column(name = "rental_price_day")
    private double pricePrDay;
    @Column(name = "max_discount")
    private int bestDiscount;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation){
        if(reservation != null){
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }

    public Car(int id, String brand, String model, double pricePrDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    public Car(String brand, String model, double pricePrDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }


}
