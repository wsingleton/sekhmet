package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DEVICE_TYPE")
public abstract class Device {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String manufacturer;
	
	@Column
	private String model;
	
	@Column
	private String serialNumber;
	
	@OneToOne
	@JoinColumn
	@JsonIgnore
	private Room room;
	
	@Column
	private boolean sterile;
	
	@Column
	private boolean hazardous;
	
	@Column
	private boolean radioactive;
	
	@OneToMany
	private List<Filter> filters;

	public Device() {
		super();
	}

	public Device(int id, String manufacturer, String model, String serialNumber, Room room) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.serialNumber = serialNumber;
		this.room = room;
	}

	public Device(int id, String manuf, String model, String serial, Room room, boolean sterile, boolean hazard,
			boolean radio, List<Filter> filters) 
	{
		super();
		this.id = id;
		this.manufacturer = manuf;
		this.model = model;
		this.serialNumber = serial;
		this.room = room;
		this.sterile = sterile;
		this.hazardous = hazard;
		this.radioactive = radio;
		this.filters = filters;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isSterile() {
		return sterile;
	}

	public void setSterile(boolean sterile) {
		this.sterile = sterile;
	}

	public boolean isHazardous() {
		return hazardous;
	}

	public void setHazardous(boolean hazardous) {
		this.hazardous = hazardous;
	}

	public boolean isRadioactive() {
		return radioactive;
	}

	public void setRadioactive(boolean radioactive) {
		this.radioactive = radioactive;
	}
	
	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	public boolean isFiltered() {
		if(this.filters == null || this.filters.isEmpty()) return false;
		else return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filters, hazardous, id, manufacturer, model, radioactive, room, serialNumber, sterile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Device))
			return false;
		Device other = (Device) obj;
		return Objects.equals(filters, other.filters) && hazardous == other.hazardous && id == other.id
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model)
				&& radioactive == other.radioactive && Objects.equals(room, other.room)
				&& Objects.equals(serialNumber, other.serialNumber) && sterile == other.sterile;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", serialNumber="
				+ serialNumber + ", room=" + room + ", sterile=" + sterile + ", hazardous=" + hazardous
				+ ", radioactive=" + radioactive + "]";
	}

}
