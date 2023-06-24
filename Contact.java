/*
 * Noah Duarte
 * Southern New Hampshire University
 * CS-320: Software Test Automation & QA
 * Professor Albanie Bolton
 * May 21 2023
 */

public class Contact 
{
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// basic constructor
	public Contact(String contactid, String firstname, String lastname, String phonenumber, String address)
	{
		//validation statements
		if (contactid == null || contactid.length() > 10) {
	        throw new IllegalArgumentException("Contact ID must not be null and cannot exceed 10 characters.");
	    }
	    if (firstname == null || firstname.length() > 10) {
	        throw new IllegalArgumentException("First name must not be null and cannot exceed 10 characters.");
	    }
	    if (lastname == null || lastname.length() > 10) {
	        throw new IllegalArgumentException("Last name must not be null and cannot exceed 10 characters.");
	    }
	    if (phonenumber == null || phonenumber.length() != 10) {
	        throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits.");
	    }
	    if (address == null || address.length() > 30) {
	        throw new IllegalArgumentException("Address must not be null and cannot exceed 30 characters.");
	    }
	    
	    // builds constructor 
		this.setContactID(contactid);
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setPhoneNumber(phonenumber);
		this.setAddress(address);
	}

	// setter contactID
	public void setContactID(String contactid) 
	{
			// set contact ID
			this.contactID = contactid;		
	}
	// setter first name
	public void setFirstName(String firstname) 
	{
			this.firstName = firstname;
	}
	
	// setter last name
	public void setLastName(String lastname) 
	{
			// set last name
			this.lastName = lastname;
	}
	
	// setter phone number
	public void setPhoneNumber(String phonenumber) 
	{
			// set phone number
			this.phoneNumber = phonenumber;
	}

	// setter address
	public void setAddress(String address) 
	{
			// set address
			this.address = address;
	}

	// getter contactID
	public String getContactID() 
	{
		// return contactID
		return contactID;
	}
	
	// getter first name
	public String getFirstName() 
	{
		// return first name
		return firstName;
	}

	// getter last name
	public String getLastName() 
	{
		// return last name
		return lastName;
	}

	// getter phone number
	public String getPhoneNumber() 
	{
		// return phone number
		return phoneNumber;
	}
	
	// getter address
	public String getAddress() 
	{
		// return address
		return address;
	}
}


