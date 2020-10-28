package br.com.qualiti.projetoConclusaoCurso.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "hotel")
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
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Hotel")
//	private List<Reservation> reservations;
//	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
	private List<Prices> prices;
	
	
	public Hotel() {
		super();
	}

	public Hotel(String name, String email, String phone, int rating, int price) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.rating = rating;
		this.price = price;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

//	public List<Reservation> getReservations() {
//		return reservations;
//	}
//
//	public void setReservations(List<Reservation> reservations) {
//		this.reservations = reservations;
//	}

	public List<Prices> getPrices() {
		return prices;
	}

	public void setPrices(List<Prices> prices) {
		this.prices = prices;
	}
	
	
}
