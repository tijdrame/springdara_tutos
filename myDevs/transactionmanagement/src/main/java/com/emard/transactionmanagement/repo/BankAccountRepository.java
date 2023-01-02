package com.emard.transactionmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    
}
