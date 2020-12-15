package br.com.qualiti.projetoConclusaoCurso.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import br.com.qualiti.projetoConclusaoCurso.model.Guest;
import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.repository.HotelRepository;

@Service
public class HotelService {

	private HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
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
	
	public List<Hotel> findCheaper(Guest guest, Timestamp startDate, Timestamp endDate) {
		TreeMap<Double, Hotel> rank = new TreeMap<>();
		Hotel hotelDatesUtil = new Hotel();
		List<Timestamp> timestampList = hotelDatesUtil.toTimestampList(startDate, endDate);
		
		if (validateDates(startDate, endDate)) {
			for (Hotel hotel : hotelRepository.findAll()) {
				Double totalPrice = hotel.getTotalPrice(timestampList, guest);
				if(rank.isEmpty() ||
						!rank.containsKey(totalPrice) ||
						(rank.containsKey(totalPrice) && rank.get(totalPrice).getRating() < hotel.getRating()))
				{
					rank.put(totalPrice, hotel);
				}
			}
		}
		List<Hotel> listHotel = new ArrayList<Hotel>(rank.values());
		return listHotel;
	}
	
	public Boolean validateDates(Timestamp startDate, Timestamp endDate) {
		if (startDate.after(endDate)) {
			return false;
		} else {
			Calendar cal = Calendar.getInstance();
			Timestamp timestampToday = new Timestamp(cal.getTimeInMillis());
			if (startDate.before(timestampToday)) {
				return false;
			}
		}
		return true;
	}

	public Hotel save(Hotel hotel) {
		if (hotelRepository.findById(hotel.getCnpj()).orElse(null) == null) {
			hotelRepository.save(hotel);
			return hotel;
		} else {
			return null;
		}
	}

	public Hotel update(Hotel hotel) {
		if (hotelRepository.findById(hotel.getCnpj()).orElse(null) != null) {
			hotelRepository.save(hotel);
			return hotel;
		} else {
			return null;
		}
	}

	public void deleteById(String cnpj) {
		if (hotelRepository.findById(cnpj).orElse(null) != null) {
			hotelRepository.deleteById(cnpj);
		}
	}
	
	public void deleteAll() {
		hotelRepository.deleteAllInBatch();
	}
}