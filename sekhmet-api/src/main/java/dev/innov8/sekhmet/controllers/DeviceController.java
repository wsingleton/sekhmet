package dev.innov8.sekhmet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.services.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {

	private DeviceService deviceService;
	
	@Autowired
	public DeviceController(DeviceService service) {
		this.deviceService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Device> getAllDevices() {
		return deviceService.getAllDevices();
	}
	
	@GetMapping(value="manufacturer/{manuf}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Device> getDevicesByManufacturer(@PathVariable String manuf) {
		return deviceService.getDevicesByManufacturer(manuf);
	}
	
	@GetMapping(value="model/{model}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Device> getDevicesByModel(@PathVariable String model) {
		return deviceService.getDevicesByModel(model);
	}
	
	@GetMapping(value="room/{roomId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Device> getDevicesByRoomId(@PathVariable int roomId) {
		return deviceService.getDevicesByRoomId(roomId);
	}
	
	// these should likely be RequestParams that should be used to filter resources from an endpoint
	// getSterileDevices
	// getHazardousDevice
	// getRadioactiveDevices
	
	@GetMapping(value="id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Device getDevicesByManufacturer(@PathVariable int id) {
		return deviceService.getDeviceById(id);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Device addNewDevice(@RequestBody Device device) {
		return deviceService.upsertDevice(device);
	}
	
	@PatchMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Device updateDevice(@RequestBody Device updatedDevice) {
		return deviceService.upsertDevice(updatedDevice);
	}
	
}
