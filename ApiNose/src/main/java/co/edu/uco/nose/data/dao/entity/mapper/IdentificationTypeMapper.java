package co.edu.uco.nose.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public final class IdentificationTypeMapper {
	
	public static IdentificationTypeEntity map(final ResultSet resultSet) {
		
		var identificationType = new IdentificationTypeEntity();
		
		try {
			
			identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
			identificationType.setName(resultSet.getString("nombreTipoIdentificacion"));
			
		} catch (final SQLException exception) {
			
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_IDENTIFICATIONTYPE_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_IDENTIFICATION_TYPE_MAPPER + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_IDENTIFICATIONTYPE_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_IDENTIFICATIONTYPE_MAPPER.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return identificationType;
	}

}
