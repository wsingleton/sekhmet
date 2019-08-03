package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.innov8.sekhmet.models.Register;
import dev.innov8.sekhmet.repositories.RegisterRepository;

@Service
public class RegisterService {

	private RegisterRepository registerRepo;
	
	@Autowired
	public RegisterService(RegisterRepository repo) {
		this.registerRepo = repo;
	}
	
	public List<Register> getAllRegisters() {
		return registerRepo.findAll();
	}
	
	public List<Register> getRegistersByType(String type) {
		return registerRepo.findByType(type);
	}
	
	public Register getRegisterById(int id) {
		Optional<Register> _register = registerRepo.findById(id);
		if(_register.isPresent()) return _register.get();
		else throw new RuntimeException("No register with id, " + id + " found!");
	}
	
	public Register upsertRegister(Register register) {
		return registerRepo.save(register);
	}
	
}
