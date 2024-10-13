package softwareAutomation_Junit;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class Appointment {

	private String apptId;
	private ZonedDateTime apptDate;
	private String apptDescription;

	public Appointment() {
		apptId = "INITIAL";

		this.apptDate = ZonedDateTime.now(ZoneId.systemDefault());

		apptDescription = "INITIAL DESCRIPTION";
	}

	public Appointment(String apptId) {
		checkApptId(apptId);
	}

	public Appointment(String apptId, ZonedDateTime date) {
		checkApptId(apptId);

		if (date.isBefore(ZonedDateTime.now(ZoneId.systemDefault()))) {

			throw new IllegalArgumentException("Appointment date can't be in the past.");
		}

		this.apptDate = date;

	}

	public Appointment(String apptId, ZonedDateTime date, String desc) {

		checkApptId(apptId);

		this.apptDate = date;

		setApptDescription(desc);
	}

	public String getApptId() {
		return apptId;
	}

	public ZonedDateTime getApptDate() {
		return apptDate;
	}

	public String getApptDescription() {
		return apptDescription;
	}

	private void checkApptId(String apptId) {
		if (apptId == null || apptId.length() > 10) {
			throw new IllegalArgumentException("Error: The task ID was null or longer than 10 characters");
		} else {
			this.apptId = apptId;
		}
	}

	public void setApptDate(ZonedDateTime apptDate) {
		this.apptDate = apptDate;
	}

	public void setApptDescription(String apptDescription) {
		if (apptDescription == null || apptDescription.length() > 50) {
			throw new IllegalArgumentException(
					"Task description is invalid. Ensure it is shorter than 50 characters and not empty.");
		} else {
			this.apptDescription = apptDescription;
		}
	}
}
