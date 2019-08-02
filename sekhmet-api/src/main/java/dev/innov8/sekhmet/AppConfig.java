package dev.innov8.sekhmet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.innov8.sekhmet.models.Address;
import dev.innov8.sekhmet.models.Customer;
import dev.innov8.sekhmet.models.Device;
import dev.innov8.sekhmet.models.Facility;
import dev.innov8.sekhmet.models.Filter;
import dev.innov8.sekhmet.models.PointOfContact;
import dev.innov8.sekhmet.models.Portal;
import dev.innov8.sekhmet.models.Register;
import dev.innov8.sekhmet.models.Room;
import dev.innov8.sekhmet.models.devices.CleanBench;
import dev.innov8.sekhmet.models.portals.Door;

@SpringBootApplication
public class AppConfig {

	public static void main(String[] args) {
		test();
		SpringApplication.run(AppConfig.class, args);
	}
	
	private static void test() {
		Customer customer = setUp();

		System.out.println("Customer ID: " + customer.getId());
		System.out.println("Customer ID: " + customer.getName());
		System.out.println("Customer Contact Name: " + customer.getContact().getFirstName() + " " + customer.getContact().getLastName());
		System.out.println("Customer Contact Phone: " + customer.getContact().getPhoneNumber());
		System.out.println("Customer Contact Fax: " + customer.getContact().getFaxNumber());
		System.out.println("Customer Contact Email: " + customer.getContact().getEmailAddress());
		
		System.out.println("\n" + customer.getName() + "'s Facilities");
		System.out.println("+--------------------------------------------------------+\n");

		List<Facility> customerFacilities = customer.getFacilities();
		for (Facility facility : customerFacilities) {
			
			System.out.println("\tFacility ID: " + facility.getId());
			System.out.println("\tFacility Name: " + facility.getName());
			System.out.println("\tFacility Address: " + facility.getAddress().getAddressString());
			System.out.println("\tFacility Contact Name: " + facility.getContact().getFirstName() + " " + facility.getContact().getLastName());
			System.out.println("\tFacility Contact Phone: " + facility.getContact().getPhoneNumber());
			System.out.println("\tFacility Contact Fax: " + facility.getContact().getFaxNumber());
			System.out.println("\tFacility Contact Email: " + facility.getContact().getEmailAddress());
			
			System.out.println("\n\t" + customer.getName() + " - " + facility.getName() + " Rooms");
			System.out.println("\t+--------------------------------------------------------+\n");
			List<Room> facilityRooms = facility.getRooms();
			for(Room room : facilityRooms) {
				
				System.out.println("\t\tRoom ID: " + room.getId());
				System.out.println("\t\tRoom Name: " + room.getName());
				
				System.out.println("\n\t\t" + room.getName() + " Portals");
				System.out.println("\t\t+-------------------------------------------------------------------------+\n");
				
				List<Portal> roomPortals = room.getPortals();
				for(Portal portal : roomPortals) {
					System.out.println("\t\t\tPortal ID: " + portal.getId());
					
					List<Room> portalRooms = portal.getRooms();
					for(Room portalRoom : portalRooms) {
						System.out.println("\t\t\t\tRoom ID: " + portalRoom.getId());
						System.out.println("\t\t\t\tRoom Name: " + portalRoom.getName() + "\n");;
					}
					System.out.println("\t\t\t+-----------------------------------------------------------------+\n");
				}
				
				
				List<Register> roomRegisters = room.getRegisters();
				if(roomRegisters != null) {
					System.out.println("\n\t\t" + room.getName() + " Registers");
					System.out.println("\t\t+-------------------------------------------------------------------------+\n");
					for(Register register : roomRegisters) {
						System.out.println("\t\t\tRegister ID: " + register.getId());
						System.out.println("\t\t\tRegister Height: " + register.getHeight());
						System.out.println("\t\t\tRegister Width: " + register.getWidth());
						System.out.println("\t\t\tRegister Area: " + (register.getHeight() * register.getWidth() / 144) + "sqft");
						System.out.println("\t\t\tRegister Type: " + register.getType());
						System.out.println("\t\t\tIs register filtered? " + register.isFiltered());
						
						if(register.isFiltered()) {
							System.out.println("\n\t\t\tRegister " + register.getId() + " - Filter Information");
							Filter registerFilter = register.getFilter();
							System.out.println("\t\t\t\tFilter ID: " + registerFilter.getId());
							System.out.println("\t\t\t\tFilter Manufacturer: " + registerFilter.getManufacturer());
							System.out.println("\t\t\t\tFilter Model: " + registerFilter.getModel());
							System.out.println("\t\t\t\tFilter Serial Number: " + registerFilter.getSerialNumber());
							System.out.println("\t\t\t\tFilter Effective Filter Area: " + registerFilter.getEffectiveFilterArea_sqft() + "sqft");
						}
						
						System.out.println("\n\t\t\t+------------------------------------------------------------------+\n");
						
					}
				}
				
				List<Device> roomDevices = room.getDevices();
				if(roomDevices != null) {
					
					System.out.println("\n\t\t" + room.getName() + " Devices");
					System.out.println("\t\t+-------------------------------------------------------------------------+\n");
					
					for(Device device : roomDevices) {
						System.out.println("\t\t\tDevice ID: " + device.getId());
						System.out.println("\t\t\tDevice Manufacturer: " + device.getManufacturer());
						System.out.println("\t\t\tDevice Model: " + device.getModel());
						System.out.println("\t\t\tDevice Serial Number: " + device.getSerialNumber());
						System.out.println("\t\t\tIs device filtered? " + device.isFiltered());
						
						
						if(device.isFiltered()) {
							System.out.println("\n\t\t\tDevice " + device.getId() + " - Filter Information");
							List<Filter> deviceFilters = device.getFilters();
							for(Filter filter : deviceFilters) {
								System.out.println("\t\t\t\tFilter ID: " + filter.getId());
								System.out.println("\t\t\t\tFilter Manufacturer: " + filter.getManufacturer());
								System.out.println("\t\t\t\tFilter Model: " + filter.getModel());
								System.out.println("\t\t\t\tFilter Serial Number: " + filter.getSerialNumber());
								System.out.println("\t\t\t\tFilter Effective Filter Area: " + filter.getEffectiveFilterArea_sqft() + "sqft");
								System.out.println("\n\t\t\t\t+--------------------------------------------------------+\n");
							}
							
							System.out.println("\n\t\t\t+----------------------------------------------------------------+\n");
						}
						
						System.out.println("\n\t\t\t+----------------------------------------------------------------+\n");
						
					}
				}
				
				System.out.println("\t\t+------------------------------------------------------------------------+\n");
			}
		}
	}

	private static Customer setUp() {
		// Customer and POC creation
		Customer customer = new Customer(1, "Florida Cancer Center");
		PointOfContact poc = new PointOfContact("Alice", "Thompson", "athompson@flcc.com", "123-456-7890", "123-456-7891");

		// Facility creation
		List<Facility> facilities = new ArrayList<>();
		Address address = new Address("123", "Fletcher Avenue", "Tampa", "Florida", "33606");
		Facility facility = new Facility(1, "Temple Terrace - TTR", address, customer, poc);
		facilities.add(facility);

		// Room creation
		List<Room> rooms = new ArrayList<>();
		Room anteRoom = new Room(1, "Ante Room", facility, true, false, false);
		Room bufferRoom = new Room(2, "Buffer Room", facility, true, false, false);
		Room chemoRoom = new Room(3, "Chemo Room", facility, true, true, false);
		Room externalArea = new Room(4, "External Area", facility, false, false, false);
		rooms.add(anteRoom);
		rooms.add(bufferRoom);
		rooms.add(chemoRoom);

		// Portal creation
		List<Room> portalRooms = new ArrayList<>();
		portalRooms.add(anteRoom);
		portalRooms.add(externalArea);
		Portal anteToOutside = new Door(1, portalRooms);

		portalRooms = new ArrayList<>();
		portalRooms.add(anteRoom);
		portalRooms.add(bufferRoom);
		Portal bufferToAnte = new Door(2, portalRooms);

		portalRooms = new ArrayList<>();
		portalRooms.add(anteRoom);
		portalRooms.add(chemoRoom);
		Portal chemoToAnte = new Door(3, portalRooms);

		List<Portal> anteRoomPortals = new ArrayList<>();
		anteRoomPortals.add(anteToOutside);
		anteRoomPortals.add(bufferToAnte);
		anteRoomPortals.add(chemoToAnte);

		List<Portal> bufferRoomPortals = new ArrayList<>();
		bufferRoomPortals.add(bufferToAnte);

		List<Portal> chemoRoomPortals = new ArrayList<>();
		chemoRoomPortals.add(chemoToAnte);

		// Filter creation
		Filter filterA = new Filter(1, "Airflow Tek", "AFT-24-48-H", "AFTSN-123456", 24.0, 48.0, 6.0);
		Filter filterB = new Filter(2, "Airflow Tek", "AFT-24-48-H", "AFTSN-123457", 24.0, 48.0, 6.0);
		Filter filterC = new Filter(3, "Airflow Tek", "AFT-24-48-H", "AFTSN-123458", 24.0, 48.0, 6.0);

		// Register creation
		List<Register> bufferRoomRegisters = new ArrayList<>();
		Register registerA = new Register(1, bufferRoom, filterA, 24.0, 48.0, "supply");
		Register registerD = new Register(4, bufferRoom, null, 24.0, 24.0, "return");
		bufferRoomRegisters.add(registerA);
		bufferRoomRegisters.add(registerD);

		List<Register> anteRoomRegisters = new ArrayList<>();
		Register registerB = new Register(2, anteRoom, filterB, 24.0, 48.0, "supply");
		Register registerE = new Register(4, anteRoom, null, 24.0, 24.0, "return");
		anteRoomRegisters.add(registerB);
		anteRoomRegisters.add(registerE);

		List<Register> chemoRoomRegisters = new ArrayList<>();
		Register registerC = new Register(3, chemoRoom, filterC, 24.0, 48.0, "supply");
		Register registerF = new Register(4, chemoRoom, null, 24.0, 24.0, "return");
		chemoRoomRegisters.add(registerC);
		chemoRoomRegisters.add(registerF);
		
		// Device filter and device creation
		Filter cbSupplyFilter = new Filter(4, "Air Science", "AS-24-72-H", "AS-H-1234", 24.0, 72.0, 6.0);
		List<Filter> cbFilters = new ArrayList<>();
		cbFilters.add(cbSupplyFilter);
		Device bufferRoomCleanBench = new CleanBench(1, "Germfree", "BZ-6SS-RX", "6S-15-12345", bufferRoom, true, false, false, cbFilters);
		
		Filter bscSupplyFilter = new Filter(5, "Air Science", "AS-24-48-H", "AS-H-3344", 24.0, 48.0, 6.0);
		Filter bscExhaustFilter = new Filter(6, "Air Science", "AS-24-24-H", "AS-H-3453", 24.0, 24.0, 6.0);
		List<Filter> bscFilters = new ArrayList<>();
		bscFilters.add(bscSupplyFilter);
		bscFilters.add(bscExhaustFilter);
		Device chemoRoomSafetyCabinet = new CleanBench(1, "Germfree", "BZ-6SS-RX", "6S-15-12345", bufferRoom, true, false, false, bscFilters);
		
		List<Device> bufferRoomDevices = new ArrayList<>();
		bufferRoomDevices.add(bufferRoomCleanBench);
		
		List<Device> chemoRoomDevices = new ArrayList<>();
		chemoRoomDevices.add(chemoRoomSafetyCabinet);
		
		// ----------------------------------------------------------------------------

		customer.setContact(poc);
		customer.setFacilities(facilities);
		
		facility.setContact(poc);
		facility.setRooms(rooms);
		
		anteRoom.setPortals(anteRoomPortals);
		bufferRoom.setPortals(bufferRoomPortals);
		chemoRoom.setPortals(chemoRoomPortals);
		
		anteRoom.setRegisters(anteRoomRegisters);
		bufferRoom.setRegisters(bufferRoomRegisters);
		chemoRoom.setRegisters(chemoRoomRegisters);
		
		bufferRoom.setDevices(bufferRoomDevices);
		chemoRoom.setDevices(chemoRoomDevices);

		return customer;
	}
}
