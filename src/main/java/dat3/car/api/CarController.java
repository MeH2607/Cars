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

    @GetMapping(path="/{brand}")
    CarResponse getCarsByBrand(@PathVariable String brand) throws Exception{
        return carService.getCarsByBrand(brand);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body)
    }
}
