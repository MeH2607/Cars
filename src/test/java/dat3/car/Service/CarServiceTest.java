package dat3.car.Service;

import dat3.car.DTO.CarRequest;
import dat3.car.DTO.CarResponse;
import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//This test will be using H2 to simulate the database
@DataJpaTest
class CarServiceTest {
    //TODO flere tests

    @Autowired
    CarRepository carRepository;
    CarService carService;
    Car c1, c2;

    @BeforeEach
    void setup() {
        c1 = carRepository.save(new Car("Toyota", "Prius", 50, 2));
        c2 = carRepository.save(new Car("Audi", "Avant", 20, 7));
        carService = new CarService(carRepository);
    }

    @Test
    void getCarsLimitedDetails() {
        //testing that the right amount of data is saved
        List<CarResponse> responses = carService.getCars(false);
        assertEquals(2, responses.size());
        //Testng that ID is null.
        Integer testId = responses.get(1).getId();
        assertNull(testId);
    }

    @Test
    void getCarsAllDetails() {
        //testing that the right amount of data is saved
        List<CarResponse> responses = carService.getCars(true);
        assertEquals(2, responses.size());
        //Testng that ID is not null and has a value.
        Integer testId = responses.get(1).getId();
        assertNotNull(testId);
    }

    @Test
    void getCarsById() {
        CarResponse response = carService.getCarsById(1);
        assertEquals(1, response.getId());
    }

    @Test
    void addCar() {

        CarRequest request = CarRequest.builder().
                brand("BMW").
                model("M8").
                pricePrDay(80).
                build();
        CarResponse response = carService.addCar(request);
        int dbSize = carRepository.findAll().size();
        assertEquals("BMW", response.getBrand());
        assertTrue(carRepository.existsById(3));
        assertEquals(3, dbSize);
    }

    @Test
    void editCar() {
        CarRequest body = new CarRequest(c1);
        body.setPricePrDay(60);
        carService.editCar(body, 1);
        assertEquals(60, c1.getPricePrDay());
    }

    @Test
    void deleteCar() {
        carService.deleteCar(1);
        assertFalse(carRepository.existsById(1));
    }
}