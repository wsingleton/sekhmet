package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

public class Room {
	
	private int id;
	private String name;
	private Facility facility;
	private boolean sterile;
	private boolean hazardous;
	private boolean radioactive;
	private List<Register> registers;
	private List<Portal> portals;
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
			List<Register> registers, List<Portal> portals, List<Device> devices) {
		super();
		this.id = id;
		this.name = name;
		this.facility = facility;
		this.sterile = sterile;
		this.hazardous = hazard;
		this.radioactive = radio;
		this.registers = registers;
		this.portals = portals;
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

	public List<Portal> getPortals() {
		return portals;
	}

	public void setPortals(List<Portal> portals) {
		this.portals = portals;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(devices, facility, hazardous, id, name, portals, radioactive, registers, sterile);
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
				&& Objects.equals(portals, other.portals) && radioactive == other.radioactive
				&& Objects.equals(registers, other.registers) && sterile == other.sterile;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", facility=" + facility + ", sterile=" + sterile + 
				", hazardous=" + hazardous + ", radioactive=" + radioactive + "]";
	}

}
