package website.demos.common.exceptions;

import org.apache.commons.lang.StringUtils;


public class CommonSystemException extends Exception {

	/*
	 * Fields
	 */

	private static final long serialVersionUID = 1L;
	protected String errorMessage;

	/*
	 * Properties
	 */

	public CommonSystemException(String errorMessage) {
		this.setErrorMessage(errorMessage);
	}

	public CommonSystemException(String errorMessage, Exception ex) {
		super(ex);
		this.setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	/*
	 * Constructors
	 */

	@Override
	public String getMessage() {
		if (StringUtils.isBlank(this.errorMessage)) {
			return super.getMessage();
		} else {
			return this.errorMessage;
		}
	}

	protected void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
