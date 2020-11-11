package br.com.qualiti.projetoConclusaoCurso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	
	@Id
	@Column(unique = true, length = 14)
	private String cnpj;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String phone;
	
	@Column(nullable = false)
	private double rating;
	
	@Column(name = "regular_weekend", nullable = false)
	private Double regularWeekend;
	
	@Column(name = "loyalty_weekend", nullable = false)
	private Double loyaltyWeekend;
	
	@Column(name = "regular_weekday", nullable = false)
	private Double regularWeekday;
	
	@Column(name = "loyalty_weekday", nullable = false)
	private Double loyaltyWeekday;
	
	@Column(name = "url_photo")
	private String urlPhoto;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Reservation> reservation;
	
	public Hotel() {
		super();
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public List<Reservation> getReservation() {
		return reservation;
	}


	public void setReservations(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
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


	public String getUrlPhoto() {
		return urlPhoto;
	}


	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}


	@Override
	public String toString() {
		return "Hotel [cnpj=" + cnpj + ", name=" + name + ", email=" + email + ", phone=" + phone + ", rating=" + rating
				+ ", regularWeekend=" + regularWeekend + ", loyaltyWeekend=" + loyaltyWeekend + ", regularWeekday="
				+ regularWeekday + ", loyaltyWeekday=" + loyaltyWeekday + ", urlPhoto=" + urlPhoto + "]";
	}
}
