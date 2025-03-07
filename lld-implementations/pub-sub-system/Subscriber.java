package com.practice.pub_sub_system;

public interface Subscriber {
	void onMessage(Message message);
}
