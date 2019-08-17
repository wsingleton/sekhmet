package dev.innov8.sekhmet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

	List<Filter> findByManufacturer(String manufacturer);
	List<Filter> findByModel(String model);
	Filter findBySerialNumber(String serialNumber);

	@Query(nativeQuery=true, value="SELECT f.id, f.manufacturer, f.model, f.serial_number, f.frame_height, f.frame_width, f.frame_depth " + 
								   "FROM device_filters df " + 
								   "JOIN filter f " + 
								   "ON df.filters_id = f.id " + 
								   "WHERE df.device_id = :deviceId")
	List<Filter> findByDeviceId(int deviceId);
	
	@Query(nativeQuery=true, value="SELECT f.id, f.manufacturer, f.model, f.serial_number, f.frame_height, f.frame_width, f.frame_depth " + 
								   "FROM register r " + 
								   "JOIN filter f " + 
								   "ON r.filter_id = f.id " + 
								   "WHERE r.id = :registerId")
	Filter findByRegisterId(int registerId);
}
