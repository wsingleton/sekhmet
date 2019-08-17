package dev.innov8.sekhmet.resolvers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.innov8.sekhmet.models.Facility;
import dev.innov8.sekhmet.models.Room;
import dev.innov8.sekhmet.repositories.FacilityRepository;

@Component
public class FacilityResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	private FacilityRepository facilityRepo;
	private RoomResolver roomResolver;
	
	@Autowired
	public FacilityResolver(FacilityRepository repo) {
		this.facilityRepo = repo;
	}
	
	@Autowired
	public void setRoomResolver(RoomResolver resolver) {
		this.roomResolver = resolver;
	}
	
	@Transactional
	public Iterable<Facility> findAllFacilities() {
		return this.facilityRepo.findAll();
	}
	
	@Transactional
	public Facility findFacilityById(int facilityId) {
		Optional<Facility> _facility = this.facilityRepo.findById(facilityId);
		if(!_facility.isPresent()) return null;
		return _facility.get();
	}
	
	@Transactional
	public Iterable<Room> rooms(Facility facility) {
		return roomResolver.findRoomsByFacilityId(facility.getId());
	}

}
