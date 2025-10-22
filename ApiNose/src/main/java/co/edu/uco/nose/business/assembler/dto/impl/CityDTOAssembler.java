package co.edu.uco.nose.business.assembler.dto.impl;

import static co.edu.uco.nose.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDto;

public final class CityDTOAssembler implements DTOAssembler<CityDto, CityDomain> {

	
	private static final DTOAssembler<CityDto, CityDomain> instance = new CityDTOAssembler();
	private CityDTOAssembler() {
		
	}
	
	public static DTOAssembler<CityDto, CityDomain> getCityDTOAssembler() {
		return instance;
	}
	
	@Override
	public CityDto toDTO(final CityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var stateTmp = getStateDTOAssembler().toDTO(domainTmp.getState());
		return new CityDto(domainTmp.getId(), domainTmp.getName(), stateTmp);
	}

	@Override
	public CityDomain toDomain(final CityDto dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CityDto());
		var stateDomainTmp = getStateDTOAssembler().toDomain(dtoTmp.getState());
		return new CityDomain(dtoTmp.getId(), dtoTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<CityDto> toDTO(final List<CityDomain> domainList) {
		var cityDtoList = new ArrayList<CityDto>();
		
		for (var cityDomain : domainList) {
			
			cityDtoList.add(toDTO(cityDomain));
			
		}
		
		return cityDtoList;
	}

}
