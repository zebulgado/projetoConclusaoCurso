package br.com.qualiti.projetoConclusaoCurso.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "reservation_seq_gen")
	@SequenceGenerator(name = "reservation_seq_gen", sequenceName = "reservation_id_seq")
	private Long id;

	@Column(nullable = false)
	private Date checkin;

	@Column(nullable = false)
	private Date checkout;
	
	@JsonIgnoreProperties({ "reservation" })
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Guest guest;
	
	@JsonIgnoreProperties({ "reservation" })
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

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
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
