package br.com.qualiti.projetoConclusaoCurso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {
	
	@Id
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "bith_date", nullable = false)
	private String birthDate;
	
	@Column(name = "is_loyalty", nullable = false)
	private Boolean isLoyalty;

	public Guest() {
		super();
	}

	public Guest(String cpf, String name, String email, String password, String phone, String birthDate,
			Boolean isLoyalty) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthDate = birthDate;
		this.isLoyalty = isLoyalty;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getIsLoyalty() {
		return isLoyalty;
	}

	public void setIsLoyalty(Boolean isLoyalty) {
		this.isLoyalty = isLoyalty;
	}
	
	
	

}