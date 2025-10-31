package co.edu.uco.nose.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.entity.UserEntity;

public final class UserBusinessImpl implements UserBusiness {

	private DAOFactory daoFactory;
	
	
	public UserBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registerNewUserInformation(final UserDomain userDomain) {
		
		//1. Validar que la informacion sea consistente a nivel de tipo de dato, longitud, oblatoriedad
		//2. Validar que no exista otro usuario con el mismo tipo y número de documento
		//3. Validar que no exista previamente un usuario con el mismo email
		//4. Validar que no exista previamente un usuario con el mismo número de teléfono celular
		//5. Generar un identificador para el nuevo usuario, asegurando de que no exista previamente
		
		validateUserData(userDomain);
		validateDuplicatedUser(userDomain);
		
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		while (!UUIDHelper.getUUIDHelper().isDefaultUUID(daoFactory.getUserDAO().findById(id).getId())) {
		        id = UUIDHelper.getUUIDHelper().generateNewUUID();
		 }
		 
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		
		userEntity.setId(id);
		
		daoFactory.getUserDAO().create(userEntity);
		
	}
	
	private void validateUserData (final UserDomain userDomain) {
		if(ObjectHelper.isNull(userDomain)) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_NULL_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_USER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(ObjectHelper.isNull(userDomain.getIdentificationType())) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_NULL_IDENTIFICATION_TYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_IDENTIFICATION_TYPE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(ObjectHelper.isNull(userDomain.getResidenceCity())) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_NULL_CITY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_CITY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getIdentificationNumber()) || 
				userDomain.getIdentificationNumber().length() > 25) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getFirstName()) || 
				userDomain.getFirstName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_FIRST_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_FIRST_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getMiddleName()) || 
				userDomain.getMiddleName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_MIDDLE_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_MIDDLE_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getLastName()) || 
				userDomain.getLastName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_LAST_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_lAST_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getSecondLastName()) || 
				userDomain.getSecondLastName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_SECOND_LAST_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_SECOND_lAST_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (!TextHelper.isValidEmail(userDomain.getEmail()) || 
				userDomain.getEmail().length() > 250) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_EMAIL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (!TextHelper.isValidPhoneNumber(userDomain.getCellPhoneNumber()) || 
				userDomain.getCellPhoneNumber().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		
	}
	
	private void validateDuplicatedUser(final UserDomain userDomain) {

	    var userEntityFilter = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);


	    var userDAO = daoFactory.getUserDAO();

	    var filterByIdentification = new UserEntity();
	    filterByIdentification.setIdentificationType(userEntityFilter.getIdentificationType());
	    filterByIdentification.setIdentificationNumber(userEntityFilter.getIdentificationNumber());

	    var existingById = userDAO.findByFilter(filterByIdentification);
	    if (!existingById.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }

	    var filterByEmail = new UserEntity();
	    filterByEmail.setEmail(userEntityFilter.getEmail());

	    var existingByEmail = userDAO.findByFilter(filterByEmail);
	    if (!existingByEmail.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }

	    var filterByPhone = new UserEntity();
	    filterByPhone.setCellPhoneNumber(userEntityFilter.getCellPhoneNumber());

	    var existingByPhone = userDAO.findByFilter(filterByPhone);
	    if (!existingByPhone.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }
	}



	@Override
	public void dropUserInformation(final UUID id) {
		
		daoFactory.getUserDAO().delete(id);
		
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDomain userDomain) {
		
		daoFactory.getUserDAO().findById(id);
		
		validateUserData(userDomain);
		
		validateDuplicatedUserOnUpdate(id, userDomain);
		
		
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		
		userEntity.setId(id);
		
		daoFactory.getUserDAO().update(userEntity);
		
	}
	
	private void validateDuplicatedUserOnUpdate(final UUID id, final UserDomain userDomain) {

	    var userEntityFilter = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
	    var userDAO = daoFactory.getUserDAO();

	    var filterByIdentification = new UserEntity();
	    filterByIdentification.setIdentificationType(userEntityFilter.getIdentificationType());
	    filterByIdentification.setIdentificationNumber(userEntityFilter.getIdentificationNumber());

	    var existingById = userDAO.findByFilter(filterByIdentification);
	    if (!existingById.isEmpty() && !existingById.get(0).getId().equals(id)) {
	        var userMessage = MessagesEnum.USER_ERROR_WHILE_UPDATING_USER_DUPLICATED_IDENTIFICATION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_UPDATING_USER_DUPLICATED_IDENTIFICATION.getContent();
	        throw NoseException.create(userMessage, technicalMessage);
	    }

	    var filterByEmail = new UserEntity();
	    filterByEmail.setEmail(userEntityFilter.getEmail());

	    var existingByEmail = userDAO.findByFilter(filterByEmail);
	    if (!existingByEmail.isEmpty() && !existingByEmail.get(0).getId().equals(id)) {
	        var userMessage = MessagesEnum.USER_ERROR_WHILE_UPDATING_USER_DUPLICATED_EMAIL.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_UPDATING_USER_DUPLICATED_EMAIL.getContent();
	        throw NoseException.create(userMessage, technicalMessage);
	    }

	    var filterByPhone = new UserEntity();
	    filterByPhone.setCellPhoneNumber(userEntityFilter.getCellPhoneNumber());

	    var existingByPhone = userDAO.findByFilter(filterByPhone);
	    if (!existingByPhone.isEmpty() && !existingByPhone.get(0).getId().equals(id)) {
	        var userMessage = MessagesEnum.USER_ERROR_WHILE_UPDATING_USER_DUPLICATED_CELL_PHONE_NUMBER.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_UPDATING_USER_DUPLICATED_CELL_PHONE_NUMBER.getContent();
	        throw NoseException.create(userMessage, technicalMessage);
	    }
	}

	
	


	@Override
	public List<UserDomain> findAllUsers() {
		
		var userEntities = daoFactory.getUserDAO().findAll();
		
		return UserEntityAssembler.getUserEntityAssembler().toDomain(userEntities);
		
	}

	@Override
	public List<UserDomain> findUserByFilter(UserDomain userFilters) {
		
		var userFiltersEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userFilters);
		
		var userEntites = daoFactory.getUserDAO().findByFilter(userFiltersEntity);
		
		return UserEntityAssembler.getUserEntityAssembler().toDomain(userEntites);
	}

	@Override
	public UserDomain findUserById(final UUID id) {
		
		var userEntity = daoFactory.getUserDAO().findById(id);
		
		return UserEntityAssembler.getUserEntityAssembler().toDomain(userEntity);
	}

	@Override
	public void confirmMobileNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
