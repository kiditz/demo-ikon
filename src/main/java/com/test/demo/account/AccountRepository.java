package com.test.demo.account;

import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<Account, Long> {
}
