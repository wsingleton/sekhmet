package dev.innov8.sekhmet.models.devices;

import java.util.List;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.models.Room;

public class Isolator extends Device {
	
	public Isolator() {
		super();
	}

	public Isolator(int id, String manuf, String model, String serial, Room room) {
		super(id, manuf, model, serial, room);
	}

	public Isolator(int id, String manuf, String model, String serial, Room room, boolean sterile, boolean hazard,
			boolean radio, List<Filter> filters) 
	{
		super(id, manuf, model, serial, room, sterile, hazard, radio, filters);
		
	}

}
