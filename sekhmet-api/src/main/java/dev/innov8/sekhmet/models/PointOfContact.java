package dev.innov8.sekhmet.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PointOfContact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String emailAddress;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String faxNumber;

	public PointOfContact() {
		super();
	}

	public PointOfContact(String fn, String ln, String email, String phone, String fax) {
		super();
		this.firstName = fn;
		this.lastName = ln;
		this.emailAddress = email;
		this.phoneNumber = phone;
		this.faxNumber = fax;
	}
	
	public PointOfContact(int id, String fn, String ln, String email, String phone, String fax) {
		super();
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.emailAddress = email;
		this.phoneNumber = phone;
		this.faxNumber = fax;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailAddress, faxNumber, firstName, id, lastName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PointOfContact))
			return false;
		PointOfContact other = (PointOfContact) obj;
		return Objects.equals(emailAddress, other.emailAddress) && Objects.equals(faxNumber, other.faxNumber)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "PointOfContact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", phoneNumber=" + phoneNumber + ", faxNumber=" + faxNumber + "]";
	}

}
