
//*********************************************************************
// File:        ContactService.java
// Name:        David France
// Date:        7/31/23
// Description: Class to hold Contacts and IDs. Contacts can be added, deleted, 
//				and updated.

import java.util.HashMap;

public class ContactService {
	private HashMap<Integer, Contact> contactMap;
	int contactId;
	
	
	/**
	 * Constructor
	 * contactMap - HashMap to hold all contacts by contact Id
	 * contactId - initialized to 1, then incremented each time a Contact is added
	 */
	public ContactService() {
		contactMap = new HashMap<>();
		contactId = 1;
	}
	
	/** 
	 * Create new Contact and add to contact list
	 * @param firstName - String
	 * @param lastName - String
	 * @param phone - String
	 * @param address - String
	 */
	public void addContact(String firstName, String lastName, String phone, String address) {
		String newId = String.valueOf(contactId);
		Contact newContact = new Contact(newId, firstName, lastName, phone, address);
		contactMap.put(contactId, newContact);
		contactId++;
	}
	
	/**
	 * Get contact by ID if present
	 * @param id - int
	 * @return Contact
	 */
	public Contact getContact(int id) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return contactMap.get(id);
	}
	
	/**
	 * Delete contact by ID if present
	 * @param id - int
	 * @return Contact that was deleted
	 */
	public Contact deleteContact(int id) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return contactMap.remove(id);
	}
	
	/**
	 * Update first name of Contact if ID present
	 * @param id - int
	 * @param newFirstName - String
	 */
	public void updateFirstName(int id, String newFirstName) {
		if (isNull(id)) {throw new IllegalArgumentException("Invalid ID");}
		
		Contact updateContact = contactMap.get(id);
		updateContact.setFirstName(newFirstName);
		contactMap.replace(id, updateContact);
	}
	
	/**
	 * Update last name of Contact if id present
	 * @param id - int
	 * @param newLastName -String
	 */
	public void updateLastName(int id, String newLastName) {
		if (isNull(id)) {throw new IllegalArgumentException("Invalid ID");}
		
		Contact updateContact = contactMap.get(id);
		updateContact.setLastName(newLastName);
		contactMap.replace(id, updateContact);
	}
	
	/**
	 * Update address of Contact if id present
	 * @param id - int
	 * @param newAddress - String
	 */
	public void updateAddress(int id, String newAddress) {
		if (isNull(id)) {throw new IllegalArgumentException("Invalid ID");}
		
		Contact updateContact = contactMap.get(id);
		updateContact.setAddress(newAddress);
		contactMap.replace(id, updateContact);
		
	}
	
	/**
	 * Update phone number of Contact if id present
	 * @param id - int
	 * @param newPhone - String
	 */
	public void updatePhone(int id, String newPhone) {
		if (isNull(id)) {throw new IllegalArgumentException("Invalid ID");}
		
		Contact updateContact = contactMap.get(id);
		updateContact.setPhoneNumber(newPhone);
		contactMap.replace(id, updateContact);
	}
	
	// Ensure contactMap is not null and that it contains the id to be deleted.
	private boolean isNull(int id) {
		// Method modified from:
		// https://www.freecodecamp.org/news/how-to-handle-nullpointerexception-in-java/
		if (contactMap == null || !contactMap.containsKey(id)) {
			return true;
		}
		return false;
	}

}
