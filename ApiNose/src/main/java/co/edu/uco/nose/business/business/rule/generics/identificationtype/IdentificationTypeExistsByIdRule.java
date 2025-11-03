package co.edu.uco.nose.business.business.rule.generics.identificationtype;

import java.util.UUID;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class IdentificationTypeExistsByIdRule implements Rule {
	
	private static final Rule instance = new IdentificationTypeExistsByIdRule();
	
	private IdentificationTypeExistsByIdRule() {
		
	}
	
	public static void executeRule(final Object... data) {
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_IDENTIFICATION_TYPE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_IDENTIFICATION_TYPE_LENGTH_VALUE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data [1];
		
		var idType = daoFactory.getIdentificationTypeDAO().findById(id);
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(idType.getId())) {
			var userMessage = MessagesEnum.USER_ERROR_IDENTIFICATION_TYPE_DOES_NOT_EXITS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATION_TYPE_DOES_NOT_EXITS.getContent() + id;
			throw NoseException.create(userMessage, technicalMessage);
		}
		
	}

}
