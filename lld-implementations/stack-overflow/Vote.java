package com.practice.stack_overflow_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Vote {
	private final User user;
	private final int value;
}
