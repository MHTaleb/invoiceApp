package com.talcorpdz.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tva implements Serializable {

	@Id
	private Long tvaID;
	
	@NotNull
	@Indexed(unique = true)
	private String value;
	
	
	@NotNull
	@Indexed(unique = true)
	private String name;
	
	@NotNull
	@Indexed(unique = true)
	private Double rate;

	public Tva() { 
	}
	
	public Tva(@NotNull Long tvaID, @NotNull String value, @NotNull String name, @NotNull Double rate) {
		super();
		this.tvaID = tvaID;
		this.value = value;
		this.name = name;
		this.rate = rate;
	}

	public Long getTvaID() {
		return tvaID;
	}

	public void setTvaID(Long tvaID) {
		this.tvaID = tvaID;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(name, tvaID, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tva other = (Tva) obj;
		return Objects.equals(name, other.name) && Objects.equals(tvaID, other.tvaID)
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Tva [tvaID=" + tvaID + ", value=" + value + ", name=" + name + ", rate=" + rate + "]";
	}
	
	
	
	
}
