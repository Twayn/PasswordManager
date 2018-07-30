package com.app.passwordmanager;

public class Account {
	private final String name;
	private final String email;
	private final String password;

	public Account(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return name+email+password;
	}
}
