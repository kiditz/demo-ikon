package com.test.demo.account;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
class AccountCommandService {
	private final AccountRepository repository;
	private final AccountMapper mapper;

	@CacheEvict(value = {"accounts", "accountsPage"}, allEntries = true)
	AccountDTO create(CreateAccountCommand command) {
		var account = mapper.fromCreateCommand(command);
		return mapper.toDto(repository.save(account));
	}

	@Caching(evict = {
			@CacheEvict(value = {"accounts"}, key = "#command.id"),
			@CacheEvict(value = "accountsPage", allEntries = true)
	})
	AccountDTO update(UpdateAccountCommand command) {
		var account = repository.findById(command.getId())
				.orElseThrow(AccountNotFoundException::new);
		mapper.update(account, command);
		return mapper.toDto(repository.save(account));
	}

	@Caching(evict = {
			@CacheEvict(value = {"accounts"}, key = "#id"),
			@CacheEvict(value = "accountsPage", allEntries = true)
	})
	void delete(Long id) {
		repository.deleteById(id);
	}
}
