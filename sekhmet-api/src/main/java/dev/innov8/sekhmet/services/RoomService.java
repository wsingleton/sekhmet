package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.innov8.sekhmet.models.Room;
import dev.innov8.sekhmet.repositories.RoomRepository;

@Service
public class RoomService {

	private RoomRepository roomRepo;
	
	@Autowired
	public RoomService(RoomRepository repo) {
		this.roomRepo = repo;
	}
	
	@Transactional(readOnly=true)
	public List<Room> getAllRooms() {
		return roomRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Room getRoomById(int id) {
		Optional<Room> _room = roomRepo.findById(id);
		if(_room.isPresent()) return _room.get();
		else throw new RuntimeException("No room with id, " + id + " found!");
	}
	
	@Transactional
	public Room upsertRoom(Room room) {
		return roomRepo.save(room);
	}
	
}
