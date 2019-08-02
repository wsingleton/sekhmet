package dev.innov8.sekhmet.models;

import java.util.Objects;

public class Filter {
	
	private int id;
	private String manufacturer;
	private String model;
	private String serialNumber;
	private double frameWidth;
	private double frameHeight;
	private double frameDepth;
	
	public Filter() {
		super();
	}

	public Filter(int id, String manufacturer, String model, String serialNumber, double frameWidth, double frameHeight,
			double frameDepth) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.serialNumber = serialNumber;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.frameDepth = frameDepth;
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

	public double getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(double frameWidth) {
		this.frameWidth = frameWidth;
	}

	public double getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(double frameHeight) {
		this.frameHeight = frameHeight;
	}

	public double getFrameDepth() {
		return frameDepth;
	}

	public void setFrameDepth(double frameDepth) {
		this.frameDepth = frameDepth;
	}

	public double getEffectiveFilterArea_sqft() {
		return (frameWidth - 2) * (frameHeight - 2) / 144;
	}

	@Override
	public int hashCode() {
		return Objects.hash(frameDepth, frameHeight, frameWidth, id, manufacturer, model, serialNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Filter))
			return false;
		Filter other = (Filter) obj;
		return Double.doubleToLongBits(frameDepth) == Double.doubleToLongBits(other.frameDepth)
				&& Double.doubleToLongBits(frameHeight) == Double.doubleToLongBits(other.frameHeight)
				&& Double.doubleToLongBits(frameWidth) == Double.doubleToLongBits(other.frameWidth) && id == other.id
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model)
				&& Objects.equals(serialNumber, other.serialNumber);
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", serialNumber="
				+ serialNumber + ", frameWidth=" + frameWidth + ", frameHeight=" + frameHeight + ", frameDepth="
				+ frameDepth + "]";
	}
	
}
