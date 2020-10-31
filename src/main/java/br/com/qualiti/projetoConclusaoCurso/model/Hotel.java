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
	private int rating;
	
	@Column(nullable = false)
	private int price;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Reservation> reservation;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Prices> prices;
	
	
	public Hotel() {
		super();
	}


	public Hotel(String cnpj, String name, String email, String phone, int rating, int price) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.rating = rating;
		this.price = price;
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


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public List<Reservation> getReservation() {
		return reservation;
	}


	public void setReservations(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public List<Prices> getPrices() {
		return prices;
	}


	public void setPrices(List<Prices> prices) {
		this.prices = prices;
	}


	@Override
	public String toString() {
		return "Hotel [cnpj=" + cnpj + ", name=" + name + ", email=" + email + ", phone=" + phone + ", rating=" + rating
				+ ", price=" + price + "]";
	}
	
	
	
}
