package website.demos.service.enums;

public enum EAccountService {

	//for login
	INVALID_LOGIN_ID(11, "Invalid Login Id or Password"), INVALID_PASSWORD(12, "Invalid Login Id or Password"), VALID_LOGIN_INFO(13, "Success"),
	//for register
	LOGIN_ID_EXIST(21, "Login Id is existed"), PASSWORD_IS_NULL(22, "Password must not be null"), VALID_REGISTER_INFO(23, "Success"),
	//for account login status
	IS_LOGIN(31, "The account is login."), NOT_LOGIN(32, "Please login before operation!"),
	//for update account
	ACCOUNT_NOT_EXIST(41, "The account is not existed."), UPDATE_SUCCESS(23, "Success");

	private int index;
	private String description;

	private EAccountService(int index) {
		this.setIndex(index);
	}

	private EAccountService(int index, String description) {
		this.setIndex(index);
		this.setDescription(description);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.getDescription();
	}
}
