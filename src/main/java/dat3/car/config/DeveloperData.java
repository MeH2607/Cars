package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
public class DeveloperData implements ApplicationRunner {
    CarRepository carRepository;
    MemberRepository memberRepository;


    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Car> carList = new ArrayList<>();

        //List generated by ChatGPT
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

        List<Member> memberList = new ArrayList<>();

        // Adding 20 instances of Member to the memberList
        memberList.add(new Member("john_doe", "pass123", "john@example.com", "John", "Doe", "Elm Street 123", "Copenhagen", "12345"));
        memberList.add(new Member("jane_smith", "secret456", "jane@example.com", "Jane", "Smith", "Oak Avenue 456", "Aarhus", "67890"));
        memberList.add(new Member("peter_jensen", "peterpass", "peter@example.com", "Peter", "Jensen", "Birch Road 789", "Odense", "23456"));
        memberList.add(new Member("lisa_andersen", "lisa123", "lisa@example.com", "Lisa", "Andersen", "Maple Street 987", "Aalborg", "56789"));
        memberList.add(new Member("michael_christensen", "michael456", "michael@example.com", "Michael", "Christensen", "Pine Lane 456", "Esbjerg", "34567"));
        memberList.add(new Member("sophia_nielsen", "sophiapass", "sophia@example.com", "Sophia", "Nielsen", "Cedar Close 654", "Roskilde", "45678"));
        memberList.add(new Member("martin_pedersen", "martinpass", "martin@example.com", "Martin", "Pedersen", "Willow Way 765", "Kolding", "56789"));
        memberList.add(new Member("emma_larsen", "emma567", "emma@example.com", "Emma", "Larsen", "Fir Street 543", "Horsens", "67890"));
        memberList.add(new Member("david_rasmussen", "davidpass", "david@example.com", "David", "Rasmussen", "Spruce Avenue 432", "Randers", "12345"));
        memberList.add(new Member("olivia_mortensen", "olivia789", "olivia@example.com", "Olivia", "Mortensen", "Holly Road 987", "Vejle", "23456"));
        memberList.add(new Member("william_petersen", "william123", "william@example.com", "William", "Petersen", "Juniper Lane 678", "Herning", "34567"));
        memberList.add(new Member("mia_lund", "mia456", "mia@example.com", "Mia", "Lund", "Redwood Close 876", "Silkeborg", "45678"));
        memberList.add(new Member("alexandra_christiansen", "alexpass", "alexandra@example.com", "Alexandra", "Christiansen", "Cypress Way 765", "Fredericia", "56789"));
        memberList.add(new Member("oliver_kristensen", "oliver789", "oliver@example.com", "Oliver", "Kristensen", "Rowan Street 543", "Holstebro", "67890"));
        memberList.add(new Member("emily_johansen", "emily567", "emily@example.com", "Emily", "Johansen", "Hemlock Avenue 432", "Sønderborg", "12345"));
        memberList.add(new Member("sophie_madsen", "sophiepass", "sophie@example.com", "Sophie", "Madsen", "Palm Road 987", "Hjørring", "23456"));
        memberList.add(new Member("noah_andreasen", "noah123", "noah@example.com", "Noah", "Andreasen", "Bamboo Lane 678", "Næstved", "34567"));
        memberList.add(new Member("lucas_olsen", "lucas456", "lucas@example.com", "Lucas", "Olsen", "Mahogany Close 876", "Viborg", "45678"));
        memberList.add(new Member("amalie_pedersen", "amaliepass", "amalie@example.com", "Amalie", "Pedersen", "Beech Way 765", "Taastrup", "56789"));
        memberList.add(new Member("mikkel_nielsen", "mikkel789", "mikkel@example.com", "Mikkel", "Nielsen", "Ash Street 543", "Slagelse", "67890"));
        memberRepository.saveAll(memberList);

    }
}
