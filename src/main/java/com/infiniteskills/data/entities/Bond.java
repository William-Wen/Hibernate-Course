package com.infiniteskills.data.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(name="BOND")
@DiscriminatorValue("BND")
public class Bond extends Investment{

//	@Id
//	@GeneratedValue
//	@Column(name="BOND_ID")
//	private Long bondId;

	@Column(name="VALUE")
	private BigDecimal value;

	@Column(name="INTEREST_RATE")
	private BigDecimal interestRate;

	@Temporal(value=TemporalType.DATE)
	@Column(name="MATURITY_DATE")
	private Date maturityDate;

//	@Column(name="PORTFOLIO_ID")
//	private Long portfolioId;

//	public Long getBondId() {
//		return bondId;
//	}
//
//	public void setBondId(Long bondId) {
//		this.bondId = bondId;
//	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

//	public Long getPortfolioId() {
//		return portfolioId;
//	}
//
//	public void setPortfolioId(Long portfolioId) {
//		this.portfolioId = portfolioId;
//	}

}
