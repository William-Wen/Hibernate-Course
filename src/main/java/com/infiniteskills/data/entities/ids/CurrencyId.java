package com.infiniteskills.data.entities.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

@SuppressWarnings("serial")
public class CurrencyId implements Serializable{

	private String Name;
	
	private String countryName;
	
	public CurrencyId() {
		// TODO Auto-generated constructor stub
	}
	
	public CurrencyId(String name, String countryName) {
		super();
		Name = name;
		this.countryName = countryName;
	}

	public String getName() {
		return Name;
	}

	public String getCountryName() {
		return countryName;
	}


}
