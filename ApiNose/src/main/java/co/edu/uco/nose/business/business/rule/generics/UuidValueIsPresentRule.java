package co.edu.uco.nose.business.business.rule.generics;

import java.util.UUID;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public final class UuidValueIsPresentRule implements Rule {
	
	private static final Rule instance = new UuidValueIsPresentRule();
	
	private UuidValueIsPresentRule() {
		
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
		
		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_STRING_LENGTH_IS_PRESENT.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		var uuidData = (UUID) data[0];
		var dataName = (String) data[1];
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(uuidData)) {
			var userMessage= MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage= MessagesEnum.TECHNICAL_ERROR_UUID_IS_DEFAULT.getContent() + dataName;

			throw NoseException.create(userMessage, technicalMessage);
	}
		
	}
}
