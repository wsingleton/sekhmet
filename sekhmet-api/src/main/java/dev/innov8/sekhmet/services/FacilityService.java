package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.innov8.sekhmet.models.Facility;
import dev.innov8.sekhmet.repositories.FacilityRepository;

@Service
public class FacilityService {

	private FacilityRepository facilityRepo;
	private CustomerService customerService;
	
	@Autowired
	public FacilityService(FacilityRepository repo) {
		this.facilityRepo = repo;
	}
	
	@Autowired
	public void setCustomerService(CustomerService service) {
		this.customerService = service;
	}
	
	@Transactional(readOnly=true)
	public List<Facility> getAllFacilities() {
		return facilityRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<Facility> getFacilitiesByCustomerId(int customerId) {
		return customerService.getCustomerById(customerId).getFacilities();
	}
	
	@Transactional(readOnly=true)
	public Facility getFacilityById(int id) {
		Optional<Facility> _facility = facilityRepo.findById(id);
		if(_facility.isPresent()) return _facility.get();
		else throw new RuntimeException("No facility with id, " + id + ", found!");
	}
	
	@Transactional(readOnly=true)
	public Facility getFacilityByName(String name) {
		return facilityRepo.findByName(name);
	}
	
	@Transactional
	public Facility upsertFacility(Facility facility) {
		return facilityRepo.save(facility);
	}

}
