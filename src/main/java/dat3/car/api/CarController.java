package dat3.car.api;

import dat3.car.DTO.CarRequest;
import dat3.car.DTO.CarResponse;
import dat3.car.Service.CarService;
import dat3.car.entity.Car;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Security : Anonymus
    @GetMapping
    List<CarResponse> getCars() {
        return carService.getCars(false);
    }

    //Security : Anonymus
    @GetMapping(path = "/{id}")
    CarResponse getCarsById(@PathVariable int id) throws Exception {
        return carService.getCarsById(id);
    }

    //Security : Admin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body) {
        return carService.addCar(body);
    }

    //Security : Admin
    @PutMapping("/{id}")
    void editCar(@RequestBody CarRequest body, @PathVariable int id) {
        carService.editCar(body, id);
    }

    //Security : Admin
    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }

    //TODO Find all cars with a certain brand and model
    //Security: Anonymus
    @GetMapping(path = "/brand/{brand}")
    List<CarResponse> getCarByBrand(@PathVariable String brand){
        return carService.getCarByBrand(brand);
    }

    //TODO Find all cars that have not been reserved
    //Security: User
    @GetMapping(path="/noReservations")
    List<CarResponse> getCarsWithoutReservations(){
        return carService.getCarsWithoutReservations();
    }

    //TODO Find all cars with the best discount

    //TODO Find the average price per day of all cars in the system
    @GetMapping(path="average")
    double getAveragePricePerDay(){
        return carService.getAveragePrice();
    }



}
