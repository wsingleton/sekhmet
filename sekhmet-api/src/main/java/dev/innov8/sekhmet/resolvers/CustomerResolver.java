package dev.innov8.sekhmet.resolvers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.innov8.sekhmet.models.Customer;
import dev.innov8.sekhmet.repositories.CustomerRepository;

@Component
public class CustomerResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	private CustomerRepository customerRepo;

	@Autowired
	public CustomerResolver(CustomerRepository repo) {
		this.customerRepo = repo;
	}

	@Transactional
	public Iterable<Customer> findAllCustomers() {
		return this.customerRepo.findAll();
	}
	
	@Transactional
	public Customer findCustomerById(int customerId) {
		Optional<Customer> _customer = this.customerRepo.findById(customerId);
		if(!_customer.isPresent()) return null;
		else return _customer.get();
	}
}
