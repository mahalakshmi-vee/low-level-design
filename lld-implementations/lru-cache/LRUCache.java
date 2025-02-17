package com.practice.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private int currentCapacity = 0;
	private int actualCapacity = 0;
	private Map<Integer, Node> cacheItems;
	private Node head;
	private Node tail;

	public LRUCache(int capacity) {
		this.actualCapacity = capacity;
		cacheItems = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.setNext(tail);
		tail.setPrevious(head);
	}

	public int get(int key) {
		if (!cacheItems.containsKey(key))
			return -1;

		Node node = cacheItems.get(key);
		int value = node.getValue();
		deleteNode(node);
		addNode(node);
		cacheItems.put(key, tail.getPrevious());
		return value;
	}

	public void put(int key, int value) {
		if (cacheItems.containsKey(key)) {
			Node existingNode = cacheItems.get(key);
			deleteNode(existingNode);
			existingNode.setValue(value);
			addNode(existingNode);
			cacheItems.put(key, tail.getPrevious());
		} else if (currentCapacity >= actualCapacity) {
			Node deleteNode = head.getNext();
			deleteNode(deleteNode);
			cacheItems.remove(deleteNode.getKey());
			Node newNode = new Node(key, value);
			addNode(newNode);
			cacheItems.put(key, tail.getPrevious());
		} else {
			Node newNode = new Node(key, value);
			addNode(newNode);
			cacheItems.put(key, tail.getPrevious());
			currentCapacity++;
		}
	}

	public void deleteNode(Node deleteNode) {
		Node deleteNodePrevious = deleteNode.getPrevious();
		Node deleteNodeNext = deleteNode.getNext();
		deleteNodePrevious.setNext(deleteNodeNext);
		deleteNodeNext.setPrevious(deleteNodePrevious);
	}

	public void addNode(Node newNode) {
		Node tailPrevious = tail.getPrevious();
		tailPrevious.setNext(newNode);
		newNode.setPrevious(tailPrevious);
		newNode.setNext(tail);
		tail.setPrevious(newNode);
	}
}
