package dat3.car.Service;

import dat3.car.DTO.CarRequest;
import dat3.car.DTO.CarResponse;
import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;
    public CarService (CarRepository carRepository){
        this.carRepository = carRepository;
    }
    public List<CarResponse> getCars(boolean includeAll) {

        List<Car> cars = carRepository.findAll();

        return cars.stream().map((car -> new CarResponse(car, includeAll))).toList();
    }

    public CarResponse getCarsById(int id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this ID doesn't exist"));

        return new CarResponse(car, true);
    }

    public CarResponse addCar(CarRequest body) {

        //Denne her giver ingen mening, jeg skal finde en anden måde at finde duplikater
        if(carRepository.existsById(body.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car already exists");
        }
        Car newCar = CarRequest.getCarEntity(body);
        newCar = carRepository.save(newCar);
        return new CarResponse(newCar,true);
    }

    public void editCar(CarRequest body, int id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this username doesn't exist"));

        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
    }

    public void deleteCar(int id) {
        Car car = getCarById(id);
        carRepository.delete(car);
    }

    private Car getCarById(int id){
        return carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car with this Id does not exist"));

    }

    public List<CarResponse> getCarByBrand(String brand) {
        //TODO fejlhåndtering hvis brand ikke findes.
        List<Car> cars = carRepository.findAllByBrand(brand);
        return cars.stream().map((car -> new CarResponse(car, false))).toList();
    }

    public List<CarResponse> getCarsWithoutReservations() {

        return carRepository.findAll().stream()
                .filter(car -> car.getReservations().isEmpty())
                .map(car -> new CarResponse(car, false))
                .collect(Collectors.toList());
    }


    public double getAveragePrice() {
        return carRepository.findAll().stream()
                .mapToDouble(Car::getPricePrDay)
                .average()
                .orElse(0.0);
    }
}
