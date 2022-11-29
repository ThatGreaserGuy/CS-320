/*
 * Milestone guidelines call for utilization of java.util.Date.  This API, however, has proven to be 
 * error-prone and poorly performing.  Instead, the more modern and technically sound Date-Time API 
 * from Java 8 is implemented in the Date API's place.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * Tests the Appointment class by creating appointment objects
 * and methods that affect them.
 *
 * @author Ryan Rieth
 * @version 11/27/2022
 */
class AppointmentTest {
    // Instance variables.
    private String id, description;         // Unique identifier and description.
    private LocalDate date, previousDate;   // Specified date and previously scheduled date.
    
    /**
     * Constructs an appointment for testing purposes.
     * Occurs prior to each test.
     */
    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        id = "1";
        date = LocalDate.of(2023, Month.NOVEMBER, 27);
        previousDate = LocalDate.of(1955, Month.OCTOBER, 27);
        description = "This is a valid description for the appointment.";
    }
    
    /**
     * Tests the method to return an appointment's unique ID.
     */
    @Test
    void testGetID() {
        Appointment appointment = new Appointment(id);
        
        assertAll("get ID",
                    ()
                        -> assertNotNull(appointment.getID()),
                    ()
                        -> assertTrue(appointment.getID().length() < 11),
                    ()
                        -> assertEquals(appointment.getID(), id));
    }
    
    /**
     * Tests the method to return an appointment's scheduled date.
     */
    @Test
    void testGetDate() {
        Appointment appointment = new Appointment(id, date);
        
        assertAll("get date",
                    ()
                        -> assertNotNull(appointment.getDate()),
                    ()
                        -> assertEquals(appointment.getDate(), date));
    }
    
    /**
     * Tests the method to return an appointment's description.
     */
    @Test
    void testGetDescription() {
        Appointment appointment = new Appointment(id, date, description);
        
        assertAll("get description",
                    ()
                        -> assertNotNull(appointment.getDescription()),
                    ()
                        -> assertTrue(appointment.getDescription().length() < 51),
                    ()
                        -> assertEquals(appointment.getDescription(), description));
    }
    
    /**
     * Tests the method to update an appointment's unique ID.
     */
    @Test
    void testUpdateID() {
        Appointment appointment = new Appointment();
        
        assertAll("set ID",
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> appointment.updateID(null)),
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> appointment.updateID("12345654321")));
        
        appointment.updateID(id);
        assertEquals(appointment.getID(), id);
    }
    
    /**
     * Tests the method to update an appointment's specified date.
     */
    @Test
    void testUpdateDate() {
        Appointment appointment = new Appointment();
        
        assertAll("set date",
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> appointment.updateDate(null)),
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> appointment.updateDate(previousDate)));
        
        
        appointment.updateDate(date);
        assertEquals(date, appointment.getDate());
    }
    
    /**
     * Tests the method to update an appointment's description.
     */
    @Test
    void testUpdateDescription() {
        Appointment appointment = new Appointment();
        
        assertAll("set description",
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> appointment.updateDescription(null)),
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> appointment.updateDescription("This is not a valid description for this particular appointment.")));
        
        appointment.updateDescription(description);
        assertEquals(appointment.getDescription(), description);
    }

    @Test
    public void testAll()
    {
        Appointment appointm1 = new Appointment();
    }
}
