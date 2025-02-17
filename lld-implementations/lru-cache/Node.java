package com.practice.lru_cache;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
	private int key;
	private int value;
	private Node next;
	private Node previous;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.previous = null;
	}
}
