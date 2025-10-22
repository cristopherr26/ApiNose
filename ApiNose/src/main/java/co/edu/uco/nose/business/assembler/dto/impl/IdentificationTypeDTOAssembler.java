package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.IdentificationTypeDto;


public final class IdentificationTypeDTOAssembler implements DTOAssembler<IdentificationTypeDto, IdentificationTypeDomain> {

	
	private static final DTOAssembler<IdentificationTypeDto, IdentificationTypeDomain> instance = new IdentificationTypeDTOAssembler();
	private IdentificationTypeDTOAssembler() {
		
	}
	
	public static DTOAssembler<IdentificationTypeDto, IdentificationTypeDomain> getIdentificationTypeDTOAssembler() {
		return instance;
	}
	
	@Override
	public IdentificationTypeDto toDTO(final IdentificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdentificationTypeDto(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(final IdentificationTypeDto dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new IdentificationTypeDto());
		return new IdentificationTypeDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<IdentificationTypeDto> toDTO(final List<IdentificationTypeDomain> domainList) {
		var identificationTypeDtoList = new ArrayList<IdentificationTypeDto>();
		
		for (var identificationTypeDomain : domainList) {
			
			identificationTypeDtoList.add(toDTO(identificationTypeDomain));
		}
		
		return identificationTypeDtoList;
	}
	

}
