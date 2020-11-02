package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.repository.HotelRepository;
import br.com.qualiti.projetoConclusaoCurso.repository.PricesRepository;

@Service
public class HotelService {

	private HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository, PricesRepository pricesRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	public List<Hotel> findAll(String name) {
		if (name == null) {
			return hotelRepository.findAll();
		} else {
			return hotelRepository.findByNameContainingIgnoreCase(name);
		}
	}

	public Hotel findById(String cnpj) {
		return hotelRepository.findById(cnpj).orElse(null);
	}

	public Hotel save(Hotel hotel) {
		//if (hotelRepository.findById(hotel.getCnpj()) == null) {
			hotelRepository.save(hotel);
			return hotel;
		//} else {
	//		return null;
	//	}
	}

	public Hotel update(Hotel hotel) {
		if (hotelRepository.findById(hotel.getCnpj()) != null) {
			hotelRepository.save(hotel);
			return hotel;
		} else {
			return null;
		}
	}

	public void deleteById(String cnpj) {
	//	if (hotelRepository.findById(cnpj) != null) {
	//	} else {
			hotelRepository.deleteById(cnpj);
	//	}
	}
	
	public void deleteAll() {
		hotelRepository.deleteAllInBatch();
	}
}