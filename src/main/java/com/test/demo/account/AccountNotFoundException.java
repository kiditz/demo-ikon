package com.test.demo.account;

public class AccountNotFoundException extends RuntimeException {

	AccountNotFoundException() {
		super("Account not found");
	}
}
