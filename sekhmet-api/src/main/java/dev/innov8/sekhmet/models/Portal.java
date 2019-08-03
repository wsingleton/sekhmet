package dev.innov8.sekhmet.models;

import java.util.Objects;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PORTAL_TYPE")
public abstract class Portal {
	
	@Id
	private int id;

	public Portal() {
		super();
	}

	public Portal(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Portal [id=" + id + 	"]";
	}

}
