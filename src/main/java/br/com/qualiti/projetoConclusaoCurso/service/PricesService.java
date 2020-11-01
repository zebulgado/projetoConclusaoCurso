package br.com.qualiti.projetoConclusaoCurso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.model.Prices;
import br.com.qualiti.projetoConclusaoCurso.repository.PricesRepository;

@Service
public class PricesService {
	
	private PricesRepository pricesRepository;
	
	public PricesService(PricesRepository pricesRepository) {
		super();
		this.pricesRepository = pricesRepository;
	}
	
	public List<Prices> findAll() {
			return pricesRepository.findAll();
	}
	
	public Prices findByCnpj(String cnpj) {
		Prices prices = pricesRepository.findByCnpj(cnpj);
		if (prices == null) {
			return null;
		} else {
		return prices;
	}
}
	
	public Prices save(Prices prices, Hotel hotel) {
		if (prices != null && hotel != null) {
			if (pricesRepository.findByCnpj(hotel.getCnpj()) == null) {
				pricesRepository.save(prices);
				return prices;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public Prices update(Prices prices, Hotel hotel) {
		if (prices != null && hotel != null) {
			if (pricesRepository.findByCnpj(hotel.getCnpj()) != null) {
				pricesRepository.save(prices);
				return prices;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	private void deleteByCnpj(String cnpj) {
		Prices prices = findByCnpj(cnpj);
		pricesRepository.deleteById(prices.getId());
	}
	
	private Long findPricesId(String cnpj) {
		Prices prices = findByCnpj(cnpj);
		return prices.getId();
		
	}

}
