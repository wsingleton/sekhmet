package dev.innov8.sekhmet.models;

import java.util.Objects;

public class Customer {

	private int id;
	private String name;
	private PointOfContact contact;
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String name, PointOfContact contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PointOfContact getContact() {
		return contact;
	}

	public void setContact(PointOfContact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contact, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(contact, other.contact) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}

}
