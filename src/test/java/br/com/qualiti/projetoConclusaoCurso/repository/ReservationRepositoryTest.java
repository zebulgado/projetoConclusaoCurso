package br.com.qualiti.projetoConclusaoCurso.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import br.com.qualiti.projetoConclusaoCurso.model.Reservation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ReservationRepositoryTest {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Test
	public void readAll() {
		List<Reservation> reservations = reservationRepository.findAll();

		for (Reservation reservation : reservations) {
			System.out.println(reservation.toString());
		}
	}

	@Test
	public void readById() {
		Long id = 1L;

		Optional<Reservation> optionalReservation = reservationRepository.findById(id);
		Reservation reservation = optionalReservation.orElse(null);
		System.out.println(reservation);
	}
	@Test
	public void create() {
		Reservation reservation = new Reservation();
		reservation.setId(2L);
		reservation.setRoom("Reservation Room Teste 2");

		Reservation reservation2 = reservationRepository.save(reservation);

		System.out.println(reservation2);

	}

	@Test
	public void update() {
		Reservation reservation = new Reservation();
		reservation.setId(3L);
		reservation.setRoom("Reservation Room Teste 3");

		Reservation reservation2 = reservationRepository.save(reservation);

		System.out.println(reservation2);
	}

	@Test
	public void deleteAll() {
		reservationRepository.deleteAllInBatch();
	}

	@Test
	public void deleteById() {
		Long id = 1L;
		reservationRepository.deleteById(id);
	}

}
