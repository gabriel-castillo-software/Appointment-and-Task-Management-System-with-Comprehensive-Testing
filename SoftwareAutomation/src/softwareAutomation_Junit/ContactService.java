package softwareAutomation_Junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactService {

	private final List<Contact> contactList = new ArrayList<>();

	private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private final int CHARACTERLENGTH = CHARACTERS.length();

	private String UniqueID() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(CHARACTERLENGTH);
			builder.append(CHARACTERS.charAt(index));
		}

		return builder.toString();
	}

	public Contact contactLocator(String contactId) throws Exception {

		for (int i = 0; i < contactList.size(); i++) {
			if (contactId.equals(contactList.get(i).getContactId())) {
				return contactList.get(i);
			}

		}
		throw new Exception("The contact does not exist.");
	}

	public void createContact() {
		Contact contact = new Contact(UniqueID());
		contactList.add(contact);
	}

	public void createContact(String firstName) {
		Contact contact = new Contact(UniqueID(), firstName);
		contactList.add(contact);
	}

	public void createContact(String firstName, String lastName) {
		Contact contact = new Contact(UniqueID(), firstName, lastName);
		contactList.add(contact);
	}

	public void createContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(UniqueID(), firstName, lastName, phoneNumber);
		contactList.add(contact);
	}

	public void createContact(String firstName, String lastName, String phoneNumber, String addressField) {
		Contact contact = new Contact(UniqueID(), firstName, lastName, phoneNumber, addressField);
		contactList.add(contact);
	}

	public void deleteContact(String contactId) throws Exception {
		contactList.remove(contactLocator(contactId));
	}

	public void updateFirstName(String contactid, String firstName) throws Exception {
		contactLocator(contactid).setFirstName(firstName);
	}

	public void updateLastName(String contactid, String lastName) throws Exception {
		contactLocator(contactid).setLastName(lastName);
	}

	public void updatePhoneNumber(String contactid, String phoneNumber) throws Exception {
		contactLocator(contactid).setPhoneNumber(phoneNumber);
	}

	public void updateAddressField(String contactid, String addressField) throws Exception {
		contactLocator(contactid).setAddressField(addressField);
	}

	public List<Contact> getContactList() {
		return contactList;
	}

}
