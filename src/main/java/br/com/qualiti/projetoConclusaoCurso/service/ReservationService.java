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

	public Reservation findById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	public Reservation save(Reservation reservation) {
		if (reservationRepository.findById(reservation.getId()).orElse(null) == null) {
			reservationRepository.save(reservation);
			return reservation;
		} else {
			return null;
		}
	}

	public Reservation update(Reservation reservation) {
		if (reservationRepository.findById(reservation.getId()).orElse(null) != null) {
			reservationRepository.save(reservation);
			return reservation;
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (reservationRepository.findById(id).orElse(null) != null) {
		} else {
			reservationRepository.deleteById(id);
		}
	}
	
	public void deleteAll() {
		reservationRepository.deleteAllInBatch();
	}

}