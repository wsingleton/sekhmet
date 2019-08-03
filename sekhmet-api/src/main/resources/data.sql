-- POC Creation
INSERT INTO point_of_contact (email_address, fax_number, first_name, last_name, phone_number)
VALUES ('athompson@flcc.com', '123-456-7891', 'Alice', 'Thompson', '123-456-7890');

-- Customer Creation
INSERT INTO customer (name, contact_id)
VALUES ('Florida Cancer Center', 1);

-- Facility Creation
INSERT INTO facility (name, unit, street, city, state, zipcode, owner_id, contact_id)
VALUES ('Temple Terrace - TTR', '123', 'Fletcher Avenue', 'Tampa', 'Florida', '33606', 1, 1);

-- Customer-Facility association
INSERT INTO customer_facilities (customer_id, facilities_id)
VALUES (1, 1);

-- Room Creation
INSERT INTO room (name, sterile, hazardous, radioactive, facility_id)
VALUES ('Ante Room', true, false, false, 1);

INSERT INTO room (name, sterile, hazardous, radioactive, facility_id)
VALUES ('Buffer Room', true, false, false, 1);

INSERT INTO room (name, sterile, hazardous, radioactive, facility_id)
VALUES ('Chemo Room', true, true, false, 1);

-- Facility-Room association
INSERT INTO facility_rooms (facility_id, rooms_id)
VALUES (1, 1);

INSERT INTO facility_rooms (facility_id, rooms_id)
VALUES (1, 2);

INSERT INTO facility_rooms (facility_id, rooms_id)
VALUES (1, 3);

-- Portal creation 
INSERT INTO portal (portal_type)
VALUES ('door');

INSERT INTO portal (portal_type)
VALUES ('door');

INSERT INTO portal (portal_type)
VALUES ('door');

-- Room-Door association
INSERT INTO ROOM_DOORS (room_id, door_id)
VALUES (1, 1);

INSERT INTO ROOM_DOORS (room_id, door_id)
VALUES (1, 2);

INSERT INTO ROOM_DOORS (room_id, door_id)
VALUES (1, 3);

INSERT INTO ROOM_DOORS (room_id, door_id)
VALUES (2, 2);

INSERT INTO ROOM_DOORS (room_id, door_id)
VALUES (3, 3);

-- Filter creation
INSERT INTO filter (frame_depth, frame_height, frame_width, manufacturer, model, serial_number)
VALUES (6.0, 24, 48, 'Airflow Tek', 'AS-24-48-H', 'AFTSN-123456');

INSERT INTO filter (frame_depth, frame_height, frame_width, manufacturer, model, serial_number)
VALUES (6.0, 24, 48, 'Airflow Tek', 'AS-24-48-H', 'AFTSN-123457');

INSERT INTO filter (frame_depth, frame_height, frame_width, manufacturer, model, serial_number)
VALUES (6.0, 24, 48, 'AirFlow Tek', 'AFT-24-48-H', 'AFTSN-123458');

INSERT INTO filter (frame_depth, frame_height, frame_width, manufacturer, model, serial_number)
VALUES (6.0, 24, 72, 'Air Science', 'AS-24-72-H', 'AS-H-1234');

INSERT INTO filter (frame_depth, frame_height, frame_width, manufacturer, model, serial_number)
VALUES (6.0, 24, 48, 'Air Science', 'AS-24-48-H', 'AS-H-3344');

INSERT INTO filter (frame_depth, frame_height, frame_width, manufacturer, model, serial_number)
VALUES (6.0, 24, 24, 'Air Science', 'AS-24-24-H', 'AS-H-3453');

-- Register creation
INSERT INTO register (height, width, type, filter_id, room_id)
VALUES (24.0, 48.0, 'supply', 1, 2);

INSERT INTO register (height, width, type, room_id)
VALUES (24.0, 24.0, 'return', 2);

INSERT INTO register (height, width, type, filter_id, room_id)
VALUES (24.0, 48.0, 'supply', 2, 1);

INSERT INTO register (height, width, type, room_id)
VALUES (24.0, 24.0, 'return', 1);

INSERT INTO register (height, width, type, filter_id, room_id)
VALUES (24.0, 48.0, 'supply', 3, 3);

INSERT INTO register (height, width, type, room_id)
VALUES (24.0, 24.0, 'return', 3);

-- Room-Register association
INSERT INTO room_registers (room_id, registers_id)
VALUES (1, 3);

INSERT INTO room_registers (room_id, registers_id)
VALUES (1, 4);

INSERT INTO room_registers (room_id, registers_id)
VALUES (2, 1);

INSERT INTO room_registers (room_id, registers_id)
VALUES (2, 2);

INSERT INTO room_registers (room_id, registers_id)
VALUES (3, 5);

INSERT INTO room_registers (room_id, registers_id)
VALUES (3, 6);

-- Device creation
INSERT INTO device (device_type, manufacturer, model, serial_number, sterile, hazardous, radioactive, room_id)
VALUES ('CB', 'Germfree', 'BZ-6SS-RX', '6S-15-BH-12345', true, false, false, 2);

INSERT INTO device (device_type, manufacturer, model, serial_number, sterile, hazardous, radioactive, room_id)
VALUES ('BSC', 'Germfree', 'BR-4SS-RX', '4S-15-BR-42342', true, true, false, 3);

-- Device-Filter association
INSERT INTO device_filters (device_id, filters_id)
VALUES (1, 4);

INSERT INTO device_filters (device_id, filters_id)
VALUES (2, 5);

INSERT INTO device_filters (device_id, filters_id)
VALUES (2, 6);

-- Room-Device association
INSERT INTO room_devices (room_id, devices_id)
VALUES (2, 1);

INSERT INTO room_devices (room_id, devices_id)
VALUES (3, 2);