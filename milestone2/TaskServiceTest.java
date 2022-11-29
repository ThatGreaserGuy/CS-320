import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TaskServiceTest tests the TaskService class and its contained methods.
 *
 * @author  Ryan Rieth
 * @version 11/14/2022
 */
public class TaskServiceTest {
    private String id, name, description;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        id = "1";
        name = "Default Task Name";
        description = "This is a description that is not too long.";
    }
    
    @Test
    void createTaskTest() {
        TaskService service = new TaskService();
        service.createTask();
        
        assertAll("create default task",
                    ()
                        -> assertNotNull(service.getTasks().get(0).getID()),
                    ()
                        -> assertEquals("1", service.getTasks().get(0).getID()),
                    ()
                        -> assertNotNull(service.getTasks().get(0).getName()),
                    ()
                        -> assertEquals("Default Task Name", 
                                        service.getTasks().get(0).getName()),
                    ()
                        -> assertNotNull(service.getTasks().get(0).getDescription()),
                    ()
                        -> assertEquals("This is a description that is not too long.", 
                                        service.getTasks().get(0).getDescription()));
    }
    
    @Test
    void createSpecificTaskTest() {
        TaskService service = new TaskService();
        service.createTask(name, description);
        
        assertAll("create specific task",
                    ()
                        -> assertNotNull(service.getTasks().get(0).getID()),
                    ()
                        -> assertEquals("1", service.getTasks().get(0).getID()),
                    ()
                        -> assertNotNull(service.getTasks().get(0).getName()),
                    ()
                        -> assertEquals("Default Task Name", 
                                        service.getTasks().get(0).getName()),
                    ()
                        -> assertNotNull(service.getTasks().get(0).getDescription()),
                    ()
                        -> assertEquals("This is a description that is not too long.", 
                                        service.getTasks().get(0).getDescription()));
    }
    
    @Test
    void createTaskNameNull() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class,
                        () -> service.createTask(null, description));
    }
    
    @Test
    void createTaskDescriptionNull() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class,
                        () -> service.createTask(name, null));
    }
    
    @Test
    void createTaskNameTooLongTest() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class,
                        () -> service.createTask("Default Task Name that is Too Long", description));
    }
    
    @Test
    void createTaskDescriptionTooLongTest() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class,
                        () -> service.createTask(name, "This is a default description that is \"not\" too long."));
    }
    
    @Test
    void updateNameTest() throws Exception {
        TaskService service = new TaskService();
        service.createTask();
        
        service.updateName(service.getTasks().get(0).getID(), name);
        assertEquals(name, service.getTasks().get(0).getName());
    }
    
    @Test
    void updateNameNotThereTest() throws Exception {
        TaskService service = new TaskService();
        service.createTask();
        
        assertThrows(Exception.class, () -> service.updateName("1977", name));
    }
    
    @Test
    void updateDescriptionTest() throws Exception {
        TaskService service = new TaskService();
        service.createTask();
        
        service.updateDescription(service.getTasks().get(0).getID(), description);
        
        assertEquals(description, service.getTasks().get(0).getDescription());
    }
    
    @Test
    void updateDescriptionNotThereTest() throws Exception {
        TaskService service = new TaskService();
        service.createTask();
        
        assertThrows(Exception.class, () -> service.updateDescription("1977", description));
    }
    
    @Test
    void deleteTaskTest() throws Exception {
        TaskService service = new TaskService();
        
        service.createTask();
        assertEquals(1, service.getTasks().size());
        
        service.deleteTask(service.getTasks().get(0).getID());
        assertEquals(0, service.getTasks().size());
    }
    
    @Test
    void deleteTaskNotThereTest() {
        TaskService service = new TaskService();
        
        service.createTask();
        
        assertAll("delete nonexistent task",
                    ()
                        -> assertEquals(1, service.getTasks().size()),
                    ()
                        -> assertThrows(Exception.class, () -> service.deleteTask("1977")),
                    ()
                        -> assertEquals(1, service.getTasks().size()));
    }
}
