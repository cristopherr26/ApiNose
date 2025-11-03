package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.generics.user.UserEmailDoesNotExistsRule;
import co.edu.uco.nose.business.business.validator.Validator;

public class ValidateUserEmailDoesNotExists implements Validator {
	
	private static final Validator instance = new ValidateUserEmailDoesNotExists();
	
	private ValidateUserEmailDoesNotExists() {
		
	}
	
	public static void executeValidation(final Object... data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		
		UserEmailDoesNotExistsRule.executeRule(data);
	}

}
