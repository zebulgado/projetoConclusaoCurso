package br.com.qualiti.projetoConclusaoCurso.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guest {
	

	@Id
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private String cpf;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "password", nullable = false, length = 64)
	private String password;
	
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;
	
	@Column(name = "bith_date", nullable = false, columnDefinition = "DATE")
	private Date birthDate;
	
	@Column(name = "is_loyalty", nullable = false)
	private Boolean isLoyalty;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "guest", cascade = {CascadeType.REMOVE,  CascadeType.REFRESH})
	private List<Reservation> reservation;
	
	public Guest() {
		super();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getIsLoyalty() {
		return isLoyalty;
	}

	public void setIsLoyalty(Boolean isLoyalty) {
		this.isLoyalty = isLoyalty;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Guest [cpf=" + cpf + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", birthDate=" + birthDate + ", isLoyalty=" + isLoyalty + "]";
	}

}