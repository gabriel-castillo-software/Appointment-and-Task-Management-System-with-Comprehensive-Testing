package softwareAutomation_Junit;

import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

	private final List<Appointment> apptList = new ArrayList<>();

	private String newUniqueApptId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));

	}

	public Appointment searchForAppt(String id) throws Exception {

		int index = 0;

		while (index < apptList.size()) {
			if (id.equals(apptList.get(index).getApptId())) {
				return apptList.get(index);
			}
			index++;
		}
		throw new Exception("The appointment does not exist!");
	}

	public void newAppointment() {
		Appointment appt = new Appointment(newUniqueApptId());
		apptList.add(appt);
	}

	public void newAppointment(String Id) {
		Appointment appt = new Appointment(newUniqueApptId());
		apptList.add(appt);
	}

	public void newAppointment(ZonedDateTime date) {
		Appointment appt = new Appointment(newUniqueApptId(), date);
		apptList.add(appt);
	}

	public void newAppointment(ZonedDateTime date, String description) {
		Appointment appt = new Appointment(newUniqueApptId(), date, description);
		apptList.add(appt);
	}

	public void deleteAppt(String id) throws Exception {
		apptList.remove(searchForAppt(id));
	}

	public void updateDate(String id, ZonedDateTime date) throws Exception {
		searchForAppt(id).setApptDate(date);
	}

	public void updateDescription(String id, String description) throws Exception {
		searchForAppt(id).setApptDescription(description);
	}

	public List<Appointment> getApptList() {
		return apptList;
	}

}
