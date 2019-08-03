package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Embedded
	private PointOfContact contact;
	
	@OneToMany
	private List<Facility> facilities;
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Customer(int id, String name, PointOfContact contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	
	public Customer(int id, String name, PointOfContact contact, List<Facility> facilities) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.facilities = facilities;
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

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

		@Override
	public int hashCode() {
		return Objects.hash(contact, facilities, id, name);
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
		return Objects.equals(contact, other.contact) && Objects.equals(facilities, other.facilities) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}

}
