
//*********************************************************************
// File:        TaskTest.java
// Name:        David France
// Date:        7/31/23
// Description: Class to test Task.java. Tests ID, name, and description
// 				are the correct length and are not null when Task is created
//				or updated.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	private Task task;
	
	// Set up Task for each test
	@BeforeEach
	void setupEach() {
		task = new Task("1234567890", "taskName", "this is the task description");
	}
	
	// Test successful Task construction
	@Test
	void testTask() {
		assertEquals(task.getId(), "1234567890");
		assertEquals(task.getName(), "taskName");
		assertEquals(task.getDescription(), "this is the task description");
	}
	
	// Test successful update conditions
	@Test
	void testUpdateName() {
		task.setName("new task name");
		assertEquals(task.getName(), "new task name");
	}
	
	@Test
	void testUpdateDescription() {
		task.setDescription("this is the new task description");
		assertEquals(task.getDescription(), "this is the new task description");
	}
	
	// Test failing construction conditions
	@Test
	void testIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "taskName", "this is the task description");
		});
	}
	
	@Test
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "taskName", "this is the task description");
		});
	}
	
	@Test
	void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "this name is too long", 
					"this is the task description");
		});
	}
	
	@Test 
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", null, "this is the task description");
		});
	}
	
	// Test failing update conditions
	@Test 
	void testUpdateNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("this name is too long");
		});
	}
	
	@Test
	void testUpdateNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "taskName", 
					"this description will be tooo long by one character");
		});
	}
	
	@Test 
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "taskName", null);
		});
	}
	
	@Test
	void testUpdateDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription("this description will be tooo long by one character");
		});
	}
	
	@Test
	void testUpdateDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}

}
