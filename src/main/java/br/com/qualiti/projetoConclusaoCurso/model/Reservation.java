package br.com.qualiti.projetoConclusaoCurso.model;



import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Timestamp checkin;

	@Column(nullable = false)
	private Timestamp checkout;

	@Column(name = "room", nullable = false)
	private String room;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Guest guest;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Hotel hotel;

	public Reservation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCheckin() {
		return checkin;
	}

	public void setCheckin(Timestamp checkin) {
		this.checkin = checkin;
	}

	public Timestamp getCheckout() {
		return checkout;
	}

	public void setCheckout(Timestamp checkout) {
		this.checkout = checkout;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
}
