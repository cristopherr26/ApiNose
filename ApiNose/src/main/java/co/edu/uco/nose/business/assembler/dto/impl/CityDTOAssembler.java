package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain toDomain(final CityDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDto> toDTO(List<CityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
