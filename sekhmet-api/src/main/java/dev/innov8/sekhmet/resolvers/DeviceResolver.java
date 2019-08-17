package dev.innov8.sekhmet.resolvers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.repositories.DeviceRepository;

@Component
public class DeviceResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	private DeviceRepository deviceRepo;
	private FilterResolver filterResolver;
	
	@Autowired
	public DeviceResolver(DeviceRepository repo) {
		this.deviceRepo = repo;
	}
	
	@Autowired
	public void setFilterResolver(FilterResolver resolver) {
		this.filterResolver = resolver;
	}
	
	@Transactional
	public Iterable<Device> findAllDevices() {
		return this.deviceRepo.findAll();
	}
	
	@Transactional
	public Iterable<Device> findDevicesByManufacturer(String manufacturer) {
		return this.deviceRepo.findByManufacturer(manufacturer);
	}
	
	@Transactional
	public Iterable<Device> findDevicesByModel(String model) {
		return this.deviceRepo.findByModel(model);
	}
	
	@Transactional
	public Iterable<Device> findDevicesByRoomId(int roomId) {
		return this.deviceRepo.findByRoomId(roomId);
	}

	@Transactional
	public Iterable<Device> findDevicesByCriteria(boolean sterile, boolean hazard, boolean radio) {
		return this.deviceRepo.findByCriteria(sterile, hazard, radio);
	}
	
	@Transactional
	public Device findDeviceById(int deviceId) {
		Optional<Device> _device = this.deviceRepo.findById(deviceId);
		if(!_device.isPresent()) return null;
		else return _device.get();
	}
	
	@Transactional
	public Iterable<Filter> filters(Device device) {
		return this.filterResolver.findFiltersByDeviceId(device.getId());
	}
}
