package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDomain toDomain(final UserEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
