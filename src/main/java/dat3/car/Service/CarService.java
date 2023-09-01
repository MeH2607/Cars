package dat3.car.Service;

import dat3.car.DTO.CarRequest;
import dat3.car.DTO.CarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    public List<CarResponse> getCars(boolean includeAll) {
    }

    public CarResponse getCarsByBrand(String brand) {
    }

    public CarResponse addCar(CarRequest body) {
    }
}
