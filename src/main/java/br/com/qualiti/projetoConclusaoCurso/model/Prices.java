package br.com.qualiti.projetoConclusaoCurso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;



@Entity
public class Prices {
	@Id
	@Column(unique = true, length = 14)
	private String cnpj;
	@Column(name = "regular_weekend", nullable = false)
	private Double regularWeekend;
	@Column(name = "loyalty_weekend", nullable = false)
	private Double loyaltyWeekend;
	@Column(name = "regular_weekday", nullable = false)
	private Double regularWeekday;
	@Column(name = "loyalty_weekday", nullable = false)
	private Double loyaltyWeekday;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@MapsId
	private Hotel hotel;

	public Prices() {
		super();
	}

	public Double getRegularWeekend() {
		return regularWeekend;
	}

	public void setRegularWeekend(Double regularWeekend) {
		this.regularWeekend = regularWeekend;
	}

	public Double getLoyaltyWeekend() {
		return loyaltyWeekend;
	}

	public void setLoyaltyWeekend(Double loyaltyWeekend) {
		this.loyaltyWeekend = loyaltyWeekend;
	}

	public Double getRegularWeekday() {
		return regularWeekday;
	}

	public void setRegularWeekday(Double regularWeekday) {
		this.regularWeekday = regularWeekday;
	}

	public Double getLoyaltyWeekday() {
		return loyaltyWeekday;
	}

	public void setLoyaltyWeekday(Double loyaltyWeekday) {
		this.loyaltyWeekday = loyaltyWeekday;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
