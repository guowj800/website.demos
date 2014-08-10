package website.demos.persistence.entities.enums;

public enum EAccountType {
	ADMIN(1, "Admin"), USER(2, "User");

	private int index;
	private String description;

	private EAccountType(int index, String description) {
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
}
