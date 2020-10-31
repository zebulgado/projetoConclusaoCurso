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


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class HotelRepositoryTest {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	Hotel hotelTest = new Hotel("29183746562342", "Master Blaster Hotel", "email@masterblasterhotel.com.br", "81872471946", 4, 5);
	
	@Test
	public void createTableContent() {
		Hotel hotel1 = new Hotel("98776532948762", "Sweet Dreams Hotel", "email@sweetdreamshotel.com.br", "81872471946", 4, 1);
		Hotel hotel2 = new Hotel("98532452347588", "Good Night Cind Hotel", "email@goodnightcindhotel.com.br", "81873264758", 5, 2);
		Hotel hotel3 = new Hotel("29845723945798", "Fazer pra Crer Hotel", "email@fazerpracrerhotel.com.br", "81239457287", 3, 3);
		Hotel hotel4 = new Hotel("20457408759384", "Aqui se faz Hotel", "email@aquisefazhotel.com.br", "81238457628", 1, 4);
		Hotel hotel5 = new Hotel("29183746562342", "Master Blaster Hotel", "email@masterblasterhotel.com.br", "81872471946", 4, 5);
		
		List<Hotel> hotels = new ArrayList<>();
		hotels.add(hotel1);
		hotels.add(hotel2);
		hotels.add(hotel3);
		hotels.add(hotel4);
		hotels.add(hotel5);
		
		for (Hotel hotel : hotels) {
			createInternal(hotel);
		}
		
	}
	
	@Test
	public void readAll() {
		List<Hotel> holtels = hotelRepository.findAll();
		
		for (Hotel hotel : holtels) {
			System.out.println(hotel.toString());
		}
	}
	
	@Test
	public void readById() {
		hotelRepository.findById(readByIdInternal(hotelTest).getCnpj());
	}
	
	public Hotel readByIdInternal(Hotel hotel) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotel.getCnpj());
		Hotel hotelReturn = optionalHotel.orElse(null);
		
		System.out.println(hotelReturn);
		return hotelReturn;
	}
	
	@Test
	public void create() {
		if (readByIdInternal(hotelTest) == null) {
			hotelRepository.save(hotelTest);
		} else {
			System.out.println("Hotel já existe! Operação cancelada.");
		}
	}
	
	public void createInternal(Hotel hotel) {
		if (readByIdInternal(hotel) == null) {
			hotelRepository.save(hotel);
		} else {
			System.out.println("Hotel já existe! Operação cancelada.");
		}
	} 
	
	@Test
	public void update() {
		if (readByIdInternal(hotelTest) != null) {
			hotelRepository.save(hotelTest);
		} else {
			System.out.println("Hotel não existe!! Operação cancelada.");
		}
	}
	
	@Test
	public void deleteAll() {
		hotelRepository.deleteAll();
	}
	
	@Test
	public void deleteById() {
		if (readByIdInternal(hotelTest) != null) {
			hotelRepository.deleteById(hotelTest.getCnpj());;
		} else {
			System.out.println("Hotel não existe!! Operação cancelada.");
		}
	}
}