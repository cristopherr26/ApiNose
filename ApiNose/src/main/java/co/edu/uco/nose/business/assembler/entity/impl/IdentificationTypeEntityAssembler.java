package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public final class IdentificationTypeEntityAssembler implements EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> {

	private static final EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> instance = new IdentificationTypeEntityAssembler();
	private IdentificationTypeEntityAssembler() {
		
	}
	
	public static EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> getIdentificationTypeEntityAssembler() {
		return instance;
	}
	
	@Override
	public IdentificationTypeEntity toEntity(final IdentificationTypeDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentificationTypeDomain toDomain(final IdentificationTypeEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
