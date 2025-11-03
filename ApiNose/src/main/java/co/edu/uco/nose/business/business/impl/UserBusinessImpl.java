package co.edu.uco.nose.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.business.validator.city.ValidateCityExistsById;
import co.edu.uco.nose.business.business.validator.identificationtype.ValidateIdTypeExistsById;
import co.edu.uco.nose.business.business.validator.user.ValidateDataUserConsistencyForRegisterNewInformation;
import co.edu.uco.nose.business.business.validator.user.ValidateUserDoesNotExistsWithSameTypeAndNumber;
import co.edu.uco.nose.business.business.validator.user.ValidateUserEmailDoesNotExists;
import co.edu.uco.nose.business.business.validator.user.ValidateUserMobilePhoneDoesNotExists;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
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
				
		ValidateDataUserConsistencyForRegisterNewInformation.executeValidation(userDomain);
		
		ValidateIdTypeExistsById.executeValidation(userDomain.getIdentificationType().getId(), daoFactory);
		
		ValidateCityExistsById.executeValidation(userDomain.getResidenceCity().getId(), daoFactory);
				
		ValidateUserDoesNotExistsWithSameTypeAndNumber.executeValidation(userDomain.getIdentificationType(), userDomain.getIdentificationNumber(), daoFactory);
		
		ValidateUserEmailDoesNotExists.executeValidation(userDomain.getEmail(), daoFactory);
		
		ValidateUserMobilePhoneDoesNotExists.executeValidation(userDomain.getCellPhoneNumber(), daoFactory);
		
		
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		
		userEntity.setId(generateId());
		
		daoFactory.getUserDAO().create(userEntity);
		
	}
	
	private UUID generateId() {
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		var userEntity = daoFactory.getUserDAO().findById(id);
		while (!UUIDHelper.getUUIDHelper().isDefaultUUID(userEntity.getId())) {
			id = UUIDHelper.getUUIDHelper().generateNewUUID();
			userEntity = daoFactory.getUserDAO().findById(id);
		}
		
		return id;
	}
	
	


	@Override
	public void dropUserInformation(final UUID id) {
		
		daoFactory.getUserDAO().delete(id);
		
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDomain userDomain) {
		
		daoFactory.getUserDAO().findById(id);
		
		
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
	public List<UserDomain> findUserByFilter(final UserDomain userFilters) {
		
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
