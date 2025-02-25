package com.test.demo.account;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
class AccountQueryService {
	private final AccountRepository repository;
	private final AccountMapper mapper;

	public Page<AccountDTO> getAccounts(Pageable pageable) {
		return repository.findAll(pageable).map(mapper::toDto);
	}

	public Optional<AccountDTO> findById(Long id) {
		return repository.findById(id).map(mapper::toDto);
	}
}