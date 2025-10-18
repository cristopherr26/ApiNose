package co.edu.uco.nose.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.business.facade.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDto;

public final class UserFacadeImpl implements UserFacade{

	@Override
	public void registerNewUserInformation(final UserDto userDto) {
		
		//1. Validar que la informacion sea consistente a nivel de tipo de dato, longitud, oblatoriedad
		//2. Validar que no exista otro usuario con el mismo tipo y número de documento
		//3. Validar que no exista previamente un usuario con el mismo email
		//4. Validar que no exista previamente un usuario con el mismo número de teléfono celular
		//5. Generar un identificador para el nuevo usuario, asegurando de que no exista previamente
		
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			
			var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
			
			business.registerNewUserInformation(domain);
			
			daoFactory.commitTransaction();
			
		} catch (final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDto userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDto> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> findUserByFilter(UserDto userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findUserById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmMobileNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
