package softwareAutomation_Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testDefaultConstructor() {

		Contact contact = new Contact();
		assertEquals("INITIAL", contact.getContactId());
		assertEquals("INITIAL", contact.getFirstName());
		assertEquals("INITIAL", contact.getLastName());
		assertEquals("0123456789", contact.getPhoneNumber());
		assertEquals("INITIAL", contact.getAddressField());
	}

	@Test
	void testIdConstructor() {

		Contact contact = new Contact("contact1");
		assertEquals("contact1", contact.getContactId());
		assertEquals("INITIAL", contact.getFirstName());
		assertEquals("INITIAL", contact.getLastName());
		assertEquals("0123456789", contact.getPhoneNumber());
		assertEquals("INITIAL", contact.getAddressField());
	}

	@Test
	void testIdAndFirstNameConstructor() {

		Contact contact = new Contact("contact1", "firstname");
		assertEquals("contact1", contact.getContactId());
		assertEquals("firstname", contact.getFirstName());
		assertEquals("INITIAL", contact.getLastName());
		assertEquals("0123456789", contact.getPhoneNumber());
		assertEquals("INITIAL", contact.getAddressField());
	}

	@Test
	void testIdAndFirstNameAndLastNameConstructor() {

		Contact contact = new Contact("contact1", "firstname", "lastname");
		assertEquals("contact1", contact.getContactId());
		assertEquals("firstname", contact.getFirstName());
		assertEquals("lastname", contact.getLastName());
		assertEquals("0123456789", contact.getPhoneNumber());
		assertEquals("INITIAL", contact.getAddressField());
	}

	@Test
	void testIdAndFirstNameAndLastNameAndPhoneNumberConstructor() {

		Contact contact = new Contact("contact1", "firstname", "lastname", "1234567890");
		assertEquals("contact1", contact.getContactId());
		assertEquals("firstname", contact.getFirstName());
		assertEquals("lastname", contact.getLastName());
		assertEquals("1234567890", contact.getPhoneNumber());
		assertEquals("INITIAL", contact.getAddressField());
	}

	@Test
	void testCompleteConstructor() {

		Contact contact = new Contact("contact1", "firstname", "lastname", "1234567890", "address");
		assertEquals("contact1", contact.getContactId());
		assertEquals("firstname", contact.getFirstName());
		assertEquals("lastname", contact.getLastName());
		assertEquals("1234567890", contact.getPhoneNumber());
		assertEquals("address", contact.getAddressField());
	}

	@Test
	void testContactId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("This contact id exceeds the 10 character limit.");
		});

	}

	@Test
	void testFirstName() throws IllegalArgumentException {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact1", "This first name exceeds th e10 character limit.");
		});
	}

	@Test
	void testLastName() throws IllegalArgumentException {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact1", "firstname", "Last name exceeds th e10 character limit.");
		});
	}

	@Test
	void testPhoneNumber() throws IllegalArgumentException {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact1", "firstname", "lastname", "Phone number is not exactly ten digits.");
		});
	}

	@Test
	void testaddressField() throws IllegalArgumentException {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contact1", "firstname", "lastname", "0123456789",
					"Address field exceeds the thirty character limit");
		});
	}

}
