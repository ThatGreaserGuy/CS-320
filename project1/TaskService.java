package milestone2;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskService keeps track of created tasks.
 *
 * @author Ryan Rieth
 * @version 11/14/2022
 */
public class TaskService {
    // Instance variables.
    private String uniqueID;
    private final List<Task> tasks = new ArrayList<>();
    
    protected void createTask() {
        Task task = new Task();
        tasks.add(task);
    }
    
    protected void createTask(String name, String description) {
        Task task = new Task(newID(), name, description);
        tasks.add(task);
    }
    
    protected void updateName(String id, String name) throws Exception {
        searchForTask(id).setName(name);
    }
    
    protected void updateDescription(String id, String description) throws Exception {
        searchForTask(id).setDescription(description);
    }
    
    protected void deleteTask(String id) throws Exception {
        tasks.remove(searchForTask(id));
    }
    
    protected List<Task> getTasks() { return tasks; }
    
    private String newID() {
        int size = tasks.size();
        size += 1;
        
        uniqueID = Integer.toString(size);
        return uniqueID;
    }

    private Task searchForTask(String id) throws Exception {
        for (int index = 0; index < tasks.size(); index++) {
            if (id.equals(tasks.get(index).getID())) {
                return tasks.get(index);
            }
        }
        
        throw new Exception("The specified task does not exist.");
    }
}