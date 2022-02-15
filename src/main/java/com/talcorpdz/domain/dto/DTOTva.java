package com.talcorpdz.domain.dto;

import java.util.Objects;

public class DTOTva {

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	private String value;
	private String name;
	private Double rate;

	public DTOTva(String value, String name, Double rate) {
		this.value = value;
		this.name = name;
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, rate, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOTva other = (DTOTva) obj;
		return Objects.equals(name, other.name) && Objects.equals(rate, other.rate)
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "DTOTva [value=" + value + ", name=" + name + ", rate=" + rate + "]";
	}
	
	

	
}
