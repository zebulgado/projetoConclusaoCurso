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
	@Column(name = "regularWeekend", nullable = false)
	private Double regularWeekend;
	@Column(name = "loyaltyWeekend", nullable = false)
	private Double loyaltyWeekend;
	@Column(name = "regularWeekday", nullable = false)
	private Double regularWeekday;
	@Column(name = "loyaltyWeekday", nullable = false)
	private Double loyaltyWeekday;

	public Prices() {
		super();
	}

	public Prices(Long id, Double regularWeekend, Double loyaltyWeekend, Double regularWeekday, Double loyaltyWeekday) {
		super();
		this.id = id;
		this.regularWeekend = regularWeekend;
		this.loyaltyWeekend = loyaltyWeekend;
		this.regularWeekday = regularWeekday;
		this.loyaltyWeekday = loyaltyWeekday;
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

}
