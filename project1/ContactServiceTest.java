package milestone1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ContactServiceTests tests the ContactService class for proper execution.
 *
 * @author  Ryan Rieth
 * @version 11/11/2022
 */
public class ContactServiceTest
{
    protected String testID, testFirstName, testLastName, testPhoneNum, testAddress;
    
    /**
     * Sets up information for a test contact.
     *
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        testID = "2";
        testFirstName = "Natalie";
        testLastName = "Wood";
        testPhoneNum = "5591772211";
        testAddress = "2800 E Observatory Rd";
    }
    
    /**
     * Tests methods to create default or specified contacts.
     */
    @Test
    void contactTest() {
        ContactService service = new ContactService();
        service.newContact();
        
        assertAll("service",
                ()
                    -> assertNotNull(service.getContactList().get(0).getID()),
                ()
                    -> assertEquals("James", service.getContactList().get(0).getFirstName()),
                ()
                    -> assertEquals("Dean", service.getContactList().get(0).getLastName()),
                ()
                    -> assertEquals("1122771955", service.getContactList().get(0).getPhoneNum()),
                ()
                    -> assertEquals("2800 East Observatory Road", service.getContactList().get(0).getAddress()));
        
        service.newContact(testFirstName, testLastName, testPhoneNum, testAddress);
        
        assertAll("service total",
                ()
                    -> assertNotNull(service.getContactList().get(1).getID()),
                ()
                    -> assertEquals(testFirstName, service.getContactList().get(1).getFirstName()),
                ()
                    -> assertEquals(testLastName, service.getContactList().get(1).getLastName()),
                ()
                    -> assertEquals(testPhoneNum, service.getContactList().get(1).getPhoneNum()),
                ()
                    -> assertEquals(testAddress, service.getContactList().get(1).getAddress()));
    }
    
    /**
     * Tests method to delete a contact from the service.
     * 
     * Asserts a contact is properly removed from the 
     * service.
     */
    @Test
    void deleteContactTest() {
        ContactService service = new ContactService();
        service.newContact();
        
        assertThrows(Exception.class, () -> service.deleteContact(testID));
        
        assertAll(()
                    -> service.deleteContact(service.getContactList().get(0).getID()));
    }
    
    /**
     * Tests method to update a contact's first name.
     * 
     * Asserts null values and first name's with more 
     * than 10 characters are not recorded.
     * 
     * Also asserts that updated valid first names 
     * have been recorded.
     */
    @Test
    void updateFirstNameTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact();
        service.updateFirstName(service.getContactList().get(0).getID(), testFirstName);
        
        assertEquals(testFirstName, service.getContactList().get(0).getFirstName());
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updateFirstName(service.getContactList().get(0).getID(), "RebelWithoutACause"));
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updateFirstName(service.getContactList().get(0).getID(), null));
        
        assertThrows(Exception.class,
                    () -> service.updateFirstName(testID, testFirstName));
    }
    
    /**
     * Tests method to update a contact's last name.
     * 
     * Asserts null values and last name's with more 
     * than 10 characters are not recorded.
     * 
     * Also asserts that updated valid last names 
     * have been recorded.
     */
    @Test
    void updateLastNameTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact();
        service.updateLastName(service.getContactList().get(0).getID(), testLastName);
        
        assertEquals(testLastName, service.getContactList().get(0).getLastName());
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updateLastName(service.getContactList().get(0).getID(), "StarringJamesDeanAndNatalieWood"));
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updateLastName(service.getContactList().get(0).getID(), null));
        
        assertThrows(Exception.class,
                    () -> service.updateLastName(testID, testLastName));
    }
    
    /**
     * Tests method to update a contact's phone number.
     * 
     * Asserts null values and phone numbers that have 
     * less than or more than 10 characters, as well 
     * as any non-digit characters, are not recorded.
     * 
     * Also asserts that updated valid phone numbers 
     * have been recorded.
     */
    @Test
    void updatePhoneNumTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact();
        service.updatePhoneNum(service.getContactList().get(0).getID(), testPhoneNum);
        
        assertEquals(testPhoneNum, service.getContactList().get(0).getPhoneNum());
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updatePhoneNum(service.getContactList().get(0).getID(), "11223344556677889900"));
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updatePhoneNum(service.getContactList().get(0).getID(), "01271955"));
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updatePhoneNum(service.getContactList().get(0).getID(), "R3B3L"));
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updatePhoneNum(service.getContactList().get(0).getID(), null));
        
        assertThrows(Exception.class,
                    () -> service.updatePhoneNum(testID, testLastName));
    }
    
    /**
     * Tests method to update a contact's address.
     * 
     * Asserts that addresses with more than 30 
     * characters or null values are not 
     * recorded.
     * 
     * Also asserts that updated valid addresses 
     * have been recorded.
     */
    @Test
    void updateAddressTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact();
        service.updateAddress(service.getContactList().get(0).getID(), testAddress);
        
        assertEquals(testAddress, service.getContactList().get(0).getAddress());
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updateAddress(service.getContactList().get(0).getID(), 
                          "2800 East Observatory Road, Los Angeles, CA, 90027"));
        
        assertThrows(IllegalArgumentException.class,
                    () -> service.updateAddress(service.getContactList().get(0).getID(), null));
        
        assertThrows(Exception.class,
                    () -> service.updateAddress(testID, testAddress));
    }
}