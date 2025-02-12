package com.practice.logging_framework_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogAppender implements LogAppender {
	private String jdbcUrl;
	private String username;
	private String password;
	private StringBuilder sqlQueryStrBuilder;

	public DatabaseLogAppender(String jdbcUrl, String username, String password) {
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;

		sqlQueryStrBuilder = new StringBuilder();
		sqlQueryStrBuilder.append("INSERT INTO logs (message, level, timestamp) VALUES (?,?,?)");
	}

	@Override
	public void append(LogMessage logMessage) {
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryStrBuilder.toString());
			preparedStatement.setString(1, logMessage.getMessage());
			preparedStatement.setString(2, logMessage.getLogLevel().name());
			preparedStatement.setString(3, logMessage.getFormatter().format(logMessage.getCreatedDateTime()));
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
