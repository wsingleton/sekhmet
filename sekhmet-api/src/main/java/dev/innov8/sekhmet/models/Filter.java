package dev.innov8.sekhmet.models;

import java.text.DecimalFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String manufacturer;
	
	@Column
	private String model;
	
	@Column
	private String serialNumber;
	
	@Column
	private double frameWidth;
	
	@Column
	private double frameHeight;
	
	@Column
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
		DecimalFormat df = new DecimalFormat("0.000");
		String filterAreaAsString = df.format((frameWidth - 2) * (frameHeight - 2) / 144);
		return Double.parseDouble(filterAreaAsString);
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
