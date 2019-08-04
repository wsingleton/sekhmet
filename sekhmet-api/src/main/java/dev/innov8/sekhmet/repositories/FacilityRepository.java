package dev.innov8.sekhmet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	Facility findByName(String name);
	
}
