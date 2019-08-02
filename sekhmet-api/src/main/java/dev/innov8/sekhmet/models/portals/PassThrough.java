package dev.innov8.sekhmet.models.portals;

import java.util.List;

import dev.innov8.sekhmet.models.Portal;
import dev.innov8.sekhmet.models.Room;

public class PassThrough extends Portal {

	public PassThrough(int id, List<Room> rooms) {
		super(id, rooms);
	}
}
