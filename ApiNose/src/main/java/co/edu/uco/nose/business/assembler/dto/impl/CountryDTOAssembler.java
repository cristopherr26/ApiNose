package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CountryDto;

public final class CountryDTOAssembler implements DTOAssembler<CountryDto, CountryDomain> {

	private static final DTOAssembler<CountryDto, CountryDomain> instance = new CountryDTOAssembler();
	private CountryDTOAssembler() {
		
	}
	
	public static DTOAssembler<CountryDto, CountryDomain> getCountryDTOAssembler() {
		return instance;
	}
	
	@Override
	public CountryDto toDTO(final CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryDto(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomain(final CountryDto dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CountryDto());
		return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<CountryDto> toDTO(final List<CountryDomain> domainList) {
		var countryDtoList = new ArrayList<CountryDto>();
		
		for (var countryDomain : domainList) {
			
			countryDtoList.add(toDTO(countryDomain));
			
		}
		return countryDtoList;
	}

}
