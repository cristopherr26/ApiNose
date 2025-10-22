package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uco.nose.business.assembler.dto.impl.CityDTOAssembler.getCityDTOAssembler;
import static co.edu.uco.nose.business.assembler.dto.impl.IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDto;

public final class UserDTOAssembler implements DTOAssembler<UserDto, UserDomain> {

	
	private static final DTOAssembler<UserDto, UserDomain> instance = new UserDTOAssembler();
	private UserDTOAssembler() {
		
	}
	
	public static DTOAssembler<UserDto, UserDomain> getUserDTOAssembler() {
		return instance;
	}
	
	@Override
	public UserDto toDTO(final UserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var identificationTypeTmp = getIdentificationTypeDTOAssembler().toDTO(domainTmp.getIdentificationType());
		var cityTmp = getCityDTOAssembler().toDTO(domainTmp.getResidenceCity());
		return new UserDto(domainTmp.getId(), identificationTypeTmp, domainTmp.getIdentificationNumber(), 
				domainTmp.getFirstName(), domainTmp.getMiddleName(), domainTmp.getLastName(), 
				domainTmp.getSecondLastName(), cityTmp, domainTmp.getEmail(), 
				domainTmp.getCellPhoneNumber(), domainTmp.isEmailConfirmed(), domainTmp.isCellPhoneNumberConfirmed());
	}

	@Override
	public UserDomain toDomain(final UserDto dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new UserDto());
		var identificationTypeDomainTmp = getIdentificationTypeDTOAssembler().toDomain(dtoTmp.getIdentificationType());
		var cityDomainTmp = getCityDTOAssembler().toDomain(dtoTmp.getResidenceCity());
		return new UserDomain(dtoTmp.getId(), identificationTypeDomainTmp, dtoTmp.getIdentificationNumber(), 
				dtoTmp.getFirstName(), dtoTmp.getMiddleName(), dtoTmp.getLastName(), 
				dtoTmp.getSecondLastName(), cityDomainTmp, dtoTmp.getEmail(), 
				dtoTmp.getCellPhoneNumber(), dtoTmp.isEmailConfirmed(), dtoTmp.isCellPhoneNumberConfirmed());
	}

	@Override
	public List<UserDto> toDTO(final List<UserDomain> domainList) {
		var userDtoList = new ArrayList<UserDto>();
		
		for (var userDomain : domainList) {
			userDtoList.add(toDTO(userDomain));
		}
		return userDtoList;
	}

}
