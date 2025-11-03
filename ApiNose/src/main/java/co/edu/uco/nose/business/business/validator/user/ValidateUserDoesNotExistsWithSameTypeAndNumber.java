package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.generics.user.UserDoesNotExistsWithSameIdtypeAndNumberRule;
import co.edu.uco.nose.business.business.validator.Validator;

public class ValidateUserDoesNotExistsWithSameTypeAndNumber implements Validator{
	
	private static final Validator instance = new ValidateUserDoesNotExistsWithSameTypeAndNumber();
	
	private ValidateUserDoesNotExistsWithSameTypeAndNumber() {
		
	}
	
	public static void executeValidation(final Object... data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		
		UserDoesNotExistsWithSameIdtypeAndNumberRule.executeRule(data);
	}

}
