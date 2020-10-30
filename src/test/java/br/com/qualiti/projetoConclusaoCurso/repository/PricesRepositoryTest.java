package br.com.qualiti.projetoConclusaoCurso.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import br.com.qualiti.projetoConclusaoCurso.model.Prices;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class PricesRepositoryTest {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	Prices pricesTest = new Prices(90.0, 80.0, 110.0, 80.0);

	@Test
	public void createTableContent() {
		Prices prices1 = new Prices(90.0, 80.0, 110.0, 80.0);
		Prices prices2 = new Prices(90.0, 80.0, 110.0, 80.0);
		Prices prices3 = new Prices(90.0, 80.0, 110.0, 80.0);
		Prices prices4 = new Prices(90.0, 80.0, 110.0, 80.0);
		Prices prices5 = new Prices(90.0, 80.0, 110.0, 80.0);
		
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
		
		for (Prices prices : pricesList) {
			System.out.println(prices.toString());
		}
	}
	
	@Test
	public void readById() {
		pricesRepository.findById(readByIdInternal(pricesTest).getId());
	}
	
	public Prices readByIdInternal(Prices prices) {
		Optional<Prices> optionalprices = pricesRepository.findById(prices.getId());
		
		Prices pricesReturn = optionalprices.orElse(null);
		
		System.out.println(pricesReturn);
		return pricesReturn;
	}
	
	@Test
	public void create() {
		if (readByIdInternal(pricesTest) == null) {
			pricesRepository.save(pricesTest);
		} else {
			System.out.println("Já existe! Operação cancelada.");
		}
	}
	
	@Test
	public void update() {
		this.pricesRepository.save(pricesTest);
	}
	
	@Test
	public void deleteById() {
		if (readByIdInternal(pricesTest) != null) {
			this.pricesRepository.delete(pricesTest);
		} else {
			System.out.println("Hotel não existe!! Operação cancelada.");
		}
	}
	
}