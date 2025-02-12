package com.practice.logging_framework_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingFrameworkSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoggingFrameworkSystemApplication.class, args);

//		SyncLogger syncLogger = SyncLogger.getInstance();
//		syncLogger.log(LogLevel.DEBUG, "Test Debug Message");
//		syncLogger.info("Test Info Message");
//		syncLogger.error("Test Error Message");
//		syncLogger.fatal("Test Fatal Message");

		AsyncLogger asyncLogger = AsyncLogger.getInstance();
		asyncLogger.log(LogLevel.DEBUG, "Test Debug Message");
		asyncLogger.info("Test Info Message");
		asyncLogger.error("Test Error Message");
		asyncLogger.fatal("Test Fatal Message");
	}
}
