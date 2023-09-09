package dat3.car.repository;

import dat3.car.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CarRepositoryTest {


    @Autowired
    CarRepository carRepository;
    boolean isInitialized = false;
    @BeforeEach
    void setUp() {
        if(!isInitialized) {
            carRepository.deleteAll();

            carRepository.save(new Car("Toyota", "Corolla", 50.0, 10));
            carRepository.save(new Car("Toyota", "Corona", 50.0, 10));
            carRepository.save(new Car("Honda", "Civic", 55.0, 8));
            carRepository.save(new Car("Ford", "Focus", 48.0, 12));
            carRepository.save(new Car("Chevrolet", "Malibu", 60.0, 5));
            carRepository.save(new Car("Nissan", "Altima", 52.0, 15));
            carRepository.save(new Car("Volkswagen", "Jetta", 45.0, 10));
            carRepository.save(new Car("Hyundai", "Elantra", 47.0, 10));
            carRepository.save(new Car("Kia", "Forte", 50.0, 10));
            carRepository.save(new Car("Subaru", "Impreza", 55.0, 8));
            carRepository.save(new Car("Mazda", "3", 53.0, 12));
            carRepository.save(new Car("Audi", "A3", 70.0, 5));
            isInitialized = true;
        }
    }

    @Test
    void findCarByBrand() {
        List<Car> cars = carRepository.findAllByBrand("Toyota");
        assertEquals(2, cars);
    }
}