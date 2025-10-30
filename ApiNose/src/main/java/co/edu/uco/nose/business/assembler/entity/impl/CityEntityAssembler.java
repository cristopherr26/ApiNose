package co.edu.uco.nose.business.assembler.entity.impl;

import static co.edu.uco.nose.business.assembler.entity.impl.StateEntityAssembler.getStateEntityAssembler;

import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;

public final class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {

	private static final EntityAssembler<CityEntity, CityDomain> instance = new CityEntityAssembler();
	private CityEntityAssembler() {
		
	}
	
	public static EntityAssembler<CityEntity, CityDomain> getCityEntityAssembler() {
		return instance;
	}
	
	@Override
	public CityEntity toEntity(final CityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var stateTmp = getStateEntityAssembler().toEntity(domainTmp.getState());
		return new CityEntity(domainTmp.getId(), domainTmp.getName(), stateTmp);
	}

	@Override
	public CityDomain toDomain(final CityEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CityEntity());
		var stateDomainTmp = getStateEntityAssembler().toDomain(entityTmp.getState());
		return new CityDomain(entityTmp.getId(), entityTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<CityDomain> toDomain(List<CityEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
