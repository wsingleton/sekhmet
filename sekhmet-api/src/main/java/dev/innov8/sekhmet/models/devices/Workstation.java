package dev.innov8.sekhmet.models.devices;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.models.Room;

@Entity
@DiscriminatorValue("WS")
public class Workstation extends Device {

	public Workstation() {
		super();
	}

	public Workstation(int id, String manuf, String model, String serial, Room room) {
		super(id, manuf, model, serial, room);
	}

	public Workstation(int id, String manuf, String model, String serial, Room room, boolean sterile, boolean hazard,
			boolean radio, List<Filter> filters) 
	{
		super(id, manuf, model, serial, room, sterile, hazard, radio, filters);
		
	}
	
}
