package dev.innov8.sekhmet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

	List<Device> findByManufacturer(String manufacturer);
	List<Device> findByModel(String model);
	List<Device> findByRoomId(int roomId);
	
	@Query("from Device d where d.sterile = :sterile and d.hazardous = :hazard and d.radioactive = :radio")
	List<Device> findByCriteria(boolean sterile, boolean hazard, boolean radio);
	
}
