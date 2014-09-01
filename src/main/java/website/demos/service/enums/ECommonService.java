package website.demos.service.enums;

public enum ECommonService {

	SUCCESS(11, "Success");

	private int index;
	private String description;

	private ECommonService(int index) {
		this.setIndex(index);
	}

	private ECommonService(int index, String description) {
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
