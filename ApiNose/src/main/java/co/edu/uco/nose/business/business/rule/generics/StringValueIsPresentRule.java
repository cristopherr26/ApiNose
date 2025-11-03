package co.edu.uco.nose.business.business.rule.generics;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;


public final class StringValueIsPresentRule implements Rule {
	
	private static final Rule instance = new StringValueIsPresentRule();
	
	private StringValueIsPresentRule() {
		
	}
	
	public static void executeRule(final Object... data) {
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 3) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_LENGTH_IS_PRESENT.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		boolean mustApplyTrim = (Boolean) data[2];
		
		if((mustApplyTrim)
			? TextHelper.isEmptyWithTrim(stringData)
					:TextHelper.isEmpty(stringData)) {
			var userMessage = MessagesEnum.USER_ERROR_INCOMPLETE_PARAMETERS.getContent() + dataName;
			var technicalMessage= MessagesEnum.TECHNICAL_ERROR_INCOMPLETE_PARAMETERS.getContent() + dataName;
			throw NoseException.create(userMessage, technicalMessage);
		}
		
	}

}
