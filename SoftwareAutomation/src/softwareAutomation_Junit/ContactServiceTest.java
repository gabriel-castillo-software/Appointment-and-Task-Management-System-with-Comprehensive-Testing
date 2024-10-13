package softwareAutomation_Junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

class ContactServiceTest {

	private ContactService contactservice;

	@BeforeEach
	public void setUp() {
		contactservice = new ContactService();
	}

	@Test
	public void testContact() {

		contactservice.createContact();
		contactservice.createContact("first");
		contactservice.createContact("first", "last");
		contactservice.createContact("first", "last", "0123456789");
		contactservice.createContact("first", "last", "0123456789", "address");

		List<Contact> contactList = contactservice.getContactList();

		assertEquals(5, contactList.size());
	}

	@Test
	public void testDeleteContact() throws Exception {

		contactservice.createContact("contact1");

		Contact tempContact = contactservice.getContactList().get(0);
		contactservice.deleteContact(tempContact.getContactId());

		assertEquals(0, contactservice.getContactList().size());
	}

	@Test
	public void UpdateFirstName() throws Exception {
		contactservice.createContact("first");
		Contact contactUpdate = contactservice.getContactList().get(0);

		contactservice.updateFirstName(contactUpdate.getContactId(), "name");

		assertEquals("name", contactUpdate.getFirstName());
	}

	@Test
	public void UpdateLastName() throws Exception {
		contactservice.createContact("last");
		Contact contactUpdate = contactservice.getContactList().get(0);

		contactservice.updateLastName(contactUpdate.getContactId(), "name");

		assertEquals("name", contactUpdate.getLastName());
	}

	@Test
	public void UpdatePhoneNumber() throws Exception {
		contactservice.createContact("8586436525");
		Contact contactUpdate = contactservice.getContactList().get(0);

		contactservice.updatePhoneNumber(contactUpdate.getContactId(), "1472583690");

		assertEquals("1472583690", contactUpdate.getPhoneNumber());
	}

	@Test
	public void UpdateAddressField() throws Exception {
		contactservice.createContact("address");
		Contact contactUpdate = contactservice.getContactList().get(0);

		contactservice.updateAddressField(contactUpdate.getContactId(), "field");

		assertEquals("field", contactUpdate.getAddressField());
	}

	@Test
	public void searchForExistingContact() throws Exception {

		contactservice.createContact("contact");

		Contact contact = contactservice.getContactList().get(0);

		Contact contactFound = contactservice.contactLocator(contact.getContactId());

		assertNotNull(contactFound);
		assertEquals(contact.getContactId(), contactFound.getContactId());
	}

	@Test
	public void searchForNonExistingContact() throws Exception {
		assertThrows(Exception.class, () -> contactservice.contactLocator("0123456789"));
	}
}
