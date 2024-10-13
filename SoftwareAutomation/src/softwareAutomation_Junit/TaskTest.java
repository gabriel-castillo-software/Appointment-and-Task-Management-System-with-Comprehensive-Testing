package softwareAutomation_Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testDefaultConstructor() {
		Task task = new Task();
		assertEquals("INITIAL", task.getTaskId());
		assertEquals("INITIAL", task.getName());
		assertEquals("INITIAL DESCRIPTION", task.getDescription());
	}

	@Test
	void testTaskIdConstructor() {
		Task task = new Task("TASK1");
		assertEquals("TASK1", task.getTaskId());
		assertEquals("INITIAL", task.getName());
		assertEquals("INITIAL DESCRIPTION", task.getDescription());
	}

	@Test
	void testTaskIdAndNameConstructor() {
		Task task = new Task("TASK1", "Task 1");
		assertEquals("TASK1", task.getTaskId());
		assertEquals("Task 1", task.getName());
		assertEquals("INITIAL DESCRIPTION", task.getDescription());
	}

	@Test
	void testFullConstructor() {
		Task task = new Task("TASK1", "Task 1", "This is a task description");
		assertEquals("TASK1", task.getTaskId());
		assertEquals("Task 1", task.getName());
		assertEquals("This is a task description", task.getDescription());
	}

	@Test
	void testNameValidation() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("TASK1", "This is a long task name that exceeds 20 characters");
		});
	}

	@Test
	void testDescriptionValidation() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("TASK1", "Task 1", "This is a long task description that exceeds 50 characters. "
					+ "This is a long task description that exceeds 50 characters. This is a long task description that exceeds 50 characters.");
		});
	}

	@Test
	void testTaskIdValidation() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ThisTaskIdIsTooLong");
		});
	}
}
