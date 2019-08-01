package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

public abstract class Portal {
	
	private int id;
	private List<Zone> zones;

	public Portal() {
		super();
	}

	public Portal(int id, List<Zone> zones) {
		super();
		this.id = id;
		this.zones = zones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, zones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Portal))
			return false;
		Portal other = (Portal) obj;
		return id == other.id && Objects.equals(zones, other.zones);
	}

	@Override
	public String toString() {
		return "Portal [id=" + id + ", zones=" + zones + "]";
	}

}
