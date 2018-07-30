package com.app.passwordmanager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

class AccountToPasswordTransformer {
	private final Account account;
	private static final String allowedSymbols =
			"0123456789"
			+"abcdefghijklmnopqrstuvwxyz"
			+"ABCDEFGHIJKLMNOPQRSTUWXYZ"
			+".,!?#$%^&*()+-/:;<=>{}[]~";


	AccountToPasswordTransformer(Account account) {
		this.account = account;
	}

	String password() throws Exception {
		return hashToPassword(hash());
	}

	private String hashToPassword (String hash){
		//TODO represent hash as string of allowed symbols specified length
		//System.out.println(hash);

		return hash;
	}

	private String hash() throws Exception {
		var bytes = account.toString().getBytes(StandardCharsets.UTF_8);
		return java.util.Base64.getEncoder().encodeToString((MessageDigest.getInstance("SHA-256").digest(bytes)));
	}
}








