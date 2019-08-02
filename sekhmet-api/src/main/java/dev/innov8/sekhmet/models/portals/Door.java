package dev.innov8.sekhmet.models.portals;

import java.util.List;

import javax.persistence.Entity;

import dev.innov8.sekhmet.models.Portal;
import dev.innov8.sekhmet.models.Room;

@Entity
public class Door extends Portal {

	public Door(int id, List<Room> rooms) {
		super(id, rooms);
	}
}
