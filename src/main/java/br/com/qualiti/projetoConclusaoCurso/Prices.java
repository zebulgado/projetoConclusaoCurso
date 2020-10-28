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
	@Column(name = "regularWeekdayPf", nullable = false)
	private Double regularWeekdayPf;
	@Column(name = "loyaltyWeekdayPf", nullable = false)
	private Double loyaltyWeekdayPf;

	@Column(name = "regularWeekendJb", nullable = false)
	private Double regularWeekendJb;
	@Column(name = "loyaltyWeekendJb", nullable = false)
	private Double loyaltyWeekendJb;
	@Column(name = "regularWeekdayJb", nullable = false)
	private Double regularWeekdayJb;
	@Column(name = "loyaltyWeekdayJb", nullable = false)
	private Double loyaltyWeekdayJb;

	@Column(name = "regularWeekendMa", nullable = false)
	private Double regularWeekendMa;
	@Column(name = "loyaltyWeekendMa", nullable = false)
	private Double loyaltyWeekendMa;
	@Column(name = "regularWeekdayMa", nullable = false)
	private Double regularWeekdayMa;
	@Column(name = "loyaltyWeekdayMa", nullable = false)
	private Double loyaltyWeekdayMa;

	public Prices() {
		super();
	}

	public Prices(Long id, Double regularWeekendPf, Double loyaltyWeekendPf, Double regularWeekdayPf,
			Double loyaltyWeekdayPf, Double regularWeekendJb, Double loyaltyWeekendJb, Double regularWeekdayJb,
			Double loyaltyWeekdayJb, Double regularWeekendMa, Double loyaltyWeekendMa, Double regularWeekdayMa,
			Double loyaltyWeekdayMa) {
		super();
		this.id = id;
		this.regularWeekendPf = regularWeekendPf;
		this.loyaltyWeekendPf = loyaltyWeekendPf;
		this.regularWeekdayPf = regularWeekdayPf;
		this.loyaltyWeekdayPf = loyaltyWeekdayPf;
		this.regularWeekendJb = regularWeekendJb;
		this.loyaltyWeekendJb = loyaltyWeekendJb;
		this.regularWeekdayJb = regularWeekdayJb;
		this.loyaltyWeekdayJb = loyaltyWeekdayJb;
		this.regularWeekendMa = regularWeekendMa;
		this.loyaltyWeekendMa = loyaltyWeekendMa;
		this.regularWeekdayMa = regularWeekdayMa;
		this.loyaltyWeekdayMa = loyaltyWeekdayMa;
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

	public Double getRegularWeekdayPf() {
		return regularWeekdayPf;
	}

	public void setRegularWeekdayPf(Double regularWeekdayPf) {
		this.regularWeekdayPf = regularWeekdayPf;
	}

	public Double getLoyaltyWeekdayPf() {
		return loyaltyWeekdayPf;
	}

	public void setLoyaltyWeekdayPf(Double loyaltyWeekdayPf) {
		this.loyaltyWeekdayPf = loyaltyWeekdayPf;
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

	public Double getRegularWeekdayJb() {
		return regularWeekdayJb;
	}

	public void setRegularWeekdayJb(Double regularWeekdayJb) {
		this.regularWeekdayJb = regularWeekdayJb;
	}

	public Double getLoyaltyWeekdayJb() {
		return loyaltyWeekdayJb;
	}

	public void setLoyaltyWeekdayJb(Double loyaltyWeekdayJb) {
		this.loyaltyWeekdayJb = loyaltyWeekdayJb;
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

	public Double getRegularWeekdayMa() {
		return regularWeekdayMa;
	}

	public void setRegularWeekdayMa(Double regularWeekdayMa) {
		this.regularWeekdayMa = regularWeekdayMa;
	}

	public Double getLoyaltyWeekdayMa() {
		return loyaltyWeekdayMa;
	}

	public void setLoyaltyWeekdayMa(Double loyaltyWeekdayMa) {
		this.loyaltyWeekdayMa = loyaltyWeekdayMa;
	}

}
