package co.edu.uco.nose.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.dto.UserDto;


public interface UserFacade {
	
	void registerNewUserInformation(UserDto userDto);
	
	void dropUserInformation(UUID id);
	
	void updateUserInformation(UUID id, UserDto userDto);
	
	List<UserDto> findAllUsers();
	
	List<UserDto> findUserByFilter(UserDto userFilters);
	
	UserDto findUserById(UUID id);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendMobileNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);

}
