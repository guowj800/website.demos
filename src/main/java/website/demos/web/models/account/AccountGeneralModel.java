package website.demos.web.models.account;

import org.codehaus.jackson.annotate.JsonIgnore;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.common.global.InstanceConverter;
import website.demos.persistence.entities.Account;

public class AccountGeneralModel extends Account {
	private static final long serialVersionUID = 1L;

	public AccountGeneralModel() {

	}

	public AccountGeneralModel(Account account) throws CommonSystemException {
		InstanceConverter.assignProperties(account, this);
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	@JsonIgnore
	public String getLoginId() {
		return super.getLoginId();
	}
}
