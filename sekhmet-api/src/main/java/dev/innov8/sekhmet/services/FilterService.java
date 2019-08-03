package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.repositories.FilterRepository;

/*	
 *	TODO: 
 *	
 *	1) Add documentation to this class.
 *
 *	2) Add the following methods:
 *		
 *		public List<Filter> getFiltersByRoomId(int roomId)
 *		public List<Filter> getFiltersByFacilityId(int facilityId)
 *		public List<Filter> getFiltersByCustomerId(int customerId)
 *		public List<Filter> getFiltersByDeviceId(int deviceId) 
 *
 *	3) Write a test suite for this class
 */
@Service
public class FilterService {
	
	private FilterRepository filterRepo;
	private RegisterService registerService;
	
	@Autowired
	public FilterService(FilterRepository repo) {
		this.filterRepo = repo;
	}
	
	@Autowired
	public void setRegisterService(RegisterService service) {
		this.registerService = service;
	}
	
	@Transactional(readOnly=true)
	public List<Filter> getAllFilters() {
		return filterRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<Filter> getFiltersByManufacturer(String manufacturer) {
		if(manufacturer == null || manufacturer.isEmpty()) throw new RuntimeException("Manufacturer string cannot be null or empty!");
		else return filterRepo.findByManufacturer(manufacturer);
	}
	
	@Transactional(readOnly=true)
	public List<Filter> getFiltersByModel(String model) {
		if(model == null || model.isEmpty()) throw new RuntimeException("Model string cannot be null or empty!");
		else return filterRepo.findByModel(model);
	}
	
	@Transactional(readOnly=true)
	public Filter getFilterById(int id) {
		Optional<Filter> _filter = filterRepo.findById(id);
		if(_filter.isPresent()) return _filter.get();
		else throw new RuntimeException("No filter with id, " + id + " found!");
	}
	
	@Transactional(readOnly=true)
	public Filter getFilterBySerialNumber(String serialNumber) {
		if(serialNumber == null || serialNumber.isEmpty()) throw new RuntimeException("Serial number string cannot be null or empty!");
		else return filterRepo.findBySerialNumber(serialNumber);
	}
	
	@Transactional(readOnly=true)
	public Filter getFilterByRegisterId(int registerId) {
		if(registerId < 1) throw new RuntimeException("Invalid Register id provided!");
		return registerService.getRegisterById(registerId).getFilter();
	}
	
	public Filter upsertFilter(Filter filter) {
		return filterRepo.save(filter);
	}
	
}
