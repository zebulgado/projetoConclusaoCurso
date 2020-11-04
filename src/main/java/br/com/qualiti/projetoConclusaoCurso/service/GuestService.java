package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Guest;
import br.com.qualiti.projetoConclusaoCurso.repository.GuestRepository;

@Service
public class GuestService {
	
	private GuestRepository guestRepository;

	public GuestService(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}
	
	public List<Guest> findAll(String name) {
			return guestRepository.findAll();
	}
	
	public Guest findById(Long id) {
		return guestRepository.findById(id).orElse(null);
	}
	
	public Guest create(Guest guest) {
		guest.setCpf(null);
		return guestRepository.save(guest);
	}
	
	public Guest update(Guest guest) {
		return guestRepository.save(guest);
	}
	
	public void deleteById(Long id) {
		if (findById(id) != null) {
			guestRepository.findById(id);
		}
	}
	
	public void deleteAll() {
		guestRepository.deleteAllInBatch();
	}
}
