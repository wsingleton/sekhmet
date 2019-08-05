package dev.innov8.sekhmet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	List<Facility> findByOwnerId(int ownerId);
	Facility findByName(String name);
	
}
