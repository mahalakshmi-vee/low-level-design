package com.practice.logging_framework_system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class FileLogAppender implements LogAppender {
	private String fileNamePrefix;
	private String parentDirectoryPath;
	private RotationPolicy rotationPolicy;
	private int maxFileSize; // Applicable if file SIZE_BASED rotation policy is enabled
	private LocalDateTime lastRotationTime = LocalDateTime.now().minusDays(1);
	private File currentLogFile;
	private FileWriter fileWriter;

	public FileLogAppender(String fileNamePrefix, String parentDirectoryPath, RotationPolicy rotationPolicy) {
		this.fileNamePrefix = fileNamePrefix;
		this.parentDirectoryPath = parentDirectoryPath;
		this.rotationPolicy = rotationPolicy;
	}

	public FileLogAppender(String fileNamePrefix, String parentDirectoryPath, RotationPolicy rotationPolicy,
			int maxFileSize) {
		this.fileNamePrefix = fileNamePrefix;
		this.parentDirectoryPath = parentDirectoryPath;
		this.rotationPolicy = rotationPolicy;
		this.maxFileSize = maxFileSize;
	}

	@Override
	public void append(LogMessage logMessage) {
		try {
			if (shouldRotate()) {
				createLogFile();
			}
			fileWriter.write(logMessage.toString() + "\n");
			fileWriter.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private boolean shouldRotate() {
		if (rotationPolicy == RotationPolicy.SIZE_BASED) {
			if (currentLogFile.length() > maxFileSize) {
				lastRotationTime = LocalDateTime.now();
				return true;
			}
		} else if (rotationPolicy == RotationPolicy.DAILY) {
			if (!LocalDateTime.now().toLocalDate().equals(lastRotationTime.toLocalDate())) {
				lastRotationTime = LocalDateTime.now();
				return true;
			}
		}
		return false;
	}

	private void createLogFile() {
		try {
			if (fileWriter != null) {
				fileWriter.close();
			}
			File parentDirectory = new File(parentDirectoryPath);
			if (!parentDirectory.exists()) {
				parentDirectory.mkdir();
			}
			currentLogFile = new File(parentDirectory,
					fileNamePrefix + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".log");
			fileWriter = new FileWriter(currentLogFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
