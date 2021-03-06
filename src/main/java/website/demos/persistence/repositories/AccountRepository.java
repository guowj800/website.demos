package website.demos.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import website.demos.persistence.entities.Account;

@Transactional
@Repository
public class AccountRepository extends GeneralRepository<Account> {

	public Account getAccountByLoginId(final String loginId) {
		String queryString = "from Account account where account.loginId = '" + loginId + "'";
		List<Account> result = this.query(queryString);
		if(result.isEmpty())
			return null;
		else
			return result.get(0);
	}
	
	public List<Account> getAllAccounts() {
		String queryString = "from Account account";
		return this.query(queryString);
	}
	
	@Override
	protected Class<Account> getEntityType() {
		// TODO Auto-generated method stub
		return Account.class;
	}

}
