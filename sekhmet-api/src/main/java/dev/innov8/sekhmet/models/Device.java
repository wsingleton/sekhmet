package dev.innov8.sekhmet.models;

import java.util.Objects;

public abstract class Device {

	private int id;
	private String manufacturer;
	private String model;
	private String serialNumber;
	private Room room;
	private boolean sterile;
	private boolean hazardous;
	private boolean radioactive;

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
			boolean radio) {
		super();
		this.id = id;
		this.manufacturer = manuf;
		this.model = model;
		this.serialNumber = serial;
		this.room = room;
		this.sterile = sterile;
		this.hazardous = hazard;
		this.radioactive = radio;
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

	@Override
	public int hashCode() {
		return Objects.hash(hazardous, id, manufacturer, model, radioactive, room, serialNumber, sterile);
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
		return hazardous == other.hazardous && id == other.id && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(model, other.model) && radioactive == other.radioactive
				&& Objects.equals(room, other.room) && Objects.equals(serialNumber, other.serialNumber)
				&& sterile == other.sterile;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", serialNumber="
				+ serialNumber + ", room=" + room + ", sterile=" + sterile + ", hazardous=" + hazardous
				+ ", radioactive=" + radioactive + "]";
	}

}
