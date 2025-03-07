package com.practice.hotel_management_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Guest {
	private final String id;
	private String name;
	private String phoneNumber;
	private String email;
}
