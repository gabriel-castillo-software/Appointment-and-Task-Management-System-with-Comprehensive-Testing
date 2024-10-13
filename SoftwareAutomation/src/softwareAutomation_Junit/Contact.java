package softwareAutomation_Junit;

public class Contact {

	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String addressField;

	public Contact() {

		this.contactId = "INITIAL";
		this.firstName = "INITIAL";
		this.lastName = "INITIAL";
		this.phoneNumber = "0123456789";
		this.addressField = "INITIAL";
	}

	public Contact(String contactId) {
		checkContactId(contactId);
		this.firstName = "INITIAL";
		this.lastName = "INITIAL";
		this.phoneNumber = "0123456789";
		this.addressField = "INITIAL";
	}

	public Contact(String contactId, String firstName) {
		checkContactId(contactId);
		setFirstName(firstName);
		this.lastName = "INITIAL";
		this.phoneNumber = "0123456789";
		this.addressField = "INITIAL";
	}

	public Contact(String contactId, String firstName, String lastName) {
		checkContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		this.phoneNumber = "0123456789";
		this.addressField = "INITIAL";
	}

	public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
		checkContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		this.addressField = "INITIAL";
	}

	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String addressField) {
		checkContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddressField(addressField);
	}

	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("Error: The first name is null or longer than 10 characters.");
		else
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Error: The last name is null or longer than 10 characters.");
		else
			this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() != 10)
			throw new IllegalArgumentException("Error: The phone number is null or not exactly 10 digits.");
		else
			this.phoneNumber = phoneNumber;
	}

	public String getAddressField() {
		return addressField;
	}

	public void setAddressField(String addressField) {
		if (addressField == null || addressField.length() > 10)
			throw new IllegalArgumentException("Error: The address field is null or longer than 30 characters.");
		else
			this.addressField = addressField;
	}

	private void checkContactId(String contactId) {

		if (contactId == null || contactId.length() > 10)
			throw new IllegalArgumentException("Error: The contact Id is null or longer than 10 characters");
		else
			this.contactId = contactId;
	}

}
