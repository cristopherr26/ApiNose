package co.edu.uco.nose.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CityPostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CountryPostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.IdentificationTypePostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.StatePostgreSqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.UserPostgreSqlDAO;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class PostgresqlDAOFactory extends DAOFactory {
	
	public PostgresqlDAOFactory() {
		openConnection();
	}
	
	@Override
	protected void openConnection() {
		
		try {
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ApiNose", "postgres", "11ospinarroyave");
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public CityDAO getCityDAO() {
		return new CityPostgreSqlDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		return new StatePostgreSqlDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountryPostgreSqlDAO(connection);
	}

	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		return new IdentificationTypePostgreSqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserPostgreSqlDAO(connection);
	}


}
