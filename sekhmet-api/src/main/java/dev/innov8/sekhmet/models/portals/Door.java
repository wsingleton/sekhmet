package dev.innov8.sekhmet.models.portals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dev.innov8.sekhmet.models.Portal;

@Entity
@DiscriminatorValue("door")
public class Door extends Portal {

	public Door() {
		super();
	}
	
	public Door(int id) {
		super(id);
	}
}
