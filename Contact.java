
//*********************************************************************
// File:        Contact.java
// Name:        David France
// Date:        7/31/23
// Description: Contact class for holding task ID, first name, last name, 
//				address, and phone number. To be used with TaskService class.

public class Contact {
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	/**
	 * Constructor - unique id is passed from ContactService. Parameters are 
	 * validated before successful construction
	 * @param id - String
	 * @param firstName - String
	 * @param lastName - String
	 * @param phone - String
	 * @param address - String
	 */
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if (checkString(id, 10)) {
			throw new IllegalArgumentException("Id too long.");
		}
		if (checkString(firstName, 10)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (checkString(lastName, 10)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (checkPhone(phone)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (checkString(address, 30)) {
			throw new IllegalArgumentException("Invalid address");
		}
		contactId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		phoneNumber = phone;
		this.address = address;
	}
	
	// Getters and setters. No setter for Id means it can't be updated.
	public String getId() {
		return this.contactId;
	}
	
	public void setFirstName(String firstName) {
		if (checkString(firstName, 10)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		if (checkString(lastName, 10)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPhoneNumber(String number) {
		if (checkPhone(number)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		phoneNumber = number;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setAddress(String address) {
		if (checkString(address, 30)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	// Check if a string is null or greater than desired length.
	public boolean checkString(String string, int length) {
		if (string == null ||string.length() > length) {return true;}
		return false;
	}
	
	// Checks that phone length isn't null, is exactly 10 characters, and is 
	// only digits.
	public boolean checkPhone(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() != 10) {return true;}
		
		// Method for checking numeric from Baeldung - 
		// url: https://www.baeldung.com/java-check-string-number
		for(int i = 0; i < 10; ++i) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
