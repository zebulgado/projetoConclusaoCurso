package br.com.qualiti.projetoConclusaoCurso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Prices")
public class Prices {
	@Column(name ="regularWeekendPf", nullable = false)
	private Double regularWeekendPf;
	@Column(name ="loyaltyWeekendPf", nullable = false)
	private Double loyaltyWeekendPf;
	@Column(name ="regularWeekendJb", nullable = false)
	private Double regularWeekendJb;
	@Column(name ="loyaltyWeekendJb", nullable = false)
	private Double loyaltyWeekendJb;
	@Column(name ="regularWeekendMa", nullable = false)
	private Double regularWeekendMa;
	@Column(name ="loyaltyWeekendMa", nullable = false)
	private Double loyaltyWeekendMa;
	@Column(name ="hotel_Cnpj", nullable = false)
	private String hotel_Cnpj;

	public Prices() {
		super();
	}

	public Prices(Double regularWeekendPf, Double loyaltyWeekendPf, Double regularWeekendJb, Double loyaltyWeekendJb,
			Double regularWeekendMa, Double loyaltyWeekendMa, String hotel_Cnpj) {
		super();
		this.regularWeekendPf = regularWeekendPf;
		this.loyaltyWeekendPf = loyaltyWeekendPf;
		this.regularWeekendJb = regularWeekendJb;
		this.loyaltyWeekendJb = loyaltyWeekendJb;
		this.regularWeekendMa = regularWeekendMa;
		this.loyaltyWeekendMa = loyaltyWeekendMa;
		this.hotel_Cnpj = hotel_Cnpj;
	}

	public Double getRegularWeekendPf() {
		return regularWeekendPf;
	}

	public void setRegularWeekendPf(Double regularWeekendPf) {
		this.regularWeekendPf = regularWeekendPf;
	}

	public Double getLoyaltyWeekendPf() {
		return loyaltyWeekendPf;
	}

	public void setLoyaltyWeekendPf(Double loyaltyWeekendPf) {
		this.loyaltyWeekendPf = loyaltyWeekendPf;
	}

	public Double getRegularWeekendJb() {
		return regularWeekendJb;
	}

	public void setRegularWeekendJb(Double regularWeekendJb) {
		this.regularWeekendJb = regularWeekendJb;
	}

	public Double getLoyaltyWeekendJb() {
		return loyaltyWeekendJb;
	}

	public void setLoyaltyWeekendJb(Double loyaltyWeekendJb) {
		this.loyaltyWeekendJb = loyaltyWeekendJb;
	}

	public Double getRegularWeekendMa() {
		return regularWeekendMa;
	}

	public void setRegularWeekendMa(Double regularWeekendMa) {
		this.regularWeekendMa = regularWeekendMa;
	}

	public Double getLoyaltyWeekendMa() {
		return loyaltyWeekendMa;
	}

	public void setLoyaltyWeekendMa(Double loyaltyWeekendMa) {
		this.loyaltyWeekendMa = loyaltyWeekendMa;

	}

	public String getHotel_Cnpj() {
		return hotel_Cnpj;
	}

	public void setHotel_Cnpj(String hotel_Cnpj) {
		this.hotel_Cnpj = hotel_Cnpj;
	}

}
