package website.demos.service.enums;

public enum ELoginStatus {

	INVALID_LOGIN_ID(1, "Invalid Login Id or Password"), INVALID_PASSWORD(2, "Invalid Login Id or Password"), VALID_LOGIN_INFO(3, "Success");

	private int index;
	private String description;

	private ELoginStatus(int index) {
		this.setIndex(index);
	}

	private ELoginStatus(int index, String description) {
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
