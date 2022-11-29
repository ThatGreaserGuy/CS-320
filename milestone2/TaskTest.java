import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TaskTest tests the Task class and its contained methods.
 *
 * @author  Ryan Rieth
 * @version 11/14/2022
 */
public class TaskTest {
    // Instance variables for testing purposes.
    private String id, name, description;

    /**
     * Sets up the testing environment.
     *
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        id = "1";
        name = "Default Task Name";
        description = "This is a description that is not too long.";
    }
    
    /**
     * Tests if the id created with is properly returned.
     */
    @Test
    void getIDTest() {
        Task task = new Task(id, name, description);
        assertEquals(id, task.getID());
    }
    
    /**
     * Tests if the name created with is properly returned.
     */
    @Test
    void getNameTest() {
        Task task = new Task(id, name, description);
        assertEquals(name, task.getName());
    }
    
    /**
     * Tests if the description created with is properly returned.
     */
    @Test
    void getDescriptionTest() {
        Task task = new Task(id, name, description);
        assertEquals(description, task.getDescription());
    }
    
    /**
     * Tests if the id can be properly set.
     */
    @Test
    void setIDTest() {
        Task task = new Task();
        task.setID(id);
        assertEquals(id, task.getID());
    }
    
    /**
     * Tests if the name can be properly set.
     */
    @Test
    void setNameTest() {
        Task task = new Task();
        task.setName(name);
        assertEquals(name, task.getName());
    }
    
    /**
     * Tests if the description can be properly set.
     */
    @Test
    void setDescriptionTest() {
        Task task = new Task();
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }
    
    /**
     * Tests if a null ID is not recorded.
     */
    @Test
    void setIDNullTest() {
        assertThrows(IllegalArgumentException.class,
                        () -> new Task(null, name, description));
    }
    
    /**
     * Tests if a null name is not recorded.
     */
    @Test
    void setNameNullTest() {
        assertThrows(IllegalArgumentException.class, 
                        () -> new Task(id, null, description));
    }
    
    /**
     * Tests if a null description is not recorded.
     */
    @Test
    void setDescriptionNullTest() {
        assertThrows(IllegalArgumentException.class, 
                        () -> new Task(id, name, null));
    }
    
    /**
     * Tests if a name that is too many characters is not recorded.
     */
    @Test
    void setNameTooLongTest() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, 
                        () -> task.setName("Default Task Name that is Too Long"));
    }
    
    /**
     * Tests if a description that is too 
     * many characters is not recorded.
     */
    @Test
    void setDescriptionTooLongTest() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, 
                        () -> task.setDescription("This is a default description that is \"not\" too long."));
    }
}
