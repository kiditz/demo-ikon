package com.test.demo.account;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {
	private final AccountRepository repository;

	@PostMapping
	public Account save(@RequestBody Account account){
		return repository.save(account);
	}

	@PatchMapping("{id}")
	public Account save(int id,@RequestBody Account account){
		var existingAccount = repository.findById(id).orElseThrow();
		existingAccount.account = account.account;
		return repository.save(existingAccount);
	}

	@GetMapping
	public Iterable<Account> getAccounts(){
		return repository.findAll();
	}

	@DeleteMapping("{id}")
	public void deleteAccount(@PathVariable int id){
		repository.deleteById(id);
	}

}
