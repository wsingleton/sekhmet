package dev.innov8.sekhmet.models.devices;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.models.Room;

@Entity
@DiscriminatorValue("FH")
public class FumeHood extends Device {

	public FumeHood() {
		super();
	}

	public FumeHood(int id, String manuf, String model, String serial, Room room) {
		super(id, manuf, model, serial, room);
	}

	public FumeHood(int id, String manuf, String model, String serial, Room room, boolean sterile, boolean hazard,
			boolean radio, List<Filter> filters) 
	{
		super(id, manuf, model, serial, room, sterile, hazard, radio, filters);
		
	}
}
