package milestone3;

/*
 * Milestone guidelines call for utilization of java.util.Date.  This API, however, has proven to be 
 * error-prone and poorly performing.  Instead, the more modern and technically sound Date-Time API 
 * from Java 8 is implemented in the Date API's place.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Tests the AppointmentService class by creating Appointment objects, the 
 * methods that affect them, and the appointment service itself that lists them.
 * 
 * @author Ryan Rieth
 * @version 11/27/2022
 */
class AppointmentServiceTest {
    // Instance variables.
    private String id, description;         // Unique identifier and description.
    private LocalDate date, previousDate;        // Specified date and previously scheduled date.
    
    /**
     * Constructs an appointment for testing purposes.
     * Occurs prior to each test.
     */
    //@SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        id = "1";
        date = LocalDate.of(2023, Month.NOVEMBER, 27);
        previousDate = LocalDate.of(1955, Month.OCTOBER, 27);
        description = "This is a valid description for the appointment.";
    }
    
    /**
     * Tests the creation and proper listing of appointments.
     * Checks for null values, decidedly unique IDs, and present or future dates.
     */
    @Test
    void testNewAppointment() {
        AppointmentService service = new AppointmentService();
        
        service.newAppointment();
        assertAll("default appointment",
                    ()
                        -> assertNotNull(service.getAppointments().get(0).getID()),
                    ()
                        -> assertNotNull(service.getAppointments().get(0).getDate()),
                    ()
                        -> assertNotNull(service.getAppointments().get(0).getDescription()));
                        
        service.newAppointment(date);
        assertAll("specified date appointment",
                    ()
                        -> assertNotNull(service.getAppointments().get(1).getID()),
                    ()
                        -> assertNotEquals(service.getAppointments().get(1).getID(), 
                                           service.getAppointments().get(0).getID()),
                    ()
                        -> assertNotNull(service.getAppointments().get(1).getDate()),
                    ()
                        -> assertEquals(service.getAppointments().get(1).getDate(), date),
                    ()
                        -> assertNotNull(service.getAppointments().get(1).getDescription()));
        
        service.newAppointment(date, description);
        assertAll("specified date and description appointment",
                    ()
                        -> assertNotNull(service.getAppointments().get(2).getID()),
                    ()
                        -> assertNotEquals(service.getAppointments().get(2).getID(),
                                           service.getAppointments().get(1).getID()),
                    ()
                        -> assertNotEquals(service.getAppointments().get(2).getID(),
                                           service.getAppointments().get(0).getID()),
                    ()
                        -> assertNotNull(service.getAppointments().get(2).getDate()),
                    ()
                        -> assertEquals(service.getAppointments().get(2).getDate(), date),
                    ()
                        -> assertNotNull(service.getAppointments().get(2).getDescription()),
                    ()
                        -> assertEquals(service.getAppointments().get(2).getDescription(), description));
        
        assertAll("previous date incursions",
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> service.newAppointment(previousDate)),
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> service.newAppointment(previousDate, description)),
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> service.getAppointments().get(0).updateDate(previousDate)));
        
        assertAll("length descriptions",
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> service.newAppointment(date, "This is not a valid description for this particular appointment.")),
                    ()
                        -> assertThrows(IllegalArgumentException.class,
                                        () -> service.getAppointments().get(0).updateDescription("This is not a valid description for this particular appointment.")));
    }
    
    /**
     * Tests the deletion and proper de-listing of appointments.
     * Checks for decidedly unique IDs and proper error handling of deletion request
     * of nonexistent appointments.
     */
    @Test
    void deleteAppointment() throws Exception {
        AppointmentService service = new AppointmentService();
        
        service.newAppointment();
        service.newAppointment();
        
        String idOne = service.getAppointments().get(0).getID();
        String idTwo = service.getAppointments().get(1).getID();
        
        assertNotEquals(idOne, idTwo);
        
        String randomID = Integer.toString(ThreadLocalRandom.current().nextInt(3, 11));
        assertThrows(Exception.class, () -> service.deleteAppointment(randomID));
        
        service.deleteAppointment(idOne);
        assertThrows(Exception.class,
                     () -> service.deleteAppointment(idOne));
    }
}