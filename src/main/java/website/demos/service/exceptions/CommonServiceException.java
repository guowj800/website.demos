package website.demos.service.exceptions;

import website.demos.common.exceptions.CommonSystemException;

public class CommonServiceException extends CommonSystemException {
	private static final long serialVersionUID = 1L;

	public CommonServiceException(String errorMessage) {
		super(errorMessage);
	}

	public CommonServiceException(String errorMessage, Exception ex) {
		super(errorMessage, ex);
	}
}
