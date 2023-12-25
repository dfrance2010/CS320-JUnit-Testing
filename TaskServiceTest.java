
//*********************************************************************
// File:        AppointmentServiceTest.java
// Name:        David France
// Date:        7/31/23
// Description: Class for testing TaskService.java. Tests that ID 
//				increments and is unique, and that Tasks can be added,
//				deleted, and updated.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	private TaskService taskService;
	
	// Setup TaskService with five Tasks before each task
	@BeforeEach
	void setupEach() {
		taskService = new TaskService();
		taskService.addTask("task one name", "task one description");
		taskService.addTask("task two name", "task two description");
		taskService.addTask("task three name", "task three description");
		taskService.addTask("task four name", "task four description");
		taskService.addTask("task five name", "task five description");
	}
	
	// Test successful addition of Tasks to TaskService and successful incrementing
	// of ID
	@Test
	void testAddTasks() {
		assertEquals(taskService.getTask(1).getId(), "1");
		assertEquals(taskService.getTask(2).getName(), "task two name");
		assertEquals(taskService.getTask(3).getDescription(), 
				"task three description");
		assertEquals(taskService.getTask(4).getId(), "4");
		assertEquals(taskService.getTask(5).getId(), "5");
	}
	
	// Tests for successfully deleting and updating Tasks
	@Test
	void testDeleteTask() {
		Task task2 = taskService.getTask(2);
		Task deletedTask = taskService.deleteTask(2);
		assertEquals(task2, deletedTask);
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.getTask(2);
		});
	}
	
	@Test
	void testUpdateName() {
		taskService.updateName(4, "task4name");
		assertEquals(taskService.getTask(4).getName(), "task4name");
	}
	
	@Test
	void testUpdateDescription() {
		taskService.updateDescription(5, "updated task five description");
		assertEquals(taskService.getTask(5).getDescription(), 
				"updated task five description");
	}
	
	// Tests for updating or deleting Tasks with ID that doesn't exist
	@Test
	void testUpdateDescBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateDescription(10, "New description");
		});
	}
	
	@Test
	void testUpdateNameBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName(10, "New Name");
		});
	}
	
	@Test 
	void testDeleteTaskBadId() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask(10);
		});
	}

}
