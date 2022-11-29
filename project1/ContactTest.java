package milestone1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ContactTest tests the Contact class for proper execution.
 *
 * @author  Ryan Rieth
 * @version 11/11/2022
 */
public class ContactTest {
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
     * Tests default contact creation.
     * 
     * Asserts information is not null.
     */
    @Test
    void contactTest() {
        Contact contact = new Contact();
        
        assertAll("constructor",
                ()
                    -> assertNotNull(contact.getID()),
                ()
                    -> assertNotNull(contact.getFirstName()),
                ()
                    -> assertNotNull(contact.getLastName()),
                ()
                    -> assertNotNull(contact.getPhoneNum()),
                ()
                    -> assertNotNull(contact.getAddress()));
    }
    
    /**
     * Tests contact creation with variables.
     * 
     * Asserts contact is created with the information provided.
     * 
     * @param testID - unique ID for testing
     * @param testFirstName - first name for testing
     * @param testLastName - last name for testing
     * @param testPhoneNum - phone number for testing
     * @param testAddress - address for testing
     */
    @Test
    void contactTotalTest() {
        Contact contact = new Contact(testID, testFirstName, testLastName, testPhoneNum, testAddress);
        
        assertAll("total constructor",
                ()
                    -> assertEquals(testID, contact.getID()),
                ()
                    -> assertEquals(testFirstName, contact.getFirstName()),
                ()
                    -> assertEquals(testLastName, contact.getLastName()),
                ()
                    -> assertEquals(testPhoneNum, contact.getPhoneNum()),
                ()
                    -> assertEquals(testAddress, contact.getAddress()));
    }
    
    /**
     * Tests the method to update a contact's first name.
     * 
     * Asserts null values and variables with more 
     * than 10 characters do not get recorded.
     */
    @Test
    void updateFirstNameTest() {
        Contact contact = new Contact();
        contact.updateFirstName(testFirstName);
        
        assertAll("set first name",
                ()
                    -> assertEquals(testFirstName, contact.getFirstName()),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updateFirstName(null)),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updateFirstName("RebelWithoutACause")));
    }
    
    /**
     * Tests the method to update a contact's last name.
     * 
     * Asserts null values and variables with more 
     * than 10 characters do not get recorded.
     */
    @Test
    void updateLastNameTest() {
        Contact contact = new Contact();
        contact.updateLastName(testLastName);
        
        assertAll("set last name",
                ()
                    -> assertEquals(testLastName, contact.getLastName()),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updateLastName(null)),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updateLastName("StarringJamesDeanAndNatalieWood")));
    }
    
    /**
     * Tests the method to update a contact's phone number.
     * 
     * Asserts that null values and variables with less 
     * than 10 characters or more than 10 characters, 
     * as well as unacceptable characters, do not get
     * recorded.
     */
    @Test
    void updatePhoneNumTest() {
        Contact contact = new Contact();
        contact.updatePhoneNum(testPhoneNum);
        
        assertAll("set phone number",
                ()
                    -> assertEquals(testPhoneNum, contact.getPhoneNum()),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updatePhoneNum(null)),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updatePhoneNum("11223344556677889900")),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updatePhoneNum("01271955")),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updatePhoneNum("R3B3L")));
    }
    
    /**
     * Tests the method to update a contact's address.
     * 
     * Asserts that null values and addresses with 
     * more than 30 characters do not get recorded.
     */
    @Test
    void updateAddressTest() {
        Contact contact = new Contact();
        contact.updateAddress(testAddress);
        
        assertAll("set address",
                ()
                    -> assertEquals(testAddress, contact.getAddress()),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updateAddress(null)),
                ()
                    -> assertThrows(IllegalArgumentException.class,
                                    () -> contact.updateAddress("2800 East Observatory Road, Los Angeles, CA, 90027")));
    }
}