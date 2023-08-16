
//*********************************************************************
// File:        ContactServiceTest.java
// Name:        David France
// Date:        7/31/23
// Description: Class for testing ContactService.java. Tests that ID 
//				increments and is unique, and that Contacts can be added,
//				deleted, and updated.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private ContactService contactService;
	
	// Set up ContactService with five Contacts before each test
	@BeforeEach
	void setupEach() {
		contactService = new ContactService();
		contactService.addContact("firstname", "lastname", "1234567890", "address");
		contactService.addContact("John", "Smith", "3234567980", "12 forever lane");
		contactService.addContact("Jane", "Doe", "5456789123", "46 falling water ct");
		contactService.addContact("Bob", "Jones", "9897654321", "345 sunset drive");
		contactService.addContact("Neil", "Poundstone", "4345646784", "456 mountainview terr");
	}

	// Tests all Contacts are added. Duplicate values are not allowed in a HashMap, and
	// this test shows all five Contacts have been added successfully, so no duplicate
	// values exist.
	@Test
	void testAddContacts() {
		assertTrue(contactService.getContact(1).getFirstName().equals("firstname"));
		assertTrue(contactService.getContact(2).getPhoneNumber().equals("3234567980"));
		assertTrue(contactService.getContact(3).getLastName().equals("Doe"));
		assertTrue(contactService.getContact(4).getAddress().equals("345 sunset drive"));
		assertTrue(contactService.getContact(5).getFirstName().equals("Neil"));
	}
	
	// Tests for successfully deleting and updating contacts
	@Test 
	void testDeleteContact() {
		Contact contact3 = contactService.getContact(3);
		Contact deletedContact3 = contactService.deleteContact(3);
		assertEquals(contact3, deletedContact3);
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContact(3);
		});
	}
	
	@Test
	void testUpdateFirstName() {
		contactService.updateFirstName(2, "Josephine");
		assertEquals(contactService.getContact(2).getFirstName(), "Josephine");
	}
	
	@Test
	void testUpdateLastName() {
		contactService.updateLastName(3, "Floyd");
		assertEquals(contactService.getContact(3).getLastName(), "Floyd");
		
	}
	
	@Test
	void testUpdateAddress() {
		contactService.updateAddress(5, "1899 horseshoe overlook");
		assertEquals(contactService.getContact(5).getAddress(), "1899 horseshoe overlook");
	}
	
	@Test
	void testUpdatePhone() {
		contactService.updatePhone(1, "9894563214");
		assertEquals(contactService.getContact(1).getPhoneNumber(), "9894563214");
		
	}
	
	// Tests for ID that doesn't exist 
	@Test
	void testUpdateFirstNameBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName(10, "Arthur");
		});
	}
	
	@Test
	void testUpdateLastNameBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName(10, "Morgan");
		});
	}
	
	@Test 
	void testUpdateAddressBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress(10, "New Address");
		});
	}
	
	@Test
	void testUpdatePhoneBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhone(10, "1234567890");
		});
	}
	
	
	@Test
	void testDeleteBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(10);
		});
	}
	
	// Test for null HashMap
	@Test
	void testNullContactMap() {
		ContactService contactService2 = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> {
			contactService2.updateFirstName(1, "John");
		});
	}

}
