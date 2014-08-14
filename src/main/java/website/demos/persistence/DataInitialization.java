package website.demos.persistence;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import website.demos.persistence.entities.Account;
import website.demos.persistence.repositories.AccountRepository;

public class DataInitialization {
	
	@Autowired
	@Resource
	AccountRepository accountRepository;

	@PostConstruct
	public void initialize() {
		// clearData();
		initialAccounts();
	}
	
	public void initialAccounts() {
		System.out.println("Data Init");
		
		Account jack = new Account();
		jack.setLoginId("jack");
		jack.setPassword("000000");
		jack.setName("Jack Zhang");
		
		accountRepository.save(jack);
		System.out.println(accountRepository.getAccountByLoginId("jack"));
	}
}
