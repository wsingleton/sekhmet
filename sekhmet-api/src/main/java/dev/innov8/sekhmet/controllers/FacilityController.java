package dev.innov8.sekhmet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.innov8.sekhmet.models.Facility;
import dev.innov8.sekhmet.services.FacilityService;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

	private FacilityService facilityService;
	
	@Autowired
	public FacilityController(FacilityService service) {
		this.facilityService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Facility> getAllFacilities() {
		return facilityService.getAllFacilities();
	}
	
	@GetMapping(value="customer/{customerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Facility> getFacilitiesByCustomerId(@PathVariable int customerId) {
		return facilityService.getFacilitiesByCustomerId(customerId);
	}
	
	@GetMapping(value="id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Facility getAllFacilityById(@PathVariable int id) {
		return facilityService.getFacilityById(id);
	}
	
	@GetMapping(value="name/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Facility getFacilityByName(@PathVariable String name) {
		return facilityService.getFacilityByName(name);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Facility addNewFacility(@RequestBody Facility newFacility) {
		return facilityService.upsertFacility(newFacility);
	}
	
	@PatchMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Facility updateFacility(@RequestBody Facility updatedFacility) {
		return facilityService.upsertFacility(updatedFacility);
	}
	
}
