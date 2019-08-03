package dev.innov8.sekhmet.models.portals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dev.innov8.sekhmet.models.Portal;

@Entity
@DiscriminatorValue("pass-through")
public class PassThrough extends Portal {

	public PassThrough() {
		super();
	}
	
	public PassThrough(int id) {
		super(id);
	}
}
