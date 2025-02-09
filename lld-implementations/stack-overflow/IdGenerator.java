package com.practice.stack_overflow_system;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
	private static final AtomicLong counter = new AtomicLong(1);

	public static long generateId() {
		return counter.getAndIncrement(); // Thread-safe increment.
	}
}
