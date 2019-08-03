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

import dev.innov8.sekhmet.models.Customer;
import dev.innov8.sekhmet.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.customerService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping(value="id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping(value="name/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerByName(@PathVariable String name) {
		return customerService.getCustomerByName(name);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
		return customerService.upsertCustomer(newCustomer);
	}
	
	@PatchMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
		return customerService.upsertCustomer(updatedCustomer);
	}
	
}
