package dev.innov8.sekhmet.resolvers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.repositories.FilterRepository;

@Component
public class FilterResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	private FilterRepository filterRepo;
	
	@Autowired
	public FilterResolver(FilterRepository repo) {
		this.filterRepo = repo;
	}
	
	@Transactional
	public Iterable<Filter> findAllFilters() {
		return this.filterRepo.findAll();
	}
	
	@Transactional
	public Iterable<Filter> findFiltersByManufacturer(String manufacturer) {
		return this.filterRepo.findByManufacturer(manufacturer);
	}
	
	@Transactional
	public Iterable<Filter> findFiltersByModel(String model) {
		return this.filterRepo.findByModel(model);
	}
	
	@Transactional
	public Iterable<Filter> findFiltersByDeviceId(int deviceId) {
		return this.filterRepo.findByDeviceId(deviceId);
	}
	
	@Transactional
	public Filter findFilterById(int filterId) {
		Optional<Filter> _filter = this.filterRepo.findById(filterId);
		if(!_filter.isPresent()) return null;
		else return _filter.get();
	}
	
	@Transactional
	public Filter findFilterBySerialNumber(String serial) {
		return this.filterRepo.findBySerialNumber(serial);
	}
	
	@Transactional
	public Filter findFilterByRegisterId(int registerId) {
		return this.filterRepo.findByRegisterId(registerId);
	}

}
