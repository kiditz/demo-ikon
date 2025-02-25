package com.test.demo.account;

class AccountNotFoundException extends RuntimeException {

	AccountNotFoundException() {
		super("Account not found");
	}
}
