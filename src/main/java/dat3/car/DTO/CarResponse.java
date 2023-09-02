package dat3.car.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.entity.Car;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //A must for @Builder
@Builder  //I will demo it's purpose in the class
//It's really IMPORTANT that you understand the purpose of this annotation
@JsonInclude(JsonInclude.Include.NON_NULL) //
public class CarResponse {

    private Integer id;
    private String brand;
    private String model;
    private double pricePrDay;
    private Integer bestDiscount;

    public CarResponse(Car c, boolean includeAll) {

        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePrDay = c.getPricePrDay();
        if (includeAll) {
            this.id = c.getId();
            this.bestDiscount = c.getBestDiscount();
        }
    }
}
