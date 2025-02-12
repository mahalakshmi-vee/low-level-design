package com.practice.logging_framework_system;

public class ConsoleLogAppender implements LogAppender {
	@Override
	public void append(LogMessage logMessage) {
		System.out.println(logMessage);
	}
}
