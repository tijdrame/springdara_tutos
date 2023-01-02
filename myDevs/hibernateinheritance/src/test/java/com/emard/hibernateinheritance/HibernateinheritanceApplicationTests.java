package com.emard.hibernateinheritance;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.hibernateinheritance.entites.Check;
import com.emard.hibernateinheritance.entites.CreditCard;
import com.emard.hibernateinheritance.entites.Payment;
import com.emard.hibernateinheritance.repo.PayementRepository;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	PayementRepository payementRepository;
	@Test
	void saveSingleTable() {
		CreditCard cc = new CreditCard();
		cc.setAmount(7500d);
		cc.setCreditCard("123456789");
		Check ch = new Check();
		ch.setAmount(2000d);
		ch.setCheckNumber("0987654321");
		payementRepository.saveAll(List.of(cc, ch));
	}

}
