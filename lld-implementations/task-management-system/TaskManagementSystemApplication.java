package com.practice.task_management_system;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);

		// Create users
		User maha = new User("1", "Maha", "maha@gmail.com");
		User debina = new User("2", "Debina", "debina@gmail.com");
		User divisha = new User("3", "Divisha", "divisha@gmail.com");
		User liana = new User("4", "Liana", "liana@gmail.com");

		// Create tasks
		Task task1 = new Task("1", "Task 1", "Description 1", LocalDateTime.now(), 1, maha);
		Task task2 = new Task("2", "Task 2", "Description 2", LocalDateTime.now(), 2, debina);
		Task task3 = new Task("3", "Task 3", "Description 3", LocalDateTime.now(), 3, divisha);
		Task task4 = new Task("4", "Task 4", "Description 4", LocalDateTime.now(), 3, liana);

		TaskManager taskManager = TaskManager.getInstance();

		// Add tasks to the task manager
		taskManager.createTask(task1);
		taskManager.createTask(task2);
		taskManager.createTask(task3);
		taskManager.createTask(task4);

		// Update a task
		task1.setDescription("Updated Description 1");
		taskManager.updateTask(task1);

		// Search tasks
		List<Task> searchResult = taskManager.searchTasks("Task");
		System.out.println("Search Results:");
		for (Task task : searchResult) {
			System.out.println(task.getTitle());
		}

		// Filter tasks
		List<Task> filteredTask = taskManager.filterTasks(TaskStatus.PENDING, 1, LocalDateTime.now().minusDays(2),
				LocalDateTime.now());
		System.out.println("Filtered Tasks:");
		for (Task task : filteredTask) {
			System.out.println(task.getTitle());
		}

		// Mark a task as completed
		taskManager.markTaskAsCompleted("1");

		// Get task history for a user
		List<Task> taskHistory = taskManager.getTaskHistory(maha);
		System.out.println("Task History for " + maha.getName() + ":");
		for (Task task : taskHistory) {
			System.out.println(task.getTitle());
		}

		// Delete a task
		taskManager.deleteTask("3");
	}

}
