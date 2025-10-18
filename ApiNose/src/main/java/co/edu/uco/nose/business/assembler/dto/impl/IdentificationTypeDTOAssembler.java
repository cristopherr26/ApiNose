package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentificationTypeDomain toDomain(final IdentificationTypeDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdentificationTypeDto> toDTO(List<IdentificationTypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
