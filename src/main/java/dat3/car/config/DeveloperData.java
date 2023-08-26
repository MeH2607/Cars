package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.ArrayList;
import java.util.List;

public class DeveloperData implements ApplicationRunner {
    CarRepository carRepository;
    public DeveloperData(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
    List<Car> carList = new ArrayList<>();

        carList.add(new Car("Toyota", "Corolla", 50.0, 10));
        carList.add(new Car("Honda", "Civic", 55.0, 8));
        carList.add(new Car("Ford", "Focus", 48.0, 12));
        carList.add(new Car("Chevrolet", "Malibu", 60.0, 5));
        carList.add(new Car("Nissan", "Altima", 52.0, 15));
        carList.add(new Car("Volkswagen", "Jetta", 45.0, 10));
        carList.add(new Car("Hyundai", "Elantra", 47.0, 10));
        carList.add(new Car("Kia", "Forte", 50.0, 10));
        carList.add(new Car("Subaru", "Impreza", 55.0, 8));
        carList.add(new Car("Mazda", "3", 53.0, 12));
        carList.add(new Car("Audi", "A3", 70.0, 5));
        carList.add(new Car("BMW", "3 Series", 75.0, 15));
        carList.add(new Car("Mercedes-Benz", "C-Class", 80.0, 10));
        carList.add(new Car("Lexus", "IS", 65.0, 10));
        carList.add(new Car("Volvo", "S60", 68.0, 10));
        carList.add(new Car("Tesla", "Model 3", 90.0, 8));
        carList.add(new Car("Porsche", "Panamera", 110.0, 12));
        carList.add(new Car("Jaguar", "XE", 100.0, 5));
        carList.add(new Car("Infiniti", "Q50", 75.0, 15));
        carList.add(new Car("Land Rover", "Range Rover", 150.0, 10));
        carRepository.saveAll(carList);
    }
}
