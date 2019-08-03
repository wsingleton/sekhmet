package dev.innov8.sekhmet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.innov8.sekhmet.models.Room;
import dev.innov8.sekhmet.services.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	private RoomService roomService;
	
	@Autowired
	public RoomController(RoomService service) {
		this.roomService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	@GetMapping(value="/id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Room getRoomById(@PathVariable int id) {
		return roomService.getRoomById(id);
	}
	
}
