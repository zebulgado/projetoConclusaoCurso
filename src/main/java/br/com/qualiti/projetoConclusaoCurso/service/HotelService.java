package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.model.Prices;
import br.com.qualiti.projetoConclusaoCurso.repository.HotelRepository;
import br.com.qualiti.projetoConclusaoCurso.repository.PricesRepository;

@Service
public class HotelService {
	
	private HotelRepository hotelRepository;
	private PricesRepository pricesRepository;

	public HotelService(HotelRepository hotelRepository, PricesRepository pricesRepository) {
		super();
		this.hotelRepository = hotelRepository;
		this.pricesRepository = pricesRepository;
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
	
	public Hotel save(Hotel hotel, Prices prices) {
		if (hotel != null && prices != null) {
			if (hotelRepository.findById(hotel.getCnpj()) == null) {
				hotelRepository.save(hotel);
				return hotel;
			} else {
				return null;
			}
		}
		return null;
	}
	
	public Hotel update(Hotel hotel, Prices prices) {
		if (hotel != null && prices != null) {
			if (hotelRepository.findById(hotel.getCnpj()) != null) {
				hotelRepository.save(hotel);
				return hotel;
			} else {
				return null;
			}
		}
		return null;
	}
	

	private void deleteById(String cnpj) {
		hotelRepository.deleteById(cnpj);
	}
}
