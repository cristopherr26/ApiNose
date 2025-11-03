package co.edu.uco.nose.business.business.validator.city;

import co.edu.uco.nose.business.business.rule.generics.city.CityExistsByIdRule;
import co.edu.uco.nose.business.business.validator.Validator;

public class ValidateCityExistsById implements Validator {
	
	private static final Validator instance = new ValidateCityExistsById();
	
	private ValidateCityExistsById() {
		
	}
	
	public static void executeValidation(final Object... data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		
		CityExistsByIdRule.executeRule(data);
		
	}

}
