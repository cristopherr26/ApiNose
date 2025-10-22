package co.edu.uco.nose.business.assembler.entity.impl;

import static co.edu.uco.nose.business.assembler.entity.impl.IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler;
import static co.edu.uco.nose.business.assembler.entity.impl.CityEntityAssembler.getCityEntityAssembler;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain> {

	private static final EntityAssembler<UserEntity, UserDomain> instance = new UserEntityAssembler();
	private UserEntityAssembler() {
		
	}
	
	public static EntityAssembler<UserEntity, UserDomain> getUserEntityAssembler() {
		return instance;
	}
	
	@Override
	public UserEntity toEntity(final UserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var identificationTypeTmp = getIdentificationTypeEntityAssembler().toEntity(domainTmp.getIdentificationType());
		var cityTmp = getCityEntityAssembler().toEntity(domainTmp.getResidenceCity());
		return new UserEntity(domainTmp.getId(), identificationTypeTmp, domainTmp.getIdentificationNumber(),
				domainTmp.getFirstName(), domainTmp.getMiddleName(), domainTmp.getLastName(),
				domainTmp.getSecondLastName(), cityTmp, domainTmp.getEmail(), domainTmp.getCellPhoneNumber(),
				domainTmp.isEmailConfirmed(), domainTmp.isCellPhoneNumberConfirmed());
	}

	@Override
	public UserDomain toDomain(final UserEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new UserEntity());
		var identificationTypeDomainTmp = getIdentificationTypeEntityAssembler().toDomain(entityTmp.getIdentificationType());
		var cityDomainTmp = getCityEntityAssembler().toDomain(entityTmp.getResidenceCity());
		return new UserDomain(entityTmp.getId(), identificationTypeDomainTmp, entityTmp.getIdentificationNumber(),
				entityTmp.getFirstName(), entityTmp.getMiddleName(), entityTmp.getLastName(),
				entityTmp.getSecondLastName(), cityDomainTmp, entityTmp.getEmail(), entityTmp.getCellPhoneNumber(),
				entityTmp.isEmailConfirmed(), entityTmp.isCellPhoneNumberConfirmed());
	}

}
