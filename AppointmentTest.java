
//*********************************************************************
// File:        AppointmentTest.java
// Name:        David France
// Date:        7/31/23
// Description: Class to test Appointment.java. Tests ID, date, and description
// 				are the correct length/time frame and are not null.

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	private Appointment appointment;
	private LocalDate date;
	
	// Tests use same date that is in the future, except when testing date
	// validation. Date can be updated to test boundary conditions.
	@BeforeEach
	void setupEach() {
		date = LocalDate.of(2023, 9, 1);
	}
	
	// Test that appointments with boundary values are created successfully.
	@Test
	void appointmentTest() {
		appointment = new Appointment("6549871230", date, "this is a fifty "
				+ "character description for the test");
		assertEquals(appointment.getId(), "6549871230");
		assertEquals(appointment.getDate(), date);
		assertEquals(appointment.getDescription(), "this is a fifty "
				+ "character description for the test");
	}
	
	// Tests for success conditions on update
	@Test
	void updateDateTest() {
		appointment = new Appointment("6549871230", date, "this is a fifty "
				+ "character description for the test");
		LocalDate date2 = LocalDate.of(2023, 10, 30);
		appointment.setDate(date2);
		assertEquals(appointment.getDate(), date2);
	}
	
	@Test 
	void updateDescTest() {
		appointment = new Appointment("6549871230", date, "this is a fifty "
				+ "character description for the test");
		appointment.setDescription("this is a description less than 50 ch");
		assertEquals(appointment.getDescription(), 
				"this is a description less than 50 ch");
	}
	
	// Tests for failing conditions
	@Test 
	void idTooLongTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment("65498712301", date, "this is a fifty "
			+ "character description for the test");
		});
		
	}
	
	@Test
	void idNullTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment(null, date, "this is a fifty "
			+ "character description for the test");
		});
	}
	
	@Test
	void dateTooEarlyTest() {
		date = LocalDate.of(2019, 4, 25);
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment("6549871230", date, "this is a fifty "
			+ "character description for the test");
		});
	}
	
	@Test
	void dateNullTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment("6549871230", null, "this is a fifty "
			+ "character description for the test");
		});
	}
	
	@Test
	void descTooLongTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment("6549871230", date, "this is a fifty1 "
			+ "character description for the test");
		});
	}
	
	@Test
	void descNullTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment = new Appointment("6549871230", date, null);
		});
	}
	
	// Tests for failing update conditions
	@Test 
	void updateDateTooEarlyTest() {
		appointment = new Appointment("6549871230", date, "this is a fifty "
				+ "character description for the test");
		LocalDate date2 = LocalDate.of(2013, 10, 30);
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(date2);
		});
	}
	
	@Test
	void updateDescTooLongTest() {
		appointment = new Appointment("6549871230", date, "this is a fifty "
				+ "character description for the test");
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription("this is a fifty1 "
					+ "character description for the test");
		});
	}
	
	@Test
	void updateDescNullTest() {
		appointment = new Appointment("6549871230", date, "this is a fifty "
				+ "character description for the test");
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription(null);
		});
	}
	

}
