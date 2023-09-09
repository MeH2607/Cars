package dat3.car.Service;

import dat3.car.DTO.ReservationResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationServiceTest {

    @Autowired
    ReservationRepository reservationRepository;
    ReservationService reservationService;
    Member m1, m2;
    Car c1, c2;
    Reservation r1, r2, r3;

    @Autowired
    CarRepository carRepository;

    @Autowired
    MemberRepository memberRepository;


    @BeforeEach
    void setUp() {

        reservationService = new ReservationService(carRepository, memberRepository, reservationRepository);
        m1 = new Member("user1", "pw1", "email1", "fn1", "ln1", "street1", "city1", "zip1");
        m2 = new Member("user2", "pw2", "email2", "fn2", "ln2", "street2", "city2", "zip2");
        memberRepository.save(m1);
        memberRepository.save(m2);
        c1 = new Car("Toyota", "Prius", 50, 2);
        c2 = new Car("Audi", "Avant", 20, 7);
        carRepository.save(c1);
        carRepository.save(c2);
        r1 = new Reservation(m1, c1, LocalDate.now());
        r2 = new Reservation(m2, c2, LocalDate.now());
        r3 = new Reservation(m2, c1, LocalDate.now().plusDays(10));
        reservationRepository.save(r1);
        reservationRepository.save(r2);
        reservationRepository.save(r3);
    }

    @Test
    void reservationsFromUser() {
        List<ReservationResponse> reservationList = reservationService.reservationsFromUser("user2");
        assertEquals(2, reservationList.size());
    }
}