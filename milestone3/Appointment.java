/*
 * Milestone guidelines call for utilization of java.util.Date.  This API, however, has proven to be 
 * error-prone and poorly performing.  Instead, the more modern and technically sound Date-Time API 
 * from Java 8 is implemented in the Date API's place.
 */

import java.time.*;

/**
 * Create an appointment with a unique identifier, date, and description.
 *
 * @author Ryan Rieth
 * @version 11/27/2022
 */
public class Appointment {
    // Instance variables.
    private String id;                  // Unique identifier for appointment.
    private LocalDate date;             // Specified schedule date for appointment.
    private String description;         // Descriptory detailing for appointment.
    
    /**
     * Default Appointment constructor.
     */
    Appointment() {
        id = "1";
        date = LocalDate.now();
        description = "This is a valid description for the appointment.";
    }
    
    /**
     * Appointment constructor with specified unique ID.
     * 
     * @param id - unique identifier of appointment
     */
    Appointment(String id) {
        updateID(id);
        date = LocalDate.now();
        description = "This is a valid description for the appointment.";
    }
    
    /**
     * Appointment constructor with specified unique ID and date.
     * 
     * @param id - unique identifier of appointment
     * @param date - specified date of appointment
     */
    Appointment(String id, LocalDate date) {
        updateID(id);
        updateDate(date);
        description = "This is a valid description for the appointment.";
    }
    
    /**
     * Appointment constructor with specified unique ID, date, and description.
     * 
     * @param id - unique identifier of appointment
     * @param date - specified date of appointment
     * @param description - descriptory details of appointment
     */
    Appointment(String id, LocalDate date, String description) {
        updateID(id);
        updateDate(date);
        updateDescription(description);
    }
    
    /**
     * Method to return an appointment's unique ID.
     * 
     * @return id - unique identifier for appointment
     */
    public String getID() { return id; }
    
    /**
     * Method to return an appointment's scheduled date.
     * 
     * @return date - specified date for appointment
     */
    public LocalDate getDate() { return date; }
    
    /**
     * Method to return an appointment's detailng.
     * 
     * @return description - descriptory details of appointment
     */
    public String getDescription() { return description; }
    
    /**
     * Method to update an appointment's ID.
     * Checks for null values or values of more than 10 characters.
     * Purposed to occur once upon appointment creation.
     * 
     * @param id - unique identifier of appointment
     */
    public void updateID(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }
        else if (id.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters.");
        }
        else {
            this.id = id;
        }
    }
    
    /**
     * Method to update an appointment's date.
     * Checks for null date values or dates in the past.
     * 
     * @param date - specified date of appointment
     */
    public void updateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Appointment date cannot be null.");
        }
        else if (date.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        else {
            this.date = date;
        }
    }
    
    /**
     * Method to update an appointment's description.
     * Checks for null values or descriptions with more than 50 characters.
     * 
     * @param description - descriptory details of appointment
     */
    public void updateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }
        else if (description.length() > 50) {
            throw new IllegalArgumentException("Description length cannot exceed 50 characters.");
        }
        else {
            this.description = description;
        }
    }
}