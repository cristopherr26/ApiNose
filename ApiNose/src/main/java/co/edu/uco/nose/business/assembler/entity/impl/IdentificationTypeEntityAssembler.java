package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
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
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdentificationTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(final IdentificationTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new IdentificationTypeEntity());
		return new IdentificationTypeDomain(entityTmp.getId(), entityTmp.getName());
	}

}
