package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dev.innov8.sekhmet.models.portals.Door;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private double area;
	
	@Column 
	private double volume;
	
	@Column
	private boolean sterile;
	
	@Column
	private boolean hazardous;
	
	@Column
	private boolean radioactive;
	
	@OneToOne
	@JoinColumn
	private Facility facility;

	@OneToMany
	private List<Register> registers;
	
	@JoinTable(
		name="ROOM_DOORS",
		joinColumns=@JoinColumn(name="ROOM_ID"),
		inverseJoinColumns=@JoinColumn(name="DOOR_ID")
		
	)	
	@ManyToMany
	private List<Door> doors;
	
	@OneToMany
	private List<Device> devices;

	public Room() {
		super();
	}
	
	public Room(int id, String name, Facility facility, boolean sterile, boolean hazard, boolean radio) {
		super();
		this.id = id;
		this.name = name;
		this.facility = facility;
		this.sterile = sterile;
		this.hazardous = hazard;
		this.radioactive = radio;
	}
	
	public Room(int id, String name, double area, double volume, boolean sterile, boolean hazardous,
			boolean radioactive, Facility facility) 
	{
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.volume = volume;
		this.sterile = sterile;
		this.hazardous = hazardous;
		this.radioactive = radioactive;
		this.facility = facility;
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

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

	public List<Door> getDoors() {
		return doors;
	}

	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, devices, doors, facility, hazardous, id, name, radioactive, registers, sterile,
				volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Room))
			return false;
		Room other = (Room) obj;
		return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area)
				&& Objects.equals(devices, other.devices) && Objects.equals(doors, other.doors)
				&& Objects.equals(facility, other.facility) && hazardous == other.hazardous && id == other.id
				&& Objects.equals(name, other.name) && radioactive == other.radioactive
				&& Objects.equals(registers, other.registers) && sterile == other.sterile
				&& Double.doubleToLongBits(volume) == Double.doubleToLongBits(other.volume);
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", area=" + area + ", volume=" + volume + ", sterile=" + sterile
				+ ", hazardous=" + hazardous + ", radioactive=" + radioactive + ", facility=" + facility + "]";
	}

}
