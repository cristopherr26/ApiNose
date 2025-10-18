package co.edu.uco.nose.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.domain.UserDomain;

public interface UserBusiness {
	
	void registerNewUserInformation(UserDomain userDomain);
	
	void dropUserInformation(UUID id);
	
	void updateUserInformation(UUID id, UserDomain userDomain);
	
	List<UserDomain> findAllUsers();
	
	List<UserDomain> findUserByFilter(UserDomain userFilters);
	
	UserDomain findUserById(UUID id);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendMobileNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);

}
