package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Facility {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Embedded
	private Address address;
	
	@JoinColumn
	@OneToOne(fetch=FetchType.EAGER)
	private Customer owner;
	
	@JoinColumn
	@OneToOne(fetch=FetchType.EAGER)
	private PointOfContact contact;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Room> rooms;

	public Facility() {
		super();
	}

	public Facility(int id, String name, Address address, Customer owner, PointOfContact contact) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.contact = contact;
	}

	public Facility(int id, String name, Address address, Customer owner, PointOfContact contact, List<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.contact = contact;
		this.rooms = rooms;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public PointOfContact getContact() {
		return contact;
	}

	public void setContact(PointOfContact contact) {
		this.contact = contact;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contact, id, name, owner, rooms);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Facility))
			return false;
		Facility other = (Facility) obj;
		return Objects.equals(address, other.address) && Objects.equals(contact, other.contact) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(owner, other.owner)
				&& Objects.equals(rooms, other.rooms);
	}

	@Override
	public String toString() {
		return "Facility [id=" + id + ", name=" + name + ", address=" + address + ", owner=" + owner + ", contact="
				+ contact + ", rooms=" + rooms + "]";
	}

}

