package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

public abstract class Portal {
	
	private int id;
	private List<Room> rooms;

	public Portal() {
		super();
	}

	public Portal(int id, List<Room> rooms) {
		super();
		this.id = id;
		this.rooms = rooms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rooms);
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
		return id == other.id && Objects.equals(rooms, other.rooms);
	}

	@Override
	public String toString() {
		return "Portal [id=" + id + ", rooms=" + rooms + "]";
	}

}
