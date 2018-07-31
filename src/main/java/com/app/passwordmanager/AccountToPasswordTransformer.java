package com.app.passwordmanager;

import static java.lang.Math.abs;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class AccountToPasswordTransformer {
	private final Account account;
	private static final String ALLOWED_SYMBOLS =
			 "0123456789"
			+"abcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUWXYZ"
			+".,!?#$%^&*()+-/:;<=>{}[]~";
	private static final int LENGTH = ALLOWED_SYMBOLS.length() + 1;

	AccountToPasswordTransformer(Account account) {
		this.account = account;
	}

	String generatePassword(int length) throws NoSuchAlgorithmException {
		var password = new StringBuilder();
		var hash = hash(account.toString().getBytes(UTF_8));
		for (int i = 0; i < length; i++) {
			password.append(valueOf(hash));
			hash = hash(hash);
		}
		return password.toString();
	}

	private char valueOf(byte[] bytes){
		int sum = 0;
		for (byte b : bytes) sum = sum + abs(b);
		return ALLOWED_SYMBOLS.charAt(sum % LENGTH);
	}

	private byte[] hash(byte[] toHash) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance("SHA-256").digest(toHash);
	}
}








