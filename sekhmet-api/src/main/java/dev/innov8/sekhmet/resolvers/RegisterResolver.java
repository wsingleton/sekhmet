package dev.innov8.sekhmet.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.models.Register;
import dev.innov8.sekhmet.repositories.RegisterRepository;

@Component
public class RegisterResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	private RegisterRepository registerRepo;
	private FilterResolver filterResolver;
	
	@Autowired
	public RegisterResolver(RegisterRepository repo) {
		this.registerRepo = repo;
	}
	
	@Autowired
	public void setFilterResolver(FilterResolver resolver) {
		this.filterResolver = resolver;
	}
	
	@Transactional
	public Iterable<Register> findAllRegisters() {
		return this.registerRepo.findAll();
	}
	
	@Transactional
	public Iterable<Register> findRegistersByRoomId(int roomId) {
		return this.registerRepo.findByRoomId(roomId);
	}
	
	@Transactional
	public Filter filter(Register register) {
		return this.filterResolver.findFilterByRegisterId(register.getId());
	}
	
}
