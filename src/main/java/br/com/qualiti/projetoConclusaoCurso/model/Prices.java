package br.com.qualiti.projetoConclusaoCurso.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Prices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "regular_weekend", nullable = false)
	private Double regularWeekend;
	@Column(name = "loyalty_weekend", nullable = false)
	private Double loyaltyWeekend;
	@Column(name = "regular_weekday", nullable = false)
	private Double regularWeekday;
	@Column(name = "loyalty_weekday", nullable = false)
	private Double loyaltyWeekday;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.REFRESH)
	private Hotel hotel;

	public Prices() {
		super();
	}
	
	public Prices(Double regularWeekend, Double loyaltyWeekend, Double regularWeekday, Double loyaltyWeekday1, Hotel hotel) {
		this.regularWeekend = regularWeekend;
		this.loyaltyWeekend = regularWeekend;
		this.regularWeekday = regularWeekday;
		this.loyaltyWeekday = regularWeekday;
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Prices [id=" + id + ", regularWeekend=" + regularWeekend + ", loyaltyWeekend=" + loyaltyWeekend
				+ ", regularWeekday=" + regularWeekday + ", loyaltyWeekday=" + loyaltyWeekday + "]";
	}
}
