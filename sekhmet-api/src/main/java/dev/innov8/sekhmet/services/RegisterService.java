package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.innov8.sekhmet.models.Register;
import dev.innov8.sekhmet.repositories.RegisterRepository;

/*	
 *	TODO: 
 *	
 *	1) Add documentation to this class. 
 *
 *	2) Write a test suite for this class
 */
@Service
public class RegisterService {

	private RegisterRepository registerRepo;
	private RoomService roomService;
	
	@Autowired
	public RegisterService(RegisterRepository repo) {
		this.registerRepo = repo;
	}
	
	@Autowired
	public void setRoomService(RoomService service) {
		this.roomService = service;
	}
	
	@Transactional(readOnly=true)
	public List<Register> getAllRegisters() {
		return registerRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<Register> getRegistersByType(String type) {
		return registerRepo.findByType(type);
	}
	
	@Transactional(readOnly=true)
	public List<Register> getRegistersByRoomId(int roomId) {
		if(roomId < 1) throw new RuntimeException("Invalid Register id provided!");
		return roomService.getRoomById(roomId).getRegisters();
	}
	
	@Transactional(readOnly=true)
	public Register getRegisterById(int id) {
		Optional<Register> _register = registerRepo.findById(id);
		if(_register.isPresent()) return _register.get();
		else throw new RuntimeException("No register with id, " + id + " found!");
	}
	
	@Transactional
	public Register upsertRegister(Register register) {
		return registerRepo.save(register);
	}
	
}
