package co.edu.uco.nose.test;

import java.util.UUID;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.CityDto;
import co.edu.uco.nose.dto.IdentificationTypeDto;
import co.edu.uco.nose.dto.UserDto;

public class TestUserRegistration {
	
	public static void main(String[] args) {
		
	try {
		var user = new UserDto();
		
		user.setIdentificationType(new IdentificationTypeDto(UUID.fromString("11111111-1111-1111-1111-111111111111")));
        user.setIdentificationNumber("1036254058");
        user.setFirstName("Cristopher");
        user.setMiddleName("Jesus");
        user.setLastName("Ospina");
        user.setSecondLastName("Arroyave");
        user.setResidenceCity(new CityDto(UUID.fromString("c3333333-3333-3333-3333-333333333333")));
        user.setEmail("cristo.ospina@example.com");
        user.setCellPhoneNumber("3001234567");
        user.setEmailConfirmed(false);
        user.setCellPhoneNumberConfirmed(false);
		
		var facade = new UserFacadeImpl();
		facade.registerNewUserInformation(user);
		
		System.out.println("Gane el semestre");
	}catch(NoseException e) {
		System.out.println(e.getUserMessage());
		System.out.println(e.getTechnicalMessage());
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}

}
