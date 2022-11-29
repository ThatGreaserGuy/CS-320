
/**
 * Contact is purposed to save contact information under a unique ID.
 *
 * @author Ryan Rieth
 * @version 11/11/2022
 */
public class Contact
{
    // Instance variables for contact information.
    private String id, firstName, lastName, phoneNum, address;

    /**
     * Constructor for default Contact.
     */
    Contact()
    {
        this.id = "1";
        this.firstName = "James";
        this.lastName = "Dean";
        this.phoneNum = "1122771955";
        this.address = "2800 East Observatory Road";
    }
    
    /**
     * Constructor for Contact with information provided.
     * 
     * @param id - unique ID for contact distinguishment
     * @param firstName - contact's first name for sorting
     * @param lastName - contact's last name for sorting
     * @param phoneNum - phone number for contacting
     * @param address - address for locating
     */
    Contact(String id, String firstName, String lastName, String phoneNum, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
    }
    
    /**
     * Method to return a contact's unique ID.
     * 
     * @return unique ID in string format
     */
    protected final String getID() {
        return id;
    }
    
    /**
     * Method to return a contact's first name.
     * 
     * @return first name in String format
     */
    protected final String getFirstName() {
        return firstName;
    }
    
    /**
     * Method to return a contact's last name.
     * 
     * @return last name in String format
     */
    protected final String getLastName() {
        return lastName;
    }
    
    /**
     * Method to return a contact's phone number.
     * 
     * @return phone number in String format
     */
    protected final String getPhoneNum() {
        return phoneNum;
    }
    
    /**
     * Method to return a contact's address.
     * 
     * @return address in String format
     */
    protected final String getAddress() {
        return address;
    }
    
    /*
     * There is no method to update a contact's ID.
     * 
     * Each contact's ID is meant to be unique and unalterable.
     */
    
    /**
     * Method to update a contact's first name.
     * 
     * Checks for null value or greater than 10 characters.
     * 
     * @param firstName - "new" first name the contact will receive
     */
    protected void updateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name.");
        }
        else {
            this.firstName = firstName;
        }
    }
    
    /**
     * Method to update a contact's last name.
     * 
     * Checks for null value or greater than 10 characters.
     * 
     * @param lastName - "new" last name the contact will receive
     */
    protected void updateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        else {
            this.lastName = lastName;
        }
    }
    
    /**
     * Method to update a contact's phone number.
     * 
     * Checks for null value and greater or less than 10 digits.
     * 
     * @param phoneNum - "new" phone number the contact will receive
     */
    protected void updatePhoneNum(String phoneNum) {
        /* Had the idea to check for digits but had no clue how to.
         * Remembered my regex experimentation with Apple Shortcuts.
         * Googled regex expressions and decided to utilize.
         */
        String regex = "[0-9]+";
        
        if (phoneNum == null || phoneNum.length() != 10 || !phoneNum.matches(regex)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
        else {
            this.phoneNum = phoneNum;
        }
    }
    
    /**
     * Method to update a contact's address.
     * 
     * Checks for null value and greater than 30 characters.
     * 
     * @param address - "new" address the contact will receive
     */
    protected void updateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address.");
        }
        else {
            this.address = address;
        }
    }
}
