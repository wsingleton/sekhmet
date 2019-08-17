package dev.innov8.sekhmet.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.models.Facility;
import dev.innov8.sekhmet.models.Register;
import dev.innov8.sekhmet.models.Room;
import dev.innov8.sekhmet.repositories.RoomRepository;
import graphql.schema.DataFetchingEnvironment;

@Component
public class RoomResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	private RoomRepository roomRepo;
	private FacilityResolver facilityResolver;
	private DeviceResolver deviceResolver;
	private RegisterResolver registerResolver;
	
	@Autowired
	public RoomResolver(RoomRepository repo) {
		this.roomRepo = repo;
	}
	
	@Autowired
	public void setFacilityResolver(FacilityResolver resolver) {
		this.facilityResolver = resolver;
	}
	
	@Autowired
	public void setDeviceResolver(DeviceResolver resolver) {
		this.deviceResolver = resolver;
	}
	
	@Autowired
	public void setRegisterResolver(RegisterResolver resolver) {
		this.registerResolver = resolver;
	}
	
	@Transactional
	public Iterable<Room> findAllRooms(DataFetchingEnvironment env) {
		return this.roomRepo.findAll();
	}
	
	@Transactional
	public Iterable<Room> findRoomsByFacilityId(int facilityId) {
		return this.roomRepo.findByFacilityId(facilityId);
	}
	
	@Transactional
	public Facility facility(Room room) {
		return this.facilityResolver.findFacilityById(room.getFacility().getId());
	}
	
	@Transactional
	public Iterable<Device> devices(Room room) {
		return this.deviceResolver.findDevicesByRoomId(room.getId());
	}
	
	@Transactional
	public Iterable<Register> register(Room room) {
		return this.registerResolver.findRegistersByRoomId(room.getId());
	}
	
}
