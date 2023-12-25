
//*********************************************************************
// File:        Appointment.java
// Name:        David France
// Date:        7/31/23
// Description: Appointment class for holding appointment ID, date, and 
//              description. To be used with AppointmentService class.

import java.time.LocalDate;

public class Appointment {
	private String id;
	private LocalDate date;
	private String description;
	
	/**
	 * Constructor validates input before creating Appointment
	 * @param id - String
	 * @param date - LocalDate
	 * @param description - String
	 */
	public Appointment(String id, LocalDate date, String description) {
		if (checkString(id, 10)) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		if (checkString(description, 50)) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		// LocalDate.now() returns today's date.
		if (date == null || date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Invalid date");
		}
		
		this.id = id;
		this.date = date;
		this.description = description;
	}
	
	// No setId() method because ID cannot be updated.
	public String getId() {
		return this.id;
	}
	
	public void setDate(LocalDate date) {
		if (date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Invalid date");
		}
		
		this.date = date;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDescription(String description) {
		if (checkString(description, 50)) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	// Check if a string is null or greater than desired length.
	private boolean checkString(String string, int length) {
		if (string == null ||string.length() > length) {return true;}
		return false;
	}

}
