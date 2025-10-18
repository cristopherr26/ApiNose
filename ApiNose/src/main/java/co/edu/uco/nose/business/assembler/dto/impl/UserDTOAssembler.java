package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDomain toDomain(final UserDto dto) {
		// TODO Auto-generated method stub
		return null;
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
