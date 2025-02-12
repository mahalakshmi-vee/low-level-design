package com.practice.task_management_system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {
	private static TaskManager instance;
	private Map<String, Task> tasks;
	private Map<String, List<Task>> userTasks;

	private TaskManager() {
		tasks = new ConcurrentHashMap<>();
		userTasks = new ConcurrentHashMap<>();
	}

	public static TaskManager getInstance() {
		if (instance != null)
			return instance;

		instance = new TaskManager();
		return instance;
	}

	public void createTask(Task task) {
		if (tasks.containsKey(task.getId())) {
			System.out.println("Task already exists!");
			return;
		}

		tasks.put(task.getId(), task);
		assignTaskToUser(task.getAssignedUser(), task);
	}

	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			System.out.println("Task not found. Please verify the task ID.");
			return;
		}

		Task task = tasks.get(taskId);
		tasks.remove(taskId);
		unassignTaskFromUser(task.getAssignedUser(), task);
		System.out.println("Task deleted successfully");
	}

	public void updateTask(Task updatedTask) {
		if (!tasks.containsKey(updatedTask.getId())) {
			System.out.println("Task not found. Please verify the task ID");
			return;
		}
		Task existingTask = tasks.get(updatedTask.getId());
		synchronized (existingTask) {
			existingTask.setTitle(updatedTask.getTitle());
			existingTask.setDescription(updatedTask.getDescription());
			existingTask.setDueDate(updatedTask.getDueDate());
			existingTask.setPriority(updatedTask.getPriority());
			existingTask.setTaskStatus(updatedTask.getTaskStatus());
			User newUser = updatedTask.getAssignedUser();
			if (!newUser.equals(existingTask.getAssignedUser())) {
				unassignTaskFromUser(existingTask.getAssignedUser(), existingTask);
				assignTaskToUser(newUser, existingTask);
			}
		}
	}

	private void assignTaskToUser(User user, Task task) {
		if (!userTasks.containsKey(user.getId())) {
			List<Task> listTask = new ArrayList<>();
			listTask.add(task);
			userTasks.put(user.getId(), listTask);
			return;
		}
		List<Task> listTask = userTasks.get(user.getId());
		listTask.add(task);
	}

	private void unassignTaskFromUser(User user, Task task) {
		List<Task> listTask = userTasks.get(user.getId());
		listTask.remove(task);
	}

	public List<Task> getTaskHistory(User user) {
		if (!userTasks.containsKey(user.getId())) {
			System.out.println("No task history found for this user: " + user.getName());
			return null;
		}
		List<Task> listTaskHistory = userTasks.get(user.getId());
		return listTaskHistory;
	}

	public void markTaskAsCompleted(String taskId) {
		Task task = tasks.get(taskId);
		if (task != null) {
			synchronized (task) {
				task.setTaskStatus(TaskStatus.COMPLETED);
			}
		}
	}

	public List<Task> filterTasks(TaskStatus taskStatus, int priority, LocalDateTime startDate, LocalDateTime endDate) {
		List<Task> filteredTasks = new ArrayList<>();
		for (Task task : tasks.values()) {
			if (task.getTaskStatus() == taskStatus && task.getPriority() == priority
					&& task.getDueDate().compareTo(startDate) > 0 && task.getDueDate().compareTo(endDate) < 0) {
				filteredTasks.add(task);
			}
		}
		return filteredTasks;
	}

	public List<Task> searchTasks(String keyword) {
		List<Task> matchingTasks = new ArrayList<>();
		for (Task task : tasks.values()) {
			if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
				matchingTasks.add(task);
			}
		}
		return matchingTasks;
	}
}
