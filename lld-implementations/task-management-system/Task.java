package com.practice.task_management_system;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
	private final String id;
	private String title;
	private String description;
	private LocalDateTime dueDate;
	private int priority;
	private TaskStatus taskStatus;
	private final User assignedUser;

	public Task(String id, String title, String description, LocalDateTime dueDate, int priority, User assignedUser) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.assignedUser = assignedUser;
	}
}
