package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.innov8.sekhmet.models.Customer;
import dev.innov8.sekhmet.repositories.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepo;
	
	@Autowired
	public CustomerService(CustomerRepository repo) {
		this.customerRepo = repo;
	}
	
	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Customer getCustomerById(int id) {
		Optional<Customer> _customer = customerRepo.findById(id);
		if(_customer.isPresent()) return _customer.get();
		else throw new RuntimeException("No customer with id, " + id + ", found!");
	}
	
	@Transactional(readOnly=true)
	public Customer getCustomerByName(String name) {
		return customerRepo.findByName(name);
	}
	
	@Transactional
	public Customer upsertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
}
