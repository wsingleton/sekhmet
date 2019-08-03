package dev.innov8.sekhmet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

	List<Filter> findByManufacturer(String manufacturer);
	List<Filter> findByModel(String model);
	Filter findBySerialNumber(String serialNumber);
}
