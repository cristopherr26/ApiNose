package co.edu.uco.nose.business.business.rule.generics.user;

import java.util.UUID;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class UserExistsByIdRule implements Rule {
	
	private static final Rule instance = new UserExistsByIdRule();
	
	private UserExistsByIdRule() {
		
	}
	
	public static void executeRule (final Object... data) {
		
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_USER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data [1];
		
		var user = daoFactory.getUserDAO().findById(id);
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(user.getId())) {
			var userMessage = MessagesEnum.USER_ERROR_USER_DOES_NOT_EXITS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DOES_NOT_EXITS.getContent() + id;
			throw NoseException.create(userMessage, technicalMessage);
		}
		
	}
	
	

}
