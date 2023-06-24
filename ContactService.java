/*
 * Noah Duarte
 * Southern New Hampshire University
 * CS-320: Software Test Automation & QA
 * Professor Albanie Bolton
 * May 21 2023
 */

import java.util.ArrayList;

public class ContactService 
{
	// initialize contact array list
	ArrayList<Contact> contacts;

	public ContactService() 
	{
		// new contacts array list
		contacts = new ArrayList<>();
	}

	// this will check contact list and add if the contact does not exist
	public boolean addContact(Contact newContact) 
	{
		// variable to hold contact validation
		boolean exists = false;
		// iterate through all contacts
		for (Contact contact : contacts) 
		{
			// check if contact exists
			if (contact.getContactID().equalsIgnoreCase(newContact.getContactID())) 
			{
				// return true if found
				exists = true;
			}
		}

		// if contact does not exist
		if (!exists) 
		{
			// add contact
			contacts.add(newContact);
			return true;
		}
		
		// else return false
		else 
		{
			return false;
		}
	}

	// This will check to see if the contact exists and delete it
	public boolean deleteContact(String contactID) 
	{
		// iterate through all contacts
		for (Contact contact : contacts) 
		{
			// check to see if contact exists
			if (contact.getContactID().equalsIgnoreCase(contactID)) 
			{
				// call remove to delete contact
				contacts.remove(contact);
				// verify deletion
				return true;
			}
		}
		return false;
	}

	// This will update contacts first name per contactID
	public boolean updateContactFirstName(String contactID, String updateFirstName) 
	{
		// iterate through contacts
		for (Contact contact : contacts) 
		{
			//if contact exists
			if (contact.getContactID().equalsIgnoreCase(contactID)) 
			{
				// set updated first name
				contact.setFirstName(updateFirstName);
			}
		}
		return true;
	}

	// This will update the contacts last name per contactID
	public boolean updateContactLastName(String contactID, String updateLastName) 
	{
		// iterate through contacts
		for (Contact contact : contacts) 
		{
			// if contact exists
			if (contact.getContactID().equalsIgnoreCase(contactID)) 
			{
				// set updated last name
				contact.setLastName(updateLastName);
			}
		}
		return true;
	}

	// This will update the contacts phone number per contactID
	public boolean updateContactNumber(String contactID, String updatePhoneNumber) 
	{
		// verification variable
		//boolean updated = false;
		// iterate through contact
		for (Contact contact : contacts) 
		{
			// if contact exists
			if (contact.getContactID().equalsIgnoreCase(contactID)) 
			{
				// set updated phone number
				contact.setPhoneNumber(updatePhoneNumber);
			}
		}
		return true;
	}

	// This will update the contact address per contactID
	public boolean updateContactAddress(String contactID, String updateAddress) 
	{
		// iterate through contacts
		for (Contact contact : contacts) 
		{
			// if contact exists
			if (contact.getContactID().equalsIgnoreCase(contactID)) 
			{
				// set updated address
				contact.setAddress(updateAddress);
			}
		}
		return true;
	}

	public boolean hasContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equalsIgnoreCase(contactId)) {
                return true;
            }
        }
        return false;
    }
}
