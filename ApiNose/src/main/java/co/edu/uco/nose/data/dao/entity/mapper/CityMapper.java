package co.edu.uco.nose.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.entity.CityEntity;

public final class CityMapper {
	
	public static CityEntity map(final ResultSet resultSet) {
		var city = new CityEntity();
		try {
			
			var state = StateMapper.map(resultSet);
			city.setState(state);
			city.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCiudadResidencia")));
			city.setName(resultSet.getString("nombreCiudadResidencia"));
			
		} catch (final SQLException exception ) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_CITY_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_CITY_MAPPER + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_CITY_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_CITY_MAPPER.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		return city;
	}
}

