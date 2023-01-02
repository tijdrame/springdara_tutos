package com.emard.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.transactionmanagement.service.BankAccountService;

@SpringBootTest
class TransactionmanagementApplicationTests {

	@Autowired BankAccountService service;
	@Test
	void contextLoads() {
	}

	@Test
	void testTransfert(){
		service.transfer(200);
	}
}
