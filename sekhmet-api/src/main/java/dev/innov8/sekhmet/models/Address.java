package dev.innov8.sekhmet.models;

import java.util.Objects;

public class Address {
	
	private String unit;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Address() {
		super();
	}
	
	public Address(String unit, String street, String city, String state, String zipcode) {
		super();
		this.unit = unit;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getAddressString() {
		return this.unit + " " + this.street + " " + this.city + ", " + this.state + " " + this.zipcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, state, street, unit, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && Objects.equals(unit, other.unit)
				&& Objects.equals(zipcode, other.zipcode);
	}

	@Override
	public String toString() {
		return "Address [unit=" + unit + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}
	
}
