package com.test.demo.account;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
class AccountQueryController {
	private final AccountQueryService service;

	@GetMapping
	public Page<AccountDTO> getAccounts(@PageableDefault(size = 10, page = 0, sort = "name") Pageable pageable) {
		return service.getAccounts(pageable);
	}

	@GetMapping("/{id}")
	public Optional<AccountDTO> findById(@PathVariable Long id) {
		return service.findById(id);
	}
}