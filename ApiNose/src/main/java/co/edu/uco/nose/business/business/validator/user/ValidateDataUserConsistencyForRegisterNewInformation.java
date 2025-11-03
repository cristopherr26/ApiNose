package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.generics.StringFormatValueIsValidRule;
import co.edu.uco.nose.business.business.rule.generics.StringLengthValueIsValidRule;
import co.edu.uco.nose.business.business.rule.generics.StringValueIsPresentRule;
import co.edu.uco.nose.business.business.rule.generics.UuidValueIsPresentRule;
import co.edu.uco.nose.business.business.validator.Validator;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public final class ValidateDataUserConsistencyForRegisterNewInformation implements Validator {
	
	private static final Validator instance = new ValidateDataUserConsistencyForRegisterNewInformation();
	
	private ValidateDataUserConsistencyForRegisterNewInformation() {
		
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
		
		validateEmptyData(userDomainData);
		
		validateDataLength(userDomainData);
		
		validateDataFormat(userDomainData);
		
		
	}
	
	private void validateEmptyData(final UserDomain data) {
		 
		UuidValueIsPresentRule.executeRule(data.getIdentificationType().getId(), "Tipo de identificación");
		StringValueIsPresentRule.executeRule(data.getIdentificationNumber(), "Número de identificación", true);
		StringValueIsPresentRule.executeRule(data.getFirstName(), "Primer nombre", true);
		StringValueIsPresentRule.executeRule(data.getLastName(), "Primer apellido", true);
		UuidValueIsPresentRule.executeRule(data.getResidenceCity().getId(), "Ciudad de residencia");
		StringValueIsPresentRule.executeRule(data.getEmail(), "Correo electrónico", true);
		StringValueIsPresentRule.executeRule(data.getCellPhoneNumber(), "Número de celular", true);
	
	}
	
	private void validateDataLength(final UserDomain data) {
		
		StringLengthValueIsValidRule.executeRule(data.getIdentificationNumber(), "Número de identificación", 1, 50, true);
		StringLengthValueIsValidRule.executeRule(data.getFirstName(), "Primer nombre", 1, 100, true);
		StringLengthValueIsValidRule.executeRule(data.getLastName(), "Primer apellido", 1, 100, true);
		StringLengthValueIsValidRule.executeRule(data.getEmail(), "Correo electrónico", 1, 100, true);
		StringLengthValueIsValidRule.executeRule(data.getCellPhoneNumber(), "Número de celular", 1, 15, true);
		
		
		if(!TextHelper.isEmptyWithTrim(data.getMiddleName())){
			
			StringLengthValueIsValidRule.executeRule(data.getMiddleName(), "Segundo nombre", 1, 100, true);
		}
		
		if(!TextHelper.isEmptyWithTrim(data.getSecondLastName())){
			
			StringLengthValueIsValidRule.executeRule(data.getSecondLastName(), "Segundo apellido", 1, 100, true);
		}

	}
	
	private void validateDataFormat(final UserDomain data) {
		
		StringFormatValueIsValidRule.executeRule(data.getIdentificationNumber(), "Número de identificación", "^\\d+$", true );
		StringFormatValueIsValidRule.executeRule(data.getFirstName(), "Primer nombre", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true);
		StringFormatValueIsValidRule.executeRule(data.getLastName(), "Primer apellido", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true);
		StringFormatValueIsValidRule.executeRule(data.getEmail(), "Correo electrónico", "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", true );
		StringFormatValueIsValidRule.executeRule(data.getCellPhoneNumber(), "Número de celular", "^\\+?\\d+$", true);
		
		
		if(!TextHelper.isEmptyWithTrim(data.getMiddleName())){
			
			StringFormatValueIsValidRule.executeRule(data.getMiddleName(), "Segundo nombre", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true);
		}
		
		if(!TextHelper.isEmptyWithTrim(data.getSecondLastName())){
			
			StringFormatValueIsValidRule.executeRule(data.getSecondLastName(), "Segundo apellido", "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]+$", true );
		}
	}

}
