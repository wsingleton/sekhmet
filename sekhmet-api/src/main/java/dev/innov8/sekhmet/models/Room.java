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

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.innov8.sekhmet.models.portals.Door;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@OneToOne
	@JoinColumn
	@JsonIgnore 	
	private Facility facility;
	
	@Column
	private boolean sterile;
	
	@Column
	private boolean hazardous;
	
	@Column
	private boolean radioactive;
	
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

	public Room(int id, String name, Facility facility, boolean sterile, boolean hazard, boolean radio, 
			List<Register> registers, List<Door> doors, List<Device> devices) {
		super();
		this.id = id;
		this.name = name;
		this.facility = facility;
		this.sterile = sterile;
		this.hazardous = hazard;
		this.radioactive = radio;
		this.registers = registers;
		this.doors = doors;
		this.devices = devices;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
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
		return Objects.hash(devices, facility, hazardous, id, name, doors, radioactive, registers, sterile);
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
		return Objects.equals(devices, other.devices) && Objects.equals(facility, other.facility)
				&& hazardous == other.hazardous && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(doors, other.doors) && radioactive == other.radioactive
				&& Objects.equals(registers, other.registers) && sterile == other.sterile;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", facility=" + facility + ", sterile=" + sterile + 
				", hazardous=" + hazardous + ", radioactive=" + radioactive + "]";
	}

}
