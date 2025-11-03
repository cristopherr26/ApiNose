package co.edu.uco.nose.business.business.rule.generics;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public final class StringLengthValueIsValidRule implements Rule {
	
	private static final Rule instance = new StringLengthValueIsValidRule();
	
	private StringLengthValueIsValidRule() {
		
	}
	
	public static void executeRule(final Object... data) {
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_STRING_LENGTH_VALUE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 5) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_LENGTH_VALUE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var minLength = (Integer) data[2];
		var maxLength = (Integer) data[3];
		boolean mustApplyTrim = (Boolean) data[4];
		
		if(!TextHelper.lengthIsValid(stringData, minLength, maxLength, mustApplyTrim)) {
				var userMessage= MessagesEnum.USER_ERROR_WRONG_LENGTH.getContent() + dataName + " " + minLength + " y " +  maxLength;
				var technicalMessage= MessagesEnum.TECHNICAL_ERROR_WRONG_LENGTH.getContent() + dataName + " " + minLength + " y " +  maxLength;

				throw NoseException.create(userMessage, technicalMessage);
		}
	}
		
}


