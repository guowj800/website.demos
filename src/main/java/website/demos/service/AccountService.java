package website.demos.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.demos.common.global.GlobalConstants;
import website.demos.persistence.entities.Account;
import website.demos.persistence.repositories.AccountRepository;
import website.demos.service.enums.EAccountService;
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
	
	//verify if the loginId is exist
	public boolean isLoginIdExisted(String loginId){
		Account account = accountRepository.getAccountByLoginId(loginId);
		if(account != null)
			return true;
		else
			return false;
	}
	
	//login
	public EAccountService varifyLoginInfo(String loginId, String password) {
		Account account = accountRepository.getAccountByLoginId(loginId);
		if (account == null) {
			return EAccountService.INVALID_LOGIN_ID;
		}

		if (!account.getPassword().equals(password)) {
			return EAccountService.INVALID_PASSWORD;
		} else {
			return EAccountService.VALID_LOGIN_INFO;
		}
	}

	//register (persist new account)
	public EAccountService register(Account account){
		if(isLoginIdExisted(account.getLoginId()))
			return EAccountService.LOGIN_ID_EXIST;
		if (StringUtils.isBlank(account.getPassword())) {
			return EAccountService.PASSWORD_IS_NULL;
		} else {
			accountRepository.save(account);
			return EAccountService.VALID_REGISTER_INFO;
		}
	}

	protected void varifyAccount(Account account) throws CommonServiceException {
		if (StringUtils.isBlank(account.getLoginId())) {
			throw new CommonServiceException("Account ID must be specified!");
		}
		if (StringUtils.isBlank(account.getPassword())) {
			throw new CommonServiceException("Password must be specified!");
		}
	}


	
	//verify if the user is login
	public boolean isLogin(HttpSession session){
		if(session.getAttribute(GlobalConstants.SESSION_ACCOUNT_ID) != null)
			return true;
		else
			return false;
	}
	
	//verify login status
	public EAccountService verifyAccountStatus(HttpSession session){
		if(isLogin(session))
			return EAccountService.IS_LOGIN;
		else
			return EAccountService.NOT_LOGIN;
	}
	
	public EAccountService updateAccount(Account account, HttpSession session){
		if(verifyAccountStatus(session) == EAccountService.IS_LOGIN){
			accountRepository.update(account);
			return EAccountService.UPDATE_SUCCESS;
		}
		else
			return EAccountService.NOT_LOGIN;
	}
}
