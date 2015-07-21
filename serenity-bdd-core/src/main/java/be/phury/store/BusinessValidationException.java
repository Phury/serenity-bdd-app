package be.phury.store;

public class BusinessValidationException extends RuntimeException {

	public BusinessValidationException(String messageFormat, Object... messageArgs) {
		super(String.format(messageFormat, messageArgs));
	}

}
