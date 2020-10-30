package br.com.qualiti.projetoConclusaoCurso.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.model.Prices;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class PricesRepositoryTest {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	

	@Test
	public void saveSomePrices() {
		Hotel hotelTest = new Hotel("29183746562342", "Master Blaster Hotel", "email@masterblasterhotel.com.br", "81872471946", 4, 5);
		hotelTest = this.hotelRepository.save(hotelTest);
		
		Prices prices1 = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		Prices prices2 = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		Prices prices3 = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		Prices prices4 = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		Prices prices5 = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		
		List<Prices> pricesList = new ArrayList<>();
		pricesList.add(prices1);
		pricesList.add(prices2);
		pricesList.add(prices3);
		pricesList.add(prices4);
		pricesList.add(prices5);
		
		this.pricesRepository.saveAll(pricesList);
	}

	@Test
	public void readAll() {
		List<Prices> pricesList = pricesRepository.findAll();
	}
	
	@Test
	public void readById() {
		Optional<Prices> price = pricesRepository.findById(1L);
		System.out.println(price.get());
	}
	
	public Prices readByIdInternal(Prices prices) {
		Optional<Prices> optionalprices = pricesRepository.findById(prices.getId());
		
		Prices pricesReturn = optionalprices.orElse(null);
		
		System.out.println(pricesReturn);
		return pricesReturn;
	}
	
	@Test
	public void create() {
		Hotel hotelTest = new Hotel("29183746562342", "Master Blaster Hotel", "email@masterblasterhotel.com.br", "81872471946", 4, 5);
		hotelTest = this.hotelRepository.save(hotelTest);
		
		Prices price = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		
		pricesRepository.save(price);	
	}
	
	@Test
	public void update() {
		Hotel hotelTest = new Hotel("29183746562342", "Master Blaster Hotel", "email@masterblasterhotel.com.br", "81872471946", 4, 5);
		hotelTest = this.hotelRepository.save(hotelTest);
		
		Prices price = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		
		price = pricesRepository.save(price);
		price.setLoyaltyWeekday(9000.0);
		this.pricesRepository.save(price);
	}
	
	@Test
	public void deleteById() {
		Hotel hotelTest = new Hotel("29183746562342", "Master Blaster Hotel", "email@masterblasterhotel.com.br", "81872471946", 4, 5);
		hotelTest = this.hotelRepository.save(hotelTest);
		
		Prices price = new Prices(90.0, 80.0, 110.0, 80.0, hotelTest);
		
		price = pricesRepository.save(price);
		
		this.pricesRepository.delete(price);
	}
	
}