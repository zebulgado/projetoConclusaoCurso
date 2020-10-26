package br.com.qualiti.projetoConclusaoCurso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private int rating;
	@Column(nullable = false)
	private int price;
	
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
	
	
}
