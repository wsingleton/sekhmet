package dev.innov8.sekhmet.models.portals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dev.innov8.sekhmet.models.Portal;

@Entity
@DiscriminatorValue("opening")
public class Opening extends Portal {

	public Opening() {
		super();
	}
	
	public Opening(int id) {
		super(id);
	}
	
}
