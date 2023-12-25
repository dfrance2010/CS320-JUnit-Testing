
//*********************************************************************
// File:        Task.java
// Name:        David France
// Date:        7/31/23
// Description: Class for holding Tasks and IDs. Tasks can be added, deleted, 
//     			and updated.

import java.util.HashMap;

public class TaskService {
	private HashMap<Integer, Task> taskMap;
	private int taskId;
	
	/**
	 * Constructor creates new HashMap and sets taskID to 1
	 */
	public TaskService() {
		taskMap = new HashMap<>();
		taskId = 1;
	}
	
	/**
	 * Creates Task and adds to map, then increments ID
	 * @param name - String
	 * @param description - String
	 */
	public void addTask(String name, String description) {
		String id = String.valueOf(taskId);
		Task task = new Task(id, name, description);
		taskMap.put(taskId, task);
		taskId++;
	}
	
	/**
	 * Get Task by id if id exists
	 * @param id - int
	 * @return Task
	 */
	public Task getTask(int id) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return taskMap.get(id);
	}
	
	/**
	 * Delete Task by id if id exists
	 * @param id - int
	 * @return Task
	 */
	public Task deleteTask(int id) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return taskMap.remove(id);
	}
	
	/**
	 * Update name by id if id exists
	 * @param id - int
	 * @param name - String
	 */
	public void updateName(int id, String name) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		Task updatedTask = taskMap.get(id);
		updatedTask.setName(name);
		taskMap.replace(id, updatedTask);
	}
	
	/**
	 * Update description by id if id exists
	 * @param id - int
	 * @param description - String
	 */
	public void updateDescription(int id, String description) {
		if (isNull(id)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		Task updatedTask = taskMap.get(id);
		updatedTask.setDescription(description);
		taskMap.replace(id, updatedTask);
	}
	
	// Ensure taskMap is not null and that it contains the id to be deleted.
	private boolean isNull(int id) {
		// Method modified from:
		// https://www.freecodecamp.org/news/how-to-handle-nullpointerexception-in-java/
		if (taskMap == null || !taskMap.containsKey(id)) {
			return true;
		}
		return false;
	}
	
}
