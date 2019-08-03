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

import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.services.FilterService;

@RestController
@RequestMapping("/filters")
public class FilterController {

	private FilterService filterService;
	
	@Autowired
	public FilterController(FilterService service) {
		this.filterService = service;
	}
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Filter> getAllFilters() {
		return filterService.getAllFilters();
	}
	
	@GetMapping(value="manufacturer/{manufacturer}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Filter> getFiltersByManufacturer(@PathVariable String manufacturer) {
		return filterService.getFiltersByManufacturer(manufacturer);
	}
	
	@GetMapping(value="model/{model}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Filter> getFiltersByModel(@PathVariable String model) {
		return filterService.getFiltersByModel(model);
	}
	
	@GetMapping(value="id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Filter getFilterById(@PathVariable int id) {
		return filterService.getFilterById(id);
	}
	
	@GetMapping(value="serial/{serialNumber}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Filter getFilterBySerialNumber(@PathVariable String serialNumber) {
		return filterService.getFilterBySerialNumber(serialNumber);
	}
	
	@GetMapping(value="register/{registerId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Filter getFilterByRegisterId(@PathVariable int registerId) {
		return filterService.getFilterByRegisterId(registerId);
	}
		
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Filter addNewFilter(@RequestBody Filter newFilter) {
		return filterService.upsertFilter(newFilter);
	}
	
	@PatchMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Filter updateFilter(@RequestBody Filter updatedFilter) {
		return filterService.upsertFilter(updatedFilter);
	}
	
}
