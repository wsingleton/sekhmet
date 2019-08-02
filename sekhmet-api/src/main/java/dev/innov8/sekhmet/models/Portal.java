package dev.innov8.sekhmet.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Portal {
	
	@Id
	private int id;
	
	@JoinTable(
		name="PORTAL_ROOMS",
		joinColumns=@JoinColumn(name="ROOM_A_ID"),
		inverseJoinColumns=@JoinColumn(name="ROOM_B_ID")
	)
	@ManyToMany
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
