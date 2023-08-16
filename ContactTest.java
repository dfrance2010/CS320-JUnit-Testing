
//*********************************************************************
// File:        ContactTest.java
// Name:        David France
// Date:        7/31/23
// Description: Class to test Contact.java. Tests ID, first name, last name, 
//				address, and phone number are the correct length and are not 
//				null when Task is created or updated.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	private Contact contact;
	private Contact contact2;
	
	// Setup two Contacts to be tested for each test
	@BeforeEach
	void setupEach() {
		contact = new Contact("1", "firstname", "lastname", "1234567890", "123 fake st");
		contact2 = new Contact("2", "Bob", "Jones", "9897654321", "345 sunset drive");
	}
	
	// Test successful creation of Contacts
	@Test
	void testContact() {
		assertTrue(contact.getId().equals("1"));
		assertTrue(contact.getFirstName().equals("firstname"));
		assertTrue(contact.getLastName().equals("lastname"));
		assertTrue(contact.getPhoneNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 fake st"));

		assertTrue(contact2.getPhoneNumber().equals("9897654321"));
	}
	
	// Test successful update conditions
	@Test
	void testUpdateFirstName() {
		contact.setFirstName("Bill");
		assertEquals(contact.getFirstName(), "Bill");
	}
	
	@Test 
	void testUpdateLastName() {
		contact.setLastName("Kilgore");
		assertEquals(contact.getLastName(), "Kilgore");
	}
	
	@Test
	void testUpdatePhone() {
		contact.setPhoneNumber("9687541234");
		assertEquals(contact.getPhoneNumber(), "9687541234");
	}
	
	@Test 
	void testUpdateAddress() {
		contact.setAddress("234 Clemens Point Dr");
		assertEquals(contact.getAddress(), "234 Clemens Point Dr");
	}
	
	// Test failing construction conditions
	@Test
	void testIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "firstname", "lastname", "1234567890", "123 fake st");
		});
	}
	
	@Test
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "firstname", "lastname", "1234567890", "123 fake st");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstnametoolong", "lastname", "1234567890", "123 fake st");
		});
	}
	
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "lastname", "1234567890", "123 fake st");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstname", "lastnametoolong", "1234567890", "123 fake st");
		});
	}
	
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstname", null, "1234567890", "123 fake st");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstnametoolong", "lastname", "12345678901", "123 fake st");
		});
	}
	
	@Test
	void testPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstnametoolong", "lastname", "123456789", "123 fake st");
		});
	}
	
	@Test
	void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstname", "lastname", "1234567890", null);
		});
	}
	
	@Test
	void testPhoneOnlyDigits() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstname", "lastname", "1234ew7890", "123 fake st");
		});
	}

	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstnametoolong", "lastname", "1234567890", 
					"123 fake st anytown, usa 09123 now it's too long");
		});
	}
	
	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstname", "lastname", "1234567890", null);
		});
	}
	
	// Test failing update conditions 
	@Test
	void testUpdateFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("firstnametoolong");
		});
	}
	
	@Test
	void testUpdateFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testUpdateLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("lastnametoolong");
		});
	}
	
	@Test
	void testUpdateLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
	}
	
	@Test
	void testUpdateAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("123 fake st, anytown, usa this is now too long");
		});
	}
	
	@Test
	void testUpdateAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
	
	@Test
	void testUpdatePhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("12345678901");
		});
	}
	
	@Test
	void testUpdatePhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("12345689");
		});
	}
	
	@Test
	void testUpdatePhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	void testUpdatePhoneOnlyDigits() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("12345er90");
		});
	}
	
	

}
