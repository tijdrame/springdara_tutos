package com.emard.transactionmanagement.service;

import org.springframework.stereotype.Service;

import com.emard.transactionmanagement.entities.BankAccount;
import com.emard.transactionmanagement.repo.BankAccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository repository;
    @Override
    public void transfer(Integer amount) {
        BankAccount obama = repository.findById(1L).get();
        obama.setBal(obama.getBal() - amount);
        repository.save(obama);

        BankAccount trump = repository.findById(2L).get();
        trump.setBal(trump.getBal() + amount);
        repository.save(trump);
    }
    
}
