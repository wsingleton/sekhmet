package dev.innov8.sekhmet.models;

import java.util.Objects;

public class PointOfContact {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
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
		return Objects.hash(emailAddress, faxNumber, firstName, lastName, phoneNumber);
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
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "PointOfContact [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", faxNumber=" + faxNumber + "]";
	}

}
