package com.example.elasticsearch;

import com.example.elasticsearch.entities.Bank;
import com.example.elasticsearch.entities.*;
import com.example.elasticsearch.repositories.AccountRepository;
import com.example.elasticsearch.repositories.BankRepository;
import com.example.elasticsearch.repositories.ClientRepository;
import com.example.elasticsearch.repositories.CurrencyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BankRepository bankRepository,
							 AccountRepository accountRepository,
							 ClientRepository clientRepository,
							 CurrencyRepository currencyRepository){
		return args -> {
			System.out.println(bankRepository.existsById("043601607"));

			bankRepository.deleteAll();
			clientRepository.deleteAll();
			currencyRepository.deleteAll();
			accountRepository.deleteAll();

			Client clientKalinin = new Client(UUID.randomUUID(), "Alexandr", "Kalinin");
			Client clientTyshkun = new Client(UUID.randomUUID(), "Andrew", "Tyshkun");
			Client clientVlasov = new Client(UUID.randomUUID(), "George", "Vlasov");
			Client clientKiseleva = new Client(UUID.randomUUID(), "Snezhana", "Kiseleva");

			Currency currencyRUB = new Currency(UUID.randomUUID(),"RUB");
			Currency currencyEUR = new Currency(UUID.randomUUID(),"EUR");

			Bank bankSamara = new Bank("043601607", "ПОВОЛЖСКИЙ БАНК ПАО СБЕРБАНК", "Самара");
			Bank bankMoscow = new Bank("044525225", "ПАО СБЕРБАНК", "Москва");
			Bank bankSaintPeterburg = new Bank("654367747", "СБЕРБАНК ЛЕНИНГРАД", "Санкт-Петербург");

			Account account1 = new Account("25632145874563225698", 2000, bankSamara, currencyRUB, clientKalinin);
			Account account2 = new Account("23659874123698563257", 1000000, bankMoscow, currencyEUR, clientTyshkun);

			System.out.printf("Client: %s has been saved %n", clientRepository.save(clientKalinin));
			System.out.printf("Client: %s has been saved %n", clientRepository.save(clientTyshkun));
			System.out.printf("Client: %s has been saved %n", clientRepository.save(clientVlasov));
			System.out.printf("Client: %s has been saved %n", clientRepository.save(clientKiseleva));

			System.out.printf("Currency: %s has been saved %n", currencyRepository.save(currencyRUB));
			System.out.printf("Currency: %s has been saved %n", currencyRepository.save(currencyRUB));

			System.out.printf("Bank: %s has been saved %n", bankRepository.save(bankSamara));
			System.out.printf("Bank: %s has been saved %n", bankRepository.save(bankMoscow));

			System.out.printf("Account: %s has been saved %n", accountRepository.save(account1));
			System.out.printf("Account: %s has been saved %n", accountRepository.save(account2));

			System.out.println("\nClients:");
			clientRepository.findAll().iterator().forEachRemaining(
					System.out::println
			);

			System.out.println("\nAccounts:");
			accountRepository.findAll().iterator().forEachRemaining(
					System.out::println
			);

			System.out.println("\nBanks:");
			bankRepository.findAll().iterator().forEachRemaining(
					System.out::println
			);

			System.out.println("\nCurrencies:");
			currencyRepository.findAll().iterator().forEachRemaining(
					System.out::println
			);

			Account retrievedAccount = accountRepository.findById("25632145874563225698").get();
			System.out.println("\nAccount with id: " + retrievedAccount.getId());
			System.out.println("Balance: " + retrievedAccount.getBalance());
			System.out.println("Bank name: " + retrievedAccount.getBank().getBankName());
			System.out.println("Bank city: " + retrievedAccount.getBank().getBankCity());
			System.out.println("Currency name: " + retrievedAccount.getCurrency().getNameCurrency());
			System.out.println("Client firstname: " + retrievedAccount.getClient().getFirstname());
			System.out.println("Client lastname: " + retrievedAccount.getClient().getFirstname());

			System.out.println("\nThis is list of client, but in other form...");
			List<Client> clientList = new ArrayList<>(clientRepository.findAll());
			for (Client clients: clientList) {
				System.out.println("Firstname: " + clients.getFirstname());
				System.out.println("Lastname: " + clients.getFirstname());
				System.out.println(" ");
			}

			//test query of spring data method
			bankRepository.findBankByBankCity("Санкт-Петербург").ifPresentOrElse(s -> {
				System.out.println(s + "already exists");
			}, () -> {
				System.out.println("Inserting bank: " + bankSaintPeterburg);
				bankRepository.insert(bankSaintPeterburg);
			});
		};

	}

}
