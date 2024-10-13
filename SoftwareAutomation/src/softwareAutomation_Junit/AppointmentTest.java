package softwareAutomation_Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

class AppointmentTest {

	@Test
	public void testDefaultConstructor() {

		Appointment appointment = new Appointment();

		// Arrange
		ZonedDateTime today = ZonedDateTime.now(ZoneId.systemDefault()).truncatedTo(ChronoUnit.SECONDS);

		// Assert
		assertEquals("INITIAL", appointment.getApptId());
		assertEquals("INITIAL DESCRIPTION", appointment.getApptDescription());
		assertEquals(today, appointment.getApptDate().truncatedTo(ChronoUnit.SECONDS));

	}

	@Test
	public void TestApptIdConstructor() {

		// Arrange
		Appointment appointment = new Appointment("Appt1");

		// Assert
		assertEquals("Appt1", appointment.getApptId());

	}

	@Test
	public void TestApptIdAndDateConstructor() {

		// Arrange
		ZonedDateTime today = ZonedDateTime.now(ZoneId.systemDefault()).plusDays(1);

		Appointment appointment = new Appointment("Appt1", today);

		// Assert
		assertEquals("Appt1", appointment.getApptId());
		assertEquals(today, appointment.getApptDate());

	}

	@Test
	public void TestFullConstructor() {

		// Arrange
		ZonedDateTime today = ZonedDateTime.now(ZoneId.systemDefault());

		// Arrange
		Appointment appointment = new Appointment("Appt1", today, "Description");

		// Assert
		assertEquals("Appt1", appointment.getApptId());
		assertEquals("Description", appointment.getApptDescription());
		assertEquals(today, appointment.getApptDate());
	}

	@Test
	void testdDateValidation() {

		// Arrange
		ZonedDateTime pastToday = ZonedDateTime.now(ZoneId.systemDefault()).minusDays(1);

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Appt1", pastToday);
		});
	}

	@Test
	void testIdValidation() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("This Appointment Id is too long");
		});
	}

	@Test
	void testDescriptionValidation() {

		// Arrange
		ZonedDateTime today = ZonedDateTime.now(ZoneId.systemDefault());

		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Appt1", today, "This is a long task description that exceeds 50 characters. ");
		});
	}
}
