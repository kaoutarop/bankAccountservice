package com.example.bank_account_service;

import com.example.bank_account_service.entities.BankAccount;
import com.example.bank_account_service.enums.AccountType;
import com.example.bank_account_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);

	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for(int i=1;i<10;i++)
			{
				BankAccount bankAccount=BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENCY_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(10000+ Math.random()*90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}



}
