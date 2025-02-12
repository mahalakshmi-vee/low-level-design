package com.practice.logging_framework_system;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class SyncLogger {
	private static SyncLogger instance;
	private LoggerConfig loggerConfig;

	private SyncLogger() {
		loggerConfig = new LoggerConfig(LogLevel.DEBUG, new ConsoleLogAppender());
	}

	public static synchronized SyncLogger getInstance() {
		if (instance != null)
			return instance;
		instance = new SyncLogger();
		return instance;
	}

	public void log(LogLevel logLevel, String message) {
		if (logLevel.ordinal() < loggerConfig.getLogLevel().ordinal()) {
			return;
		}
		LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), logLevel);
		loggerConfig.getLogAppender().append(logMessage);
	}

	public void info(String message) {
		log(LogLevel.INFO, message);
	}

	public void warning(String message) {
		log(LogLevel.WARNING, message);
	}

	public void error(String message) {
		log(LogLevel.ERROR, message);
	}

	public void fatal(String message) {
		log(LogLevel.FATAL, message);
	}

	public void debug(String message) {
		log(LogLevel.DEBUG, message);
	}
}
