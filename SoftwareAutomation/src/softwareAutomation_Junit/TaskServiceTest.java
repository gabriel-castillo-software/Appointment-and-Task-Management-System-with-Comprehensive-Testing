package softwareAutomation_Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	private TaskService taskService;

	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
	}

	@Test
	public void testTask() {
		taskService.newTask();
		taskService.newTask("Task 1");
		taskService.newTask("Task 2", "Description for Task 2");

		List<Task> taskList = taskService.getTaskList();

		assertEquals(3, taskList.size());
	}

	@Test
	public void testDeleteTask() throws Exception {
		taskService.newTask("Task to be deleted");
		Task taskToDelete = taskService.getTaskList().get(0);

		taskService.deleteTask(taskToDelete.getTaskId());

		assertTrue(taskService.getTaskList().isEmpty());
	}

	@Test
	public void testUpdateName() throws Exception {
		taskService.newTask("Original Task");
		Task taskToUpdate = taskService.getTaskList().get(0);

		String newName = "Updated Task";
		taskService.updateName(taskToUpdate.getTaskId(), newName);

		assertEquals(newName, taskToUpdate.getName());
	}

	@Test
	public void testUpdateDescription() throws Exception {
		taskService.newTask("Task with Desc");
		Task taskToUpdate = taskService.getTaskList().get(0);

		String newDescription = "Updated task description.";
		taskService.updateDescription(taskToUpdate.getTaskId(), newDescription);

		Task updatedTask = taskService.searchForTask(taskToUpdate.getTaskId());
		assertEquals(newDescription, updatedTask.getDescription());
	}

	@Test
	public void testSearchForTaskWithExistingTask() throws Exception {
		taskService.newTask("Existing Task");
		Task existingTask = taskService.getTaskList().get(0);

		Task foundTask = taskService.searchForTask(existingTask.getTaskId());

		assertNotNull(foundTask);
		assertEquals(existingTask.getTaskId(), foundTask.getTaskId());
	}

	@Test
	public void testSearchForTaskWithNonExistingTask() {
		String nonExistingTaskId = "1234567890"; // Random non-existing task ID

		assertThrows(Exception.class, () -> taskService.searchForTask(nonExistingTaskId));
	}

}
