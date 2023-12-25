
//*********************************************************************
// File:        AppointmentServiceTest.java
// Name:        David France
// Date:        7/31/23
// Description: Class for testing AppointmentService.java. Tests that ID 
//				increments and is unique, and that Appointments can be added
//				and deleted.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	private AppointmentService apptSvc;
	LocalDate date1;
	LocalDate date2;
	
	// Setup each test case with two Appointments added to AppointmentService
	@BeforeEach
	void setupEach() {
		date1 = LocalDate.of(2023, 10, 30);
		date2 = LocalDate.of(2024, 4, 15);
		apptSvc = new AppointmentService();
		apptSvc.addAppt(date1, "Description of appointment one");
		apptSvc.addAppt(date2, "Description of appointment two");
		
	}
	
	// Test unique and incrementing ID values and that Appointments are added
	// successfully
	@Test
	void testApptService() {
		assertEquals(apptSvc.getAppt(1).getId(), "1");
		assertEquals(apptSvc.getAppt(2).getId(), "2");
		assertEquals(apptSvc.getAppt(1).getDescription(), 
				"Description of appointment one");
		assertEquals(apptSvc.getAppt(2).getDate(), date2);
	}
	
	// Test successful deletion of Appointment
	@Test
	void testDeleteAppt() {
		Appointment appt1 = apptSvc.getAppt(1);
		Appointment deletedAppt = apptSvc.deleteAppt(1);
		assertEquals(appt1, deletedAppt);
		assertThrows(IllegalArgumentException.class, () -> {
			apptSvc.getAppt(1);
		});
	}
	
	// Test failure case of deleting non-existent element
	@Test
	void testDeleteBadAppt() {
		assertThrows(IllegalArgumentException.class, () -> {
			apptSvc.deleteAppt(10);
		});
	}

}
