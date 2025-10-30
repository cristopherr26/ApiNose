package co.edu.uco.nose.business.assembler.entity.impl;

import static co.edu.uco.nose.business.assembler.entity.impl.CountryEntityAssembler.getCountryEntityAssembler;

import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.StateEntity;

public class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {

	private static final EntityAssembler<StateEntity, StateDomain> instance = new StateEntityAssembler();
	private StateEntityAssembler() {
		
	}
	
	public static EntityAssembler<StateEntity, StateDomain> getStateEntityAssembler() {
		return instance;
	}
	
	@Override
	public StateEntity toEntity(final StateDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var countryTmp = getCountryEntityAssembler().toEntity(domainTmp.getCountry());
		return new StateEntity(domainTmp.getId(), domainTmp.getName(), countryTmp);
	}

	@Override
	public StateDomain toDomain(final StateEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new StateEntity());
		var countryDomainTmp = getCountryEntityAssembler().toDomain(entityTmp.getCountry());
		return new StateDomain(entityTmp.getId(), entityTmp.getName(), countryDomainTmp);
	}

	@Override
	public List<StateDomain> toDomain(List<StateEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
