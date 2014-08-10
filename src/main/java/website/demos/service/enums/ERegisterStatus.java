package website.demos.service.enums;

public enum ERegisterStatus {

	INVALID_LOGIN_ID(1, "Login Id is existed"), INVALID_PASSWORD(2, "Password must not be null"), VALID_REGISTER_INFO(3, "Success");

	private int index;
	private String description;

	private ERegisterStatus(int index) {
		this.setIndex(index);
	}

	private ERegisterStatus(int index, String description) {
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
