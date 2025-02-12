package com.practice.logging_framework_system;

import java.time.LocalDateTime;

/*
 * AsyncLogger is a singleton logging class that asynchronously process log messages.
 * It uses a separate worker thread and a RingBuffer for non-blocking logging.
 * Supports different log appenders (console, file, database)
 */
public class AsyncLogger {
	private static AsyncLogger instance;
	private LoggerConfig loggerConfig;
	private RingBuffer ringBuffer; // Works in FIFO order
	private Thread workerThread;
	private boolean running = true;

	private AsyncLogger() {
		loggerConfig = new LoggerConfig(LogLevel.DEBUG, new FileLogAppender("application", "C:\\logs", RotationPolicy.DAILY), 20);
		ringBuffer = new RingBuffer(loggerConfig.getBufferSize());

		workerThread = new Thread(() -> processLogs());
		// workerThread.setDaemon(true); // Commenting for local testing purpose
		workerThread.start();
	}

	public static synchronized AsyncLogger getInstance() {
		if (instance != null)
			return instance;
		instance = new AsyncLogger();
		return instance;
	}

	/*
	 * Logs a message asynchronously by adding it to the ring buffer. 
	 * The log will be processed by the background worker thread.
	 */
	public void log(LogLevel logLevel, String message) {
		if (logLevel.ordinal() < loggerConfig.getLogLevel().ordinal()) {
			return;
		}
		LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), logLevel);
		ringBuffer.add(logMessage);
	}

	public void debug(String message) {
		log(LogLevel.DEBUG, message);
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

	public void processLogs() {
		while (running) {
			LogMessage logMessage = (LogMessage) ringBuffer.remove();
			if (logMessage != null) {
				loggerConfig.getLogAppender().append(logMessage);
			} else {
				try {
					Thread.sleep(1000); // Avoid CPU overutilization
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	public void shutdown() {
		running = false;
		workerThread.interrupt();
	}
}
