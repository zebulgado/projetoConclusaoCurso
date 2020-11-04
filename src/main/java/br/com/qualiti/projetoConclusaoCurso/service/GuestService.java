package br.com.qualiti.projetoConclusaoCurso.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		if (name == null) {
			return guestRepository.findAll();
		} else {
			return guestRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	public Guest findById(String cpf) {
		return guestRepository.findById(cpf).orElse(null);
	}
	
	public Guest save(Guest guest) throws NoSuchAlgorithmException {
		if (guestRepository.findById(guest.getCpf()).orElse(null) == null) {
			guest.setPassword(crypto(guest.getPassword()));
			guestRepository.save(guest);
			return guest;
		} else {
			return null;
		}
	}
	
	public Guest update(Guest guest) throws NoSuchAlgorithmException {
		if (guestRepository.findById(guest.getCpf()).orElse(null) != null) {
			guest.setPassword(crypto(guest.getPassword()));
			guestRepository.save(guest);
			return guest;
		} else {
			return null;
		}
	}
	
	public void deleteById(String cpf) {
		if (findById(cpf) != null) {
			guestRepository.findById(cpf);
		}
	}
	
	public void deleteAll() {
		guestRepository.deleteAllInBatch();
	}
	
	public static String crypto(String pass) throws NoSuchAlgorithmException {

	       MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	       byte messageDigest[] = algorithm.digest(pass.getBytes(StandardCharsets.UTF_8));
	       StringBuilder hexString = new StringBuilder();
	       for (byte b : messageDigest) { 
	         hexString.append(String.format("%02X", 0xFF & b));
	       }
	       String senhahex = hexString.toString();

	       return senhahex;
	}
}
