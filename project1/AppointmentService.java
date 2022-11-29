package milestone3;

/*
 * Milestone guidelines call for utilization of java.util.Date.  This API, however, has proven to be 
 * error-prone and poorly performing.  Instead, the more modern and technically sound Date-Time API 
 * from Java 8 is implemented in the Date API's place.
 */

import java.util.ArrayList;
import java.util.List;
import java.time.*;

/**
 * Create and store appointments that have unique identifiers, dates, and descriptions.
 *
 * @author Ryan Rieth
 * @version 11/27/2022
 */
public class AppointmentService {
    // Instance variable.
    final private List<Appointment> appointments = new ArrayList<>();   // Appointment list.
    
    /**
     * Method to create a unique ID for an appointment.
     * Purposed to occur once at creation.
     * 
     * @return String object - unique identifier for appointment
     */
    private String createID() {
        int size = appointments.size();
        size += 1;
        
        return Integer.toString(size);
    }
    
    /**
     * Method to find an appointment via its unique ID.
     * 
     * @return Appointment object - the existing appointment
     * @return Exception - catchable error if appointment doesn't exist
     */
    private Appointment findAppointment(String id) throws Exception {
        for (int index = 0; index < appointments.size(); index++) {
            if (id.equals(appointments.get(index).getID())) {
                return appointments.get(index);
            }
        }
        
        throw new Exception("Error: appointment does not exist.");
    }
     
    /**
     * Method to return the list of appointment.
     * 
     * @return List of Appointment objects - list of appointments
     */
    protected List<Appointment> getAppointments() { return appointments; }
     
    /**
     * Method to delete an appointment via its unique ID.
     * Throws exception if appointment does not exist.
     * 
     * @param id - unique identifier for appointment
     */
    public void deleteAppointment(String id) throws Exception {
        appointments.remove(findAppointment(id));
    }
    
    /**
     * Method to create a new default appointment.
     */
    public void newAppointment() {
        Appointment appointment = new Appointment(createID());
        appointments.add(appointment);
    }
    
    /**
     * Method to create an appointment with a specified schedule date.
     * 
     * @param date - specified date for appointment
     */
    public void newAppointment(LocalDate date) {
        Appointment appointment = new Appointment(createID(), date);
        appointments.add(appointment);
    }
    
    /**
     * Method to create an appointment with a specified schedule date and description.
     * 
     * @param date - specified date for appointment
     * @param description - descriptory details of appointment
     */
    public void newAppointment(LocalDate date, String description) {
        Appointment appointment = new Appointment(createID(), date, description);
        appointments.add(appointment);
    }
}