package com.test.demo.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AccountCommandService {
	private final AccountRepository repository;
	private final AccountMapper mapper;

	AccountDTO create(CreateAccountCommand command) {
		var account = mapper.fromCreateCommand(command);
		return mapper.toDto(repository.save(account));
	}

	AccountDTO update(UpdateAccountCommand command) {
		var account = repository.findById(command.getId())
				.orElseThrow(AccountNotFoundException::new);
		mapper.update(account, command);
		return mapper.toDto(repository.save(account));
	}

	void delete(Long id) {
		repository.deleteById(id);
	}
}
