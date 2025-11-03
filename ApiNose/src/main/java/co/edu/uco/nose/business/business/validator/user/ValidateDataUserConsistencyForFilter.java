package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.generics.StringFormatValueIsValidRule;
import co.edu.uco.nose.business.business.rule.generics.StringLengthValueIsValidRule;
import co.edu.uco.nose.business.business.validator.Validator;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public class ValidateDataUserConsistencyForFilter implements Validator {
	
	private static final Validator instance = new ValidateDataUserConsistencyForFilter();
	
	private ValidateDataUserConsistencyForFilter(){
		
	}
	
	public static void executeValidation(final Object... data) {
		instance.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALUE_USER_IS_NOT_PRESENT.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 1) {
			var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_IS_NOT_PRESENT.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		var userDomainData = (UserDomain) data [0];
		
		validateDataLength(userDomainData);
		
		validateDataFormat(userDomainData);
		
	}
		
		
		private void validateDataLength(final UserDomain data) {
			
			if(!TextHelper.isEmptyWithTrim(data.getIdentificationNumber())) {
			     StringLengthValueIsValidRule.executeRule(data.getIdentificationNumber(), "Número de identificación", 1, 50, true);
			}
						
			if(!TextHelper.isEmptyWithTrim(data.getFirstName())){
				
				StringLengthValueIsValidRule.executeRule(data.getFirstName(), "Primer nombre", 1, 100, true);
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getLastName())){
				
				StringLengthValueIsValidRule.executeRule(data.getLastName(), "Primer apellido", 1, 100, true);
			}

			if(!TextHelper.isEmptyWithTrim(data.getMiddleName())){
				
				StringLengthValueIsValidRule.executeRule(data.getMiddleName(), "Segundo nombre", 1, 100, true);
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getSecondLastName())){
				
				StringLengthValueIsValidRule.executeRule(data.getSecondLastName(), "Segundo apellido", 1, 100, true);
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getEmail())){
				
				StringLengthValueIsValidRule.executeRule(data.getEmail(), "Correo electrónico", 1, 100, true);
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getCellPhoneNumber())){
				
				StringLengthValueIsValidRule.executeRule(data.getCellPhoneNumber(), "Número de celular", 1, 15, true);
			}

		}
		
		private void validateDataFormat(final UserDomain data) {
			
			if(!TextHelper.isEmptyWithTrim(data.getIdentificationNumber())) {
				StringFormatValueIsValidRule.executeRule(data.getIdentificationNumber(), "Número de identificación", "^\\d+$", true );
			}
						
			if(!TextHelper.isEmptyWithTrim(data.getFirstName())){
				
				StringFormatValueIsValidRule.executeRule(data.getFirstName(), "Primer nombre", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true);
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getLastName())){
				
				StringFormatValueIsValidRule.executeRule(data.getLastName(), "Primer apellido", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true);
			}

			if(!TextHelper.isEmptyWithTrim(data.getMiddleName())){
				
				StringFormatValueIsValidRule.executeRule(data.getMiddleName(), "Segundo nombre", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true);
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getSecondLastName())){
				
				StringFormatValueIsValidRule.executeRule(data.getSecondLastName(), "Segundo apellido", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true );
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getEmail())){
				
				StringFormatValueIsValidRule.executeRule(data.getEmail(), "Correo electrónico", "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", true );
			}
			
			if(!TextHelper.isEmptyWithTrim(data.getCellPhoneNumber())){
				
				StringFormatValueIsValidRule.executeRule(data.getCellPhoneNumber(), "Número de celular", "^\\+?\\d+$", true);
			}
		
	}

}
