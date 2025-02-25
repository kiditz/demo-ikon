package com.test.demo.account;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
public class AccountCommandController {
	private final AccountCommandService service;

	@PostMapping
	AccountDTO createAccount(@RequestBody CreateAccountCommand command) {
		return service.create(command);
	}

	@PutMapping
	AccountDTO updateAccount(@RequestBody UpdateAccountCommand command) {
		return service.update(command);
	}

	@DeleteMapping("{id}")
	void deleteAccount(@PathVariable Long id) {
		service.delete(id);
	}

}
