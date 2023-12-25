
//*********************************************************************
// File:        Task.java
// Name:        David France
// Date:        7/31/23
// Description: Task class for holding task ID, name, and 
//              description. To be used with TaskService class.

public class Task {
	private String id;
	private String name;
	private String description;
	
	/**
	 * Constructor - unique id is passed from TaskService. Parameters are 
	 * validated before successful construction
	 * @param id - String
	 * @param name - String
	 * @param description - String
	 */
	public Task(String id, String name, String description) {
		if (checkString(id, 10)) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		if (checkString(name, 20)) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		if (checkString(description, 50)) {
			throw new IllegalArgumentException("Invalid description") ;
		}
		
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	// Getters and setters. No setter for Id, so it can't be updated
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		if (checkString(name, 20)) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		if (checkString(description, 50)) {
			throw new IllegalArgumentException("Invalid Description");
			}
		
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	// Check if a string is null or greater than desired length.
	public boolean checkString(String string, int length) {
		if (string == null ||string.length() > length) {return true;}
		return false;
	}

}
