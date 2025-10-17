package co.edu.uco.nose.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.entity.UserEntity;

public final class UserMapper {
	
	public static UserEntity map(final ResultSet  resultSet) {
		var user = new UserEntity();
		
		try {
			
			var identificationType = IdentificationTypeMapper.map(resultSet);
			var city = CityMapper.map(resultSet);
			
			user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
			user.setIdentificationType(identificationType);
			user.setIdentificationNumber(resultSet.getString("numeroIdentificacion"));
			user.setFirstName(resultSet.getString("primerNombre"));
			user.setMiddleName(resultSet.getString("segundoNombre"));
			user.setLastName(resultSet.getString("primerApellido"));
			user.setSecondLastName(resultSet.getString("segundoApellido"));
			user.setResidenceCity(city);
			user.setEmail(resultSet.getString("correoElectronico"));
			user.setCellPhoneNumber(resultSet.getString("numeroTelefonoMovil"));
			user.setEmailConfirmed(resultSet.getBoolean("correoElectronicoConfirmado"));
			user.setCellPhoneNumberConfirmed(resultSet.getBoolean("numeroTelefonoMovilConfirmado"));
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_USER_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_USER_MAPPER + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_USER_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_USER_MAPPER.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return user;
	}
}
