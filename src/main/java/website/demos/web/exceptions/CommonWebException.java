package website.demos.web.exceptions;

import website.demos.common.exceptions.CommonSystemException;

public class CommonWebException extends CommonSystemException {
	private static final long serialVersionUID = 1L;

	public CommonWebException(String errorMessage) {
		super(errorMessage);
	}

	public CommonWebException(String errorMessage, Exception ex) {
		super(errorMessage, ex);
	}
}
