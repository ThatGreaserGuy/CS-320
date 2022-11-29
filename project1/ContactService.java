package milestone1;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactService stores created Contacts by unique identification.
 *
 * @author Ryan Rieth
 * @version 11/11/2022
 */
public class ContactService
{
    // Instance variables.  Unique identifier and a contact list.
    private String uniqueID;
    private List<Contact> contacts = new ArrayList<>();
    
    /**
     * Creates a new default contact.
     */
    public void newContact() {
        Contact contact = new Contact();
        contacts.add(contact);
    }
    
    /**
     * Creates a new contact with provided information.
     * 
     * @param firstName - first name for sorting
     * @param lastName - last name for sorting
     * @param phoneNum - phone number for contacting
     * @param address - address for locating
     */
    public void newContact(String firstName, String lastName, String phoneNum, String address) {
        Contact contact = new Contact(createID(), firstName, lastName, phoneNum, address);
        contacts.add(contact);
    }
    
    /**
     * Method to delete a contact from the service.
     * 
     * @param id - unique ID to find the contact in the service
     */
    public void deleteContact(String id) throws Exception {
        contacts.remove(searchForContact(id));
    }
    
    /**
     * Method to update a contact's first name.
     * 
     * @param id - unique ID to find the contact in the service
     * @param firstName - "new" first name for contact
     */
    public void updateFirstName(String id, String firstName) throws Exception {
        searchForContact(id).updateFirstName(firstName);
    }
    
    /**
     * Method to update a contact's last name.
     * 
     * @param id - unique ID to find the contact in the service
     * @param lastName - "new" last name for contact
     */
    public void updateLastName(String id, String lastName) throws Exception {
        searchForContact(id).updateLastName(lastName);
    }
    
    /**
     * Method to update a contact's phone number.
     * 
     * @param id - unique ID to find the contact in the service
     * @param phoneNum - "new" phone number for contact
     */
    public void updatePhoneNum(String id, String phoneNum) throws Exception {
        searchForContact(id).updatePhoneNum(phoneNum);
    }
    
    /**
     * Method to update a contact's address.
     * 
     * @param id - unique ID to find the contact in the service
     * @param address - "new" address for contact
     */
    public void updateAddress(String id, String address) throws Exception {
        searchForContact(id).updateAddress(address);
    }
    
    /**
     * Method to retrieve the service's entire contact list.
     * 
     * @return contacts - the contact list the service handles
     */
    protected List<Contact> getContactList() {
        return contacts;
    }
    
    /**
     * Method to create a unique ID for a new contact.
     * Purposed to be sequential in contact creation.
     * 
     * @return uniqueID - a unique ID for a newly created contact
     */
    private String createID() {
        int size = contacts.size();
        size += 1;
        uniqueID = Integer.toString(size);
        
        return uniqueID;
    }
    
    /**
     * Method to search the contact list for a specific contact.
     * 
     * @param id - unique ID connected to singular contact
     * @return Contact - located singular contact
     */
    private Contact searchForContact(String id) throws Exception {
        for (int index = 0; index < contacts.size(); index++) {
            if (id.equals(contacts.get(index).getID())) {
                return contacts.get(index);
            }
        }
        
        throw new Exception("Contact does not exist.");
    }
}