package dat3.car.Service;

import dat3.car.DTO.ReservationRequest;
import dat3.car.DTO.ReservationResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    CarRepository carRepository;
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;

    public ReservationService(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponse reserveCar(ReservationRequest body) {

        if(body.getDate().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation date cannot be in the past");
        }
        Member member = memberRepository.findById(body.getUserName()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not found"));
        Car car = carRepository.findById(body.getCarId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not found"));

        if(reservationRepository.existsByCar_idAndReservationDate(car.getId(), body.getDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is already reserved for this date");
        }
        Reservation reservation = new Reservation(member, car, body.getDate());
        return new ReservationResponse(reservation);
    }

    public List<ReservationResponse> reservationsFromUser(String user) {
//TODO fejlhåndtering hvis userName ikke findes.
      return  reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getMember().getUsername().equals(user))
                .map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    }
}
