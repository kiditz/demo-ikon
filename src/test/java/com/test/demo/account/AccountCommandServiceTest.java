package com.test.demo.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountCommandServiceTest {
	@Mock
	AccountRepository repository;
	@Mock
	AccountMapper mapper;

	@InjectMocks
	AccountCommandService service;

	private Account account;
	private AccountDTO accountDTO;

	@BeforeEach
	void setUp() {
		account = new Account(1L, "Rifky");
		accountDTO = new AccountDTO(1L, "Rifky");
	}

	@Test
	void createAccount_ShouldReturnDto() {
		var command = new CreateAccountCommand("Test Account");
		when(mapper.fromCreateCommand(command)).thenReturn(account);
		when(repository.save(account)).thenReturn(account);
		when(mapper.toDto(account)).thenReturn(accountDTO);
		var result = service.create(command);
		assertThat(account).isNotNull();
		assertThat(result).isEqualTo(accountDTO);
		verify(repository).save(account);
		verify(mapper).toDto(account);
	}

	@Test
	void updateAccount_ShouldThrowNotFoundException_WhenAccountNotFound() {
		var command = new UpdateAccountCommand(1L, "Test Account");
		when(repository.findById(command.getId())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> service.update(command))
				.isInstanceOf(AccountNotFoundException.class)
				.hasMessage("Account not found");
		verify(repository, never()).save(any());
	}

	@Test
	void updateAccount_ShouldReturnDto() {
		var command = new UpdateAccountCommand(1L, "Test Account");
		when(repository.findById(command.getId())).thenReturn(Optional.of(account));
		when(repository.save(account)).thenReturn(account);
		doNothing().when(mapper).update(account, command);
		when(mapper.toDto(account)).thenReturn(accountDTO);
		var result = service.update(command);
		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(accountDTO);
		verify(repository).save(account);
		verify(mapper).toDto(account);
	}

	@Test
	void deleteAccount_ShouldCallRepositoryDeleteById(){
		service.delete(1L);
		verify(repository).deleteById(1L);
	}
}