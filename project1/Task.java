package milestone2;

/**
 * Task is purposed to create a task with a name and a description.
 *
 * @author Ryan Rieth
 * @version 11/14/2022
 */
public class Task {
    // Instance variables.
    private String id, name, description;

    /**
     * Instantiates Task variables with default values.
     */
    Task() {
        setID("1");
        setName("Default Task Name");
        setDescription("This is a description that is not too long.");
    }
    
    /**
     * Instantiates Task variables with given values.
     */
    Task(String id, String name, String description) {
        setID(id);
        setName(name);
        setDescription(description);
    }
    
    /**
     * Returns the task's unique ID.
     * 
     * @return id
     */
    public final String getID() { return id; }
    
    /**
     * Returns the task's name.
     * 
     * @return name
     */
    public final String getName() { return name; }
    
    /**
     * Returns the task's description.
     * 
     * @return description
     */
    public final String getDescription() { return description; }
    
    /**
     * Sets the task's ID.
     * 
     * @param id - given unique identifier
     */
    protected void setID(String id) {
        if (id == null || id.length() > 20) {
            throw new IllegalArgumentException("ID is invalid.");
        }
        else {
            this.id = id;
        }
    }
    
    /**
     * Sets the task's name.
     * 
     * @param name - given task name
     */
    protected void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name is invalid.");
        }
        else {
            this.name = name;
        }
    }
    
    /**
     * Sets the task's description.
     * 
     * @param description - given task description
     */
    protected void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is invalid.");
        }
        else {
            this.description = description;
        }
    }
}