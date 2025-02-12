package com.practice.logging_framework_system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class LogMessage {
	private String message;
	private LocalDateTime createdDateTime;
	private LogLevel logLevel;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss");

	public LogMessage(String message, LocalDateTime createdDateTime, LogLevel logLevel) {
		this.message = message;
		this.createdDateTime = createdDateTime;
		this.logLevel = logLevel;
	}

	@Override
	public String toString() {
		return "[" + logLevel + "] " + formatter.format(createdDateTime) + " " + message;
	}
}
