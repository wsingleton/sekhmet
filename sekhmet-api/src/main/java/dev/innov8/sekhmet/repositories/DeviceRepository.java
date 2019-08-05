package dev.innov8.sekhmet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

	List<Device> findByManufacturer(String manufacturer);
	List<Device> findByModel(String model);
	List<Device> findByRoomId(int roomId);
	List<Device> findBySterileTrue();
	List<Device> findByHazardousTrue();
	List<Device> findByRadioactiveTrue();
	
}
