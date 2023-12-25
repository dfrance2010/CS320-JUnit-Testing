
//*********************************************************************
// File:        AppointmentService.java
// Name:        David France
// Date:        7/31/23
// Description: Class to hold table of Appointments and IDs. Appointments can be
//				added and deleted.

import java.time.LocalDate;
import java.util.HashMap;

public class AppointmentService {
	private HashMap<Integer, Appointment> apptMap;
	private int apptId;
	
	
	// Constructor takes no parameters, creates HashMap and starts ID at 1
	public AppointmentService() {
		apptMap = new HashMap<>();
		apptId = 1;
	}
	
	// Add Appointment to apptMap and increment apptId
	public void addAppt(LocalDate date, String description) {
		String apptIdString = String.valueOf(apptId);
		Appointment appointment = new Appointment(apptIdString, date, description);
		apptMap.put(apptId, appointment);
		apptId++;
	}
	
	// Delete Appointment by id if it exists
	public Appointment deleteAppt(int id) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return apptMap.remove(id);
	}
	
	// Return Appointment by id if it exists
	public Appointment getAppt(int id) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return apptMap.get(id);
	}
	
	// Ensure appttMap is not null and that it contains the id to be deleted.
	private boolean isNull(int id) {
		// Method modified from:
		// https://www.freecodecamp.org/news/how-to-handle-nullpointerexception-in-java/
		if (apptMap == null || !apptMap.containsKey(id)) {
			return true;
		}
		return false;
	}

}
