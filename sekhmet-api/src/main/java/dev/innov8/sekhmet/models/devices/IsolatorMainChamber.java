package dev.innov8.sekhmet.models.devices;

import java.util.List;
import java.util.Objects;

import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.models.Portal;

public class IsolatorMainChamber {

	private Isolator isolator;
	private List<Filter> filters;
	private	List<Portal> portals;
	
	public IsolatorMainChamber(Isolator isolator, List<Filter> filters, List<Portal> portals) {
		super();
		this.isolator = isolator;
		this.filters = filters;
		this.portals = portals;
	}

	public Isolator getIsolator() {
		return isolator;
	}

	public void setIsolator(Isolator isolator) {
		this.isolator = isolator;
	}
	
	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public List<Portal> getPortals() {
		return portals;
	}

	public void setPortals(List<Portal> portals) {
		this.portals = portals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filters, isolator, portals);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IsolatorMainChamber))
			return false;
		IsolatorMainChamber other = (IsolatorMainChamber) obj;
		return Objects.equals(filters, other.filters) && Objects.equals(isolator, other.isolator) 
				&& Objects.equals(portals, other.portals);
	}

	@Override
	public String toString() {
		return "IsolatorMainChamber [isolator=" + isolator + ", filters=" + filters + ", portals=" + portals + "]";
	}
	
}
