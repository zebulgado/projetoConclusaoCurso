package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.repository.HotelRepository;
import br.com.qualiti.projetoConclusaoCurso.repository.PricesRepository;

@Service
public class HotelService {
	
	private HotelRepository hotelRepository;
	private PricesRepository pricesRepository;
	
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
	
	public Hotel save(Hotel hotel) { //COMPLETAR
		if (hotel != null) {
			if (hotelRepository.findById(hotel.getCnpj()) == null) {
				hotelRepository.save(hotel);
			}
		}
		return internalSave(hotel);
	}

	private Hotel internalSave(Hotel hotel) {
		return null;
	}

}
