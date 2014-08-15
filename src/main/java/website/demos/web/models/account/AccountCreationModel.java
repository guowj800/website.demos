package website.demos.web.models.account;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.common.global.InstanceConverter;
import website.demos.persistence.entities.Account;



public class AccountCreationModel extends Account {
	private static final long serialVersionUID = 1L;

	public AccountCreationModel() {

	}

	public AccountCreationModel(Account account) throws CommonSystemException {
		InstanceConverter.assignProperties(account, this);
	}

	public Account getEntity() throws CommonSystemException {
		Account entity = new Account();
		return InstanceConverter.assignProperties(this, entity);
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	@JsonProperty
	public void setPassword(String password) {
		super.setPassword(password);
	}
}
