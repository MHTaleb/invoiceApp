package com.talcorpdz.domain;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class MProduct {

	@Id
	private Long mProductID;
	
	@NotNull
	@Indexed(unique = true)
	private String value;
	
	
	@NotNull
	@Indexed(unique = true)
	private String name;
	
	@NotNull
	@Indexed(unique = true)
	private Double price;
	
	@NotNull
	private Tva appliedTVA;
	
	public MProduct() {
	}

	public MProduct(@NotNull Long mProductID, @NotNull String value, @NotNull String name, @NotNull Double price,
			@NotNull Tva appliedTVA) {
		super();
		this.mProductID = mProductID;
		this.value = value;
		this.name = name;
		this.price = price;
		this.appliedTVA = appliedTVA;
	}

	public Long getmProductID() {
		return mProductID;
	}

	public void setmProductID(Long mProductID) {
		this.mProductID = mProductID;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Tva getAppliedTVA() {
		return appliedTVA;
	}

	public void setAppliedTVA(Tva appliedTVA) {
		this.appliedTVA = appliedTVA;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mProductID, name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MProduct other = (MProduct) obj;
		return Objects.equals(mProductID, other.mProductID) && Objects.equals(name, other.name)
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "MProduct [mProductID=" + mProductID + ", value=" + value + ", name=" + name + ", price=" + price
				+ ", appliedTVA=" + appliedTVA + "]";
	}
	
	
	
	
	
}
