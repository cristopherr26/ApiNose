package co.edu.uco.nose.business.assembler.dto.impl;

import static co.edu.uco.nose.business.assembler.dto.impl.CountryDTOAssembler.getCountryDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.StateDto;

public final class StateDTOAssembler implements DTOAssembler<StateDto, StateDomain> {

	
	private static final DTOAssembler<StateDto, StateDomain> instance = new StateDTOAssembler();
	private StateDTOAssembler() {
		
	}
	
	public static DTOAssembler<StateDto, StateDomain> getStateDTOAssembler() {
		return instance;
	}
	
	@Override
	public StateDto toDTO(final StateDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var countryTmp = getCountryDTOAssembler().toDTO(domainTmp.getCountry());
		return new StateDto(domainTmp.getId(), domainTmp.getName(), countryTmp);
	}

	@Override
	public StateDomain toDomain(final StateDto dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new StateDto());
		var countryDomainTmp = getCountryDTOAssembler().toDomain(dtoTmp.getCountry());
		return new StateDomain(dtoTmp.getId(), dtoTmp.getName(), countryDomainTmp);
	}

	@Override
	public List<StateDto> toDTO(final List<StateDomain> domainList) {
		var stateDtoList = new ArrayList<StateDto>();
		
		for (var stateDomain : domainList) {
			
			stateDtoList.add(toDTO(stateDomain));
			
		}
		return stateDtoList;
	}

}
