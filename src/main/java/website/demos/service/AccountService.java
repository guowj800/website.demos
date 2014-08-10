package website.demos.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.demos.persistence.entities.Account;
import website.demos.persistence.repositories.AccountRepository;
import website.demos.service.enums.ELoginStatus;
import website.demos.service.enums.ERegisterStatus;
import website.demos.service.exceptions.CommonServiceException;

@Service
public class AccountService {

	@Autowired
	@Resource
	private AccountRepository accountRepository;
	
	public Account getAccountByLoginId(String loginId) {
		return accountRepository.getAccountByLoginId(loginId);
	}

	public List<Account> getAllAccounts() {
		return accountRepository.getAllAccounts();
	}
	
	public void update(Account account){
		accountRepository.update(account);
	}
	
	public boolean isLoginIdExisted(String loginId){
		Account account = accountRepository.getAccountByLoginId(loginId);
		if(account != null)
			return true;
		else
			return false;
	}

	//register (persist new account)
	public ERegisterStatus register(Account account){
		if(isLoginIdExisted(account.getAccountId()))
			return ERegisterStatus.INVALID_LOGIN_ID;
		if (StringUtils.isBlank(account.getPassword())) {
			return ERegisterStatus.INVALID_PASSWORD;
		} else {
			accountRepository.save(account);
			return ERegisterStatus.VALID_REGISTER_INFO;
		}
	}

	protected void varifyAccount(Account account) throws CommonServiceException {
		if (StringUtils.isBlank(account.getAccountId())) {
			throw new CommonServiceException("Account ID must be specified!");
		}
		if (StringUtils.isBlank(account.getPassword())) {
			throw new CommonServiceException("Password must be specified!");
		}
	}

	//login
	public ELoginStatus varifyLoginInfo(String loginId, String password) {
		Account account = accountRepository.getAccountByLoginId(loginId);
		if (account == null) {
			return ELoginStatus.INVALID_LOGIN_ID;
		}

		if (!account.getPassword().equals(password)) {
			return ELoginStatus.INVALID_PASSWORD;
		} else {
			return ELoginStatus.VALID_LOGIN_INFO;
		}
	}
}
