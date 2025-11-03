package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.generics.user.UserMobilePhoneNumberDoesNotExistsRule;
import co.edu.uco.nose.business.business.validator.Validator;

public class ValidateUserMobilePhoneDoesNotExists implements Validator {
	
	private static final Validator instance = new ValidateUserMobilePhoneDoesNotExists();
	
	private ValidateUserMobilePhoneDoesNotExists() {
		
	}
	
	public static void executeValidation(final Object... data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		
		UserMobilePhoneNumberDoesNotExistsRule.executeRule(data);
		
	}

}
