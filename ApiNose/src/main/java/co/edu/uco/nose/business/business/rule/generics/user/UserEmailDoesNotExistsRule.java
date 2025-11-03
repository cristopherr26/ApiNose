package co.edu.uco.nose.business.business.rule.generics.user;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEmailDoesNotExistsRule implements Rule {
	
	private static final Rule instance = new UserEmailDoesNotExistsRule();
	
	private UserEmailDoesNotExistsRule() {
		
	}
	
	public static void executeRule(final Object... data) {
		instance.execute(data);
	}
	
	@Override
	public void execute(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		var email = (String) data [0];
		var daoFactory = (DAOFactory) data [1];
		
		var filter = new UserEntity();
		filter.setEmail(email);
	   
	    var duplicateEmail = daoFactory.getUserDAO().findByFilter(filter);
	    
	    if(!duplicateEmail.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_USER_DOES_EXISTS_BY_EMAIL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DOES_EXISTS_BY_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }
		
	}

}
