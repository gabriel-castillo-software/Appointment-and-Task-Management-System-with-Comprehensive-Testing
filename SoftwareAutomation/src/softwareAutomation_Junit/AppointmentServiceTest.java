package softwareAutomation_Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	private AppointmentService appointmentService;

	@BeforeEach
	public void setUp() {
		appointmentService = new AppointmentService();
	}

	@Test
	public void testTask() {
		appointmentService.newAppointment();

		ZonedDateTime apptDate = ZonedDateTime.now(ZoneId.systemDefault()).truncatedTo(ChronoUnit.SECONDS);
		if (apptDate.isBefore(apptDate.minusDays(1))) {
			assertThrows(IllegalArgumentException.class, () -> {
				appointmentService.newAppointment(apptDate);
				appointmentService.newAppointment(apptDate, "Description for appt");
				List<Appointment> apptList = appointmentService.getApptList();

				assertEquals(3, apptList.size());
			});
		}
	}

	@Test
	public void testDeleteTask() throws Exception {
		appointmentService.newAppointment("Appt1");
		Appointment apptToDelete = appointmentService.getApptList().get(0);

		appointmentService.deleteAppt(apptToDelete.getApptId());

		assertTrue(appointmentService.getApptList().isEmpty());
	}

	@Test
	public void testUpdateDate() throws Exception {

		ZonedDateTime apptDate = ZonedDateTime.now(ZoneId.systemDefault()).truncatedTo(ChronoUnit.SECONDS);

		appointmentService.newAppointment("Original appointment");
		Appointment apptToUpdate = appointmentService.getApptList().get(0);

		appointmentService.updateDate(apptToUpdate.getApptId(), apptDate);

		assertEquals(apptDate, apptToUpdate.getApptDate());
	}

	@Test
	public void testUpdateDescription() throws Exception {
		appointmentService.newAppointment("Appointment with Description");
		Appointment apptToUpdate = appointmentService.getApptList().get(0);

		String newDescription = "Updated appointment description.";
		appointmentService.updateDescription(apptToUpdate.getApptId(), newDescription);

		Appointment updatedAppt = appointmentService.searchForAppt(apptToUpdate.getApptId());
		assertEquals(newDescription, updatedAppt.getApptDescription());
	}

	@Test
	public void testSearchForApptWithExistingAppt() throws Exception {
		appointmentService.newAppointment("Existing appt");
		Appointment existingAppt = appointmentService.getApptList().get(0);

		Appointment foundAppt = appointmentService.searchForAppt(existingAppt.getApptId());

		assertNotNull(foundAppt);
		assertEquals(existingAppt.getApptId(), foundAppt.getApptId());
	}

	@Test
	public void testSearchForTaskWithNonExistingTask() {
		String nonExistingApptId = "1234567890"; // Random non-existing task ID

		assertThrows(Exception.class, () -> appointmentService.searchForAppt(nonExistingApptId));
	}

}
