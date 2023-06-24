/*
 * Noah Duarte
 * Southern New Hampshire University
 * CS-320: Software Test Automation & QA
 * Professor Albanie Bolton
 * May 21 2023
 */

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;



public class ContactServiceTest
{
	private ContactService contactService = new ContactService();

	// test add function for adding a contact
	@Test
	void testAdd()
	{
		// new Contact object
		Contact contact = new Contact("0000000000", "Lauren", "Smith", "5551111111", "123 Maple St");
		// add contact to ContactService
		boolean added = contactService.addContact(contact);
		// verify that the contact was added
		assertTrue(added);
		// verify that the contact exists
		assertTrue(contactService.hasContact(contact.getContactID()));
	}
	
	// test add function for duplicate contact
	@Test
	void testAddDuplicate()
	{
		// create contact object
		Contact contact = new Contact("1111111111", "Lauren", "Smith", "5551111111", "123 Maple St");
		// add the contact to contactService
		boolean addFirstTime = contactService.addContact(contact);
		// verify that the contact was added
		assertTrue(addFirstTime);
		// try to add the same contact again
		boolean addSecondTime = contactService.addContact(contact);
		// verify that the contact was not added again
		assertFalse(addSecondTime);
	}
	
	// test the deletion of a contact
	@Test
	void testDeleteContact()
	{
		Contact contact = new Contact("2222222222", "First", "Last", "1234567890", "123 Test Ave.");
		// add the contact to ContactService
		contactService.addContact(contact);
		// verify that the contact exists
		assertTrue(contactService.hasContact(contact.getContactID()));
		// delete the contact from ContactService
		boolean delete = contactService.deleteContact(contact.getContactID());
		//verify the contact was deleted
		assertTrue(delete);
		// verify that the contact was deleted
		assertFalse(contactService.hasContact(contact.getContactID()));
	}
	
	// attempt to delete a contact that does not exist
	@Test
	void testDeleteNonExistingContact()
	{
		// delete a contact that does not exist
		boolean deleted = contactService.deleteContact("2222222222");
		// verify that contact was not deleted
		assertFalse(deleted);
	}
	
	// test to update first name
	@Test
	void testUpdateFirstName()
	{
		// create contact object
		Contact contact = new Contact("3333333333", "Dear", "Wilson", "0987654321", "909 Upland Blvd");
		// add the contact
		contactService.addContact(contact);
		// update first name
		String updateFirstName = "Bob";
		boolean update = contactService.updateContactFirstName(contact.getContactID(), updateFirstName);
		// verify that the first name was updated
		assertTrue(update);
		assertEquals(updateFirstName, contact.getFirstName());
	}
	
	// test to update last name
	@Test
	void testUpdateLastName()
	{
		// create contact object
		Contact contact = new Contact("4444444444", "Lauren", "Smith", "9095554321", "I made it up st.");
		// add the contact to ContactService
		contactService.addContact(contact);
		//update the last name
		String updatedLastName = "Duarte";
		boolean update = contactService.updateContactLastName(contact.getContactID(), updatedLastName);
		// verify that the last name was updated
		assertTrue(update);
		assertEquals(updatedLastName, contact.getLastName());
	}
	
	// test update contact number
	@Test
	void testupdatePhoneNumber()
	{
		// create a contact object
		Contact contact = new Contact("6666666666", "Stacy's", "Mom", "0001234567", "Out of ideas CT");
		// add the contact
		contactService.addContact(contact);
		// update the phone number
		String updatePhoneNumber = "5551234567";
		boolean update = contactService.updateContactNumber(contact.getContactID(), updatePhoneNumber);
		// verify that the phone number was updated
		assertTrue(update);
		assertEquals(updatePhoneNumber, contact.getPhoneNumber());
	}
	
	// test updating address
	@Test
	void testUpdateAddress()
	{
		// create contact object
		Contact contact = new Contact("7777777777", "Breaking", "Benjamine", "5559091234", "177 S St.");
		// add the contact
		contactService.addContact(contact);
		//Update the address
		String updateAddress = "177 N St.";
		boolean update = contactService.updateContactAddress(contact.getContactID(), updateAddress);
		// verify the address updated
		assertTrue(update);
		assertEquals(updateAddress, contact.getAddress());
	}

}
