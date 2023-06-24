/*
 * Noah Duarte
 * Southern New Hampshire University
 * CS-320: Software Test Automation & QA
 * Professor Albanie Bolton
 * May 21 2023
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest
{
	// variables that meet requirements
	String contactId = "C-130T";
	String firstName = "Mighty";
	String lastName = "Hercules";
	String phoneNumber = "5551234567";
	String address = "123 Flight Line";

	// Test for all functions working
	@Test
	void testContact()
	{		
		// create contact object
		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
		
		// verify that the contact was created
		assertNotNull(contact);
		assertEquals(contactId, contact.getContactID());
		assertEquals(firstName, contact.getFirstName());
		assertEquals(lastName, contact.getLastName());
		assertEquals(phoneNumber, contact.getPhoneNumber());
		assertEquals(address, contact.getAddress());
	}
	
	// test input validation for null
	@Test
    public void testNullContact() 
	{
        // verify that the constructor throws IllegalArgumentException with the correct error message
		contactId = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, address);
        }, "Contact ID must not be null and cannot exceed 10 characters.");

        // Repeat the same for other invalid parameters...
        // first name == null
        contactId = "C123456789";
        firstName = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, address);
        }, "First name must not be null and cannot exceed 10 characters.");

        // last name == null
        firstName = "John";
        lastName = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, address);
        }, "Last name must not be null and cannot exceed 10 characters.");

        // phone number == null
        lastName = "Doe";
        phoneNumber = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, address);
        }, "Phone must not be null and must be exactly 10 digits.");

        // address == null
        phoneNumber = "1234567890";
        address = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, address);
        }, "Address must not be null and cannot exceed 30 characters.");
    }
	
	// test input validation for incorrect character length
		@Test
	    public void testInputLengthContact() 
		{
	        // Verify that the constructor throws IllegalArgumentException with the correct error message
			contactId = "Character length too long";
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(contactId, firstName, lastName, phoneNumber, address);
	        }, "Contact ID must not be null and cannot exceed 10 characters.");

	        // Repeat the same for other invalid parameters...
	        // first name too long
	        contactId = "C-130T";
	        firstName = "Character length too long";
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(contactId, firstName, lastName, phoneNumber, address);
	        }, "First name must not be null and cannot exceed 10 characters.");

	        // last name too long
	        firstName = "Mighty";
	        lastName = "Character length too long";
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(contactId, firstName, lastName, phoneNumber, address);
	        }, "Last name must not be null and cannot exceed 10 characters.");

	        // Invalid phone number
	        lastName = "Hercules";
	        phoneNumber = "Character length too long";
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(contactId, firstName, lastName, phoneNumber, address);
	        }, "Phone must not be null and must be exactly 10 digits.");

	        // address too long
	        phoneNumber = "5551234567";
	        address = "Character length too long......";
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(contactId, firstName, lastName, phoneNumber, address);
	        }, "Address must not be null and cannot exceed 30 characters.");
	    }
}
