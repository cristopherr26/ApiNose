package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CountryEntity;


public final class CountryPostgreSqlDAO extends SqlConnection implements CountryDAO {

	public CountryPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<CountryEntity> findAll() {
		final var countries = new ArrayList<CountryEntity>();
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("  p.id, ");
		sql.append("  p.nombre, ");
		sql.append("  from \"Pais\" as p ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				while (resultSet.next()) {
					
					var country = new CountryEntity();
					
					country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					country.setName(resultSet.getString("nombre"));
					countries.add(country);
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_COUNTRY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_COUNTRY + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return countries;
	}

	@Override
	public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity findById(UUID id) {
		final var country = new CountryEntity();
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("  p.id, ");
		sql.append("  p.nombre, ");
		sql.append("  from \"Pais\" as p ");
		sql.append("  where p.id = ? ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				if(resultSet.next()) {
					
					country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					country.setName(resultSet.getString("nombre"));
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_COUNTRY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_COUNTRY + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return country;
	}
}


