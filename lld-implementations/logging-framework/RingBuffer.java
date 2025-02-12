package com.practice.logging_framework_system;

/*
 * RingBuffer is a fixed size circular queue used for log buffering.
 * It follows a FIFO strategy and overwrite the oldest entry when full.
 */
public class RingBuffer {
	private int capacity;
	private Object[] buffer;
	private int size;
	private int head = 0;
	private int tail = -1;

	public RingBuffer(int capacity) {
		this.capacity = capacity;
		buffer = new Object[capacity];
	}

	public synchronized void add(Object item) {
		if (isFull()) {
			tail = (tail + 1) % capacity; // Overwrite oldest content
		} else {
			tail = tail + 1;
			size++;
		}

		buffer[tail] = item;
	}

	public synchronized Object remove() {
		if (isEmpty()) {
			return null;
		}
		Object item = buffer[head];
		head = (head + 1) % capacity;
		size--;
		return item;
	}

	private boolean isFull() {
		return size == capacity;
	}

	private boolean isEmpty() {
		return size == 0;
	}
}
