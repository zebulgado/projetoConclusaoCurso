package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.model.Prices;
import br.com.qualiti.projetoConclusaoCurso.repository.HotelRepository;
import br.com.qualiti.projetoConclusaoCurso.repository.PricesRepository;

@Service
public class PricesService {

	private PricesRepository pricesRepository;
	private HotelService hotelService;

	public PricesService(PricesRepository pricesRepository) {
		super();
		this.pricesRepository = pricesRepository;
	}

	public List<Prices> findAll() {
		return pricesRepository.findAll();
	}

	public Prices findById(String cnpj) {
		return pricesRepository.findById(cnpj).orElse(null);
	}

	public Prices save(Prices prices) {
	//	if (pricesRepository.findById(prices.getHotel().getCnpj()) == null) {
		Hotel hotel = prices.getHotel();
		hotel = hotelService.findById(prices.getCnpj());
		prices.setHotel(hotel);
			pricesRepository.save(prices);
			return prices;
	//	} else {
	//		return null;
	//	}
	}

	public Prices update(Prices prices) {
		if (pricesRepository.findById(prices.getHotel().getCnpj()) != null) {
			pricesRepository.save(prices);
			return prices;
		} else {
			return null;
		}
	}

	public void deleteById(String cnpj) {
	//	if (pricesRepository.findById(cnpj) != null) {
	//	} else {
			pricesRepository.deleteById(cnpj);
	//	}
	}
	
	public void deleteAll() {
		pricesRepository.deleteAllInBatch();
	}
}