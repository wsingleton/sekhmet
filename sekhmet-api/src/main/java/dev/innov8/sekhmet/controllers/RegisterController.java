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

import dev.innov8.sekhmet.models.Register;
import dev.innov8.sekhmet.services.RegisterService;

@RestController
@RequestMapping("/registers")
public class RegisterController {

	private RegisterService registerService;
	
	@Autowired
	public RegisterController(RegisterService service) {
		this.registerService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Register> getAllRegisters() {
		return this.registerService.getAllRegisters();
	}
	
	@GetMapping(value="type/{type}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Register> getRegistersByType(@PathVariable String type) {
		return registerService.getRegistersByType(type);
	}
	
	@GetMapping(value="room/{roomId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Register> getRegistersByRoomId(@PathVariable int roomId) {
		return registerService.getRegistersByRoomId(roomId);
	}
	
	@GetMapping(value="id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Register getRegisterById(@PathVariable int id) {
		return registerService.getRegisterById(id);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Register addRegister(@RequestBody Register newRegister) {
		return registerService.upsertRegister(newRegister);
	}
	
	@PatchMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Register updateRegister(@RequestBody Register updatedRegister) {
		return registerService.upsertRegister(updatedRegister);
	}
	
}
