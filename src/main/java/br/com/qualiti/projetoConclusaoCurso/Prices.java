package br.com.qualiti.projetoConclusaoCurso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prices")
public class Prices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "regularWeekendPf", nullable = false)
	private Double regularWeekendPf;
	@Column(name = "loyaltyWeekendPf", nullable = false)
	private Double loyaltyWeekendPf;
	@Column(name = "regularWeekendJb", nullable = false)
	private Double regularWeekendJb;
	@Column(name = "loyaltyWeekendJb", nullable = false)
	private Double loyaltyWeekendJb;
	@Column(name = "regularWeekendMa", nullable = false)
	private Double regularWeekendMa;
	@Column(name = "loyaltyWeekendMa", nullable = false)
	private Double loyaltyWeekendMa;

	public Prices() {
		super();
	}

	public Prices(Long id, Double regularWeekendPf, Double loyaltyWeekendPf, Double regularWeekendJb,
			Double loyaltyWeekendJb, Double regularWeekendMa, Double loyaltyWeekendMa) {
		super();
		this.id = id;
		this.regularWeekendPf = regularWeekendPf;
		this.loyaltyWeekendPf = loyaltyWeekendPf;
		this.regularWeekendJb = regularWeekendJb;
		this.loyaltyWeekendJb = loyaltyWeekendJb;
		this.regularWeekendMa = regularWeekendMa;
		this.loyaltyWeekendMa = loyaltyWeekendMa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
