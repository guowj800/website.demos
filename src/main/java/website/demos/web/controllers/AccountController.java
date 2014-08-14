package website.demos.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.persistence.entities.Account;
import website.demos.service.AccountService;
import website.demos.service.enums.ELoginStatus;
import website.demos.service.enums.ERegisterStatus;
import website.demos.web.exceptions.CommonWebException;
import website.demos.web.models.account.AccountCreationModel;
import website.demos.web.models.account.AccountGeneralModel;


@Controller
@RequestMapping("account")
public class AccountController{

	@Autowired
	@Resource
	private AccountService accountService;


	/**
	 * Get account by its login id
	 * 
	 * @param loginId
	 * @return
	 * @throws CommonSystemException
	 */
	@RequestMapping("get-account-by-login-id")
	@ResponseBody
	public AccountGeneralModel getAccountByLoginId(String loginId) throws CommonSystemException{
		if (StringUtils.isBlank(loginId)) {
			throw new CommonWebException("Login Id can't be blank!");
		}
		Account acount = accountService.getAccountByLoginId(loginId);
		if (acount == null) {
			throw new CommonWebException("No account exists with login id specified!");
		}
		return new AccountGeneralModel(acount);
	}


	/**
	 * (To Be Invisible) Get all account information
	 * 
	 * @return
	 * @throws CommonSystemException
	 */
	@RequestMapping("get-all-accounts")
	@ResponseBody
	public List<AccountGeneralModel> getAllAccounts() throws CommonSystemException {
		List<AccountGeneralModel> models = new ArrayList<AccountGeneralModel>();
		for (Account account : accountService.getAllAccounts()) {
			models.add(new AccountGeneralModel(account));
		}
		return models;
	}


	/*
	 * Others
	 */

	/**
	 * Verify the login information, once login successfully there should be user information stored inside session
	 * 
	 * @param loginId
	 * @param clearPassword
	 * @return
	 * @throws CommonPortalException
	 */
	@RequestMapping(value="varify-login-info", method = RequestMethod.POST)
	@ResponseBody
	public String varifyLoginInfo(String loginId, String password, HttpSession session) throws CommonWebException {
		if (StringUtils.isBlank(loginId)) {
			throw new CommonWebException("Login Id can't be blank!");
		} else if (StringUtils.isBlank(password)) {
			throw new CommonWebException("Password can't be blank!");
		}
		String responseMessage = "";
		ELoginStatus loginStatus = accountService.varifyLoginInfo(loginId, password);
		switch (loginStatus) {
		case INVALID_LOGIN_ID: {
			responseMessage = loginStatus.getDescription();
		}
			break;
		case INVALID_PASSWORD: {
			responseMessage = loginStatus.getDescription();
		}
			break;
		default:
			Account account = accountService.getAccountByLoginId(loginId);
			if (account != null) {
				session.setAttribute("AccountId", account.getId());
				session.setAttribute("LoginId", account.getLoginId());
			}
			responseMessage = loginStatus.getDescription();
			break;
		}
		return responseMessage;
	}

	/*
	 * Create
	 */
	@RequestMapping(value="registor", method = RequestMethod.POST)
	@ResponseBody
	public String registor(AccountCreationModel accountCreationModel , HttpSession session) throws CommonSystemException{
		ERegisterStatus registorStatus = accountService.register(accountCreationModel.getEntity());
		return registorStatus.getDescription();
	}

	/*
	 * Merge
	 */
	
	/*
	 * Delete
	 */

}
