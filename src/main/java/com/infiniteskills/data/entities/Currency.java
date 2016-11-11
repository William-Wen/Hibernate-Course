package com.infiniteskills.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.infiniteskills.data.entities.ids.CurrencyId;

@Entity
@IdClass(CurrencyId.class)
public class Currency {

	@Id
	@Column(name= "NAME")
	private String Name;
	
	@Id
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@Column(name="SYMBOL")
	private String symbol;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
