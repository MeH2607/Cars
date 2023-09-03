package dat3.car.DTO;

import dat3.car.entity.Car;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //A must for @Builder
@Builder  //I will demo it's purpose in the class
public class CarRequest {

    private int id;
    private String brand;
    private String model;
    private double pricePrDay;

    public static Car getCarEntity(CarRequest c){
        return new Car(c.getId(), c.getBrand(), c.getModel(), c.getPricePrDay());
    }

    // Car to CarRequest conversion
    public CarRequest(Car c){
        this.id = c.getId();
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePrDay = c.getPricePrDay();
    }

    public CarRequest(String brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }
}
