package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Reservation;
import br.com.qualiti.projetoConclusaoCurso.repository.ReservationRepository;

@Service
public class ReservationService {

	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation create(Reservation reservation) {
		reservation.setId(null);
		return reservationRepository.save(reservation);
	}

	public Reservation findById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	public Reservation save(Reservation reservation) {
		reservation.setId(null);
		return save(reservation);

	}

	public Reservation update(Reservation reservation) {
		Long id = reservation.getId();
		if (id == null) {
			return reservation;
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (reservationRepository.findById(id) != null) {
		} else {
			reservationRepository.deleteById(id);
			return;
		}
	}

	public void deleteAll() {
		reservationRepository.deleteAllInBatch();
	}

}