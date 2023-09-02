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

    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    List<CarResponse> getCars(){
        return carService.getCars(false);
    }

    @GetMapping(path="/{id}")
    CarResponse getCarsByBrand(@PathVariable int id) throws Exception{
        return carService.getCarsById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    @PutMapping("/{id}")
    void editCar(@RequestBody CarRequest body, @PathVariable int id){
        carService.editCar(body,id);
    }

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable int id){
        carService.deleteCar(id);
    }

}
