package com.practice.logging_framework_system;

import lombok.Getter;

@Getter
public class LoggerConfig {
	private LogLevel logLevel;
	private LogAppender logAppender;
	private int bufferSize;

	public LoggerConfig(LogLevel logLevel, LogAppender logAppender) {
		this.logLevel = logLevel;
		this.logAppender = logAppender;
	}

	public LoggerConfig(LogLevel logLevel, LogAppender logAppender, int bufferSize) {
		this.logLevel = logLevel;
		this.logAppender = logAppender;
		this.bufferSize = bufferSize;
	}
}
