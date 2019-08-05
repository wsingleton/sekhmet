package dev.innov8.sekhmet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.repositories.DeviceRepository;

@Service
public class DeviceService {

	private DeviceRepository deviceRepo;
	
	@Autowired
	public DeviceService(DeviceRepository repo) {
		this.deviceRepo = repo;
	}
	
	@Transactional(readOnly=true)
	public List<Device> getAllDevices() {
		return deviceRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<Device> getDevicesByManufacturer(String manufacturer) {
		return deviceRepo.findByManufacturer(manufacturer);
	}
	
	@Transactional(readOnly=true)
	public List<Device> getDevicesByModel(String model) {
		return deviceRepo.findByModel(model);
	}
	
	@Transactional(readOnly=true)
	public List<Device> getDevicesByRoomId(int roomId) {
		return deviceRepo.findByRoomId(roomId);
	}
	
	@Transactional(readOnly=true)
	public List<Device> getSterileDevices() {
		return deviceRepo.findBySterileTrue();
	}
	
	@Transactional(readOnly=true)
	public List<Device> getHazardousDevices() {
		return deviceRepo.findByHazardousTrue();
	}
	
	@Transactional(readOnly=true)
	public List<Device> getRadioactiveDevices() {
		return deviceRepo.findByRadioactiveTrue();
	}
	
	@Transactional(readOnly=true)
	public Device getDeviceById(int id) {
		Optional<Device> _device = deviceRepo.findById(id);
		if(_device.isPresent()) return _device.get();
		else throw new RuntimeException("No device with id, " + id + ", found!");
	}
	
	@Transactional
	public Device upsertDevice(Device device) {
		return deviceRepo.save(device);
	}
	
}
