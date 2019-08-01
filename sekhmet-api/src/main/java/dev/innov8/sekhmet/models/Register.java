package dev.innov8.sekhmet.models;

import java.util.Objects;

public class Register {
	
	private int id;
	private Room room;
	private Filter filter;
	private double height;
	private double width;
	private String type;
	
	public Register() {
		super();
	}

	public Register(int id, Room room, double height, double width, String type) {
		super();
		this.id = id;
		this.room = room;
		this.height = height;
		this.width = width;
		this.type = type;
	}

	public Register(int id, Room room, Filter filter, double height, double width, String type) {
		super();
		this.id = id;
		this.room = room;
		this.filter = filter;
		this.height = height;
		this.width = width;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	public boolean isFiltered() {
		if(this.filter != null) return true;
		return false;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filter, height, id, room, type, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Register))
			return false;
		Register other = (Register) obj;
		return Objects.equals(filter, other.filter)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height) && id == other.id
				&& Objects.equals(room, other.room) && Objects.equals(type, other.type)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", room=" + room + ", filter=" + filter + ", height=" + height + ", width="
				+ width + ", type=" + type + "]";
	}
	
}
