package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.innov8.sekhmet.models.Facility;
import dev.innov8.sekhmet.repositories.FacilityRepository;

@Service
public class FacilityService {

	private FacilityRepository facilityRepo;
	
	@Autowired
	public FacilityService(FacilityRepository repo) {
		this.facilityRepo = repo;
	}
	
	public List<Facility> getAllFacilities() {
		return facilityRepo.findAll();
	}
	
	public Facility getFacilityById(int id) {
		Optional<Facility> _facility = facilityRepo.findById(id);
		if(_facility.isPresent()) return _facility.get();
		else throw new RuntimeException("No facility with id, " + id + ", found!");
	}
	
	public Facility getFacilityByName(String name) {
		return facilityRepo.findByName(name);
	}
	
	public Facility upsertFacility(Facility facility) {
		return facilityRepo.save(facility);
	}

}
