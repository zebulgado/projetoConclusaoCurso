package br.com.qualiti.projetoConclusaoCurso.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "DateTime", nullable = false)
	private Timestamp checkin;

	@Column(columnDefinition = "DateTime", nullable = false)
	private Timestamp checkout;

	@Column(name = "room", nullable = false)
	private String room;

	@Column(name = "hotel_cnpj", nullable = false)
	private String hotel_cnpj;

	@Column(name = "guest_cnpj", nullable = false)
	private String guest_cnpj;

	public Reservation() {
		super();
	}

	public Reservation(Long id, Timestamp checkin, Timestamp checkout, String room, String hotel_cnpj,
			String guest_cnpj) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.room = room;
		this.hotel_cnpj = hotel_cnpj;
		this.guest_cnpj = guest_cnpj;
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

	public String getHotel_cnpj() {
		return hotel_cnpj;
	}

	public void setHotel_cnpj(String hotel_cnpj) {
		this.hotel_cnpj = hotel_cnpj;
	}

	public String getGuest_cnpj() {
		return guest_cnpj;
	}

	public void setGuest_cnpj(String guest_cnpj) {
		this.guest_cnpj = guest_cnpj;
	}

}