package com.test.demo.account;

import com.test.demo.setting.DefaultMapper;
import com.test.demo.setting.Mapping;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapper.class)
public interface AccountMapper extends Mapping<Account, AccountDTO, CreateAccountCommand, UpdateAccountCommand> {

}
