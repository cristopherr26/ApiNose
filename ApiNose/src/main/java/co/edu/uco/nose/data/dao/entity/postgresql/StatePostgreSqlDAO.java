package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.StateEntity;

public final class StatePostgreSqlDAO extends SqlConnection implements StateDAO {

	public StatePostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<StateEntity> findAll() {
		final var sql = new StringBuilder();

	    final var states = new ArrayList<StateEntity>();

	    sql.append("SELECT ");
	    sql.append("  d.id AS idDepartamento, ");
	    sql.append("  d.nombre AS nombreDepartamento, ");
	    sql.append("  p.id AS idPais, ");
	    sql.append("  p.nombre AS nombrePais ");
	    sql.append("FROM \"Departamento\" AS d ");
	    sql.append("INNER JOIN \"Pais\" AS p ");
	    sql.append("  ON d.pais = p.id ");

	    try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

	        try (var resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {

	                var country = new CountryEntity();
	                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPais")));
	                country.setName(resultSet.getString("nombrePais"));
	                
	                var state = new StateEntity();
	                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamento")));
	                state.setName(resultSet.getString("nombreDepartamento"));
	                state.setCountry(country);
	                
	                states.add(state);
	            }
	        }

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_STATE.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE.getContent()
	                + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage =MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE.getContent();
	        var technicalMessage =MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }

	    return states;

	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity findById(UUID id) {
		
		final var sql = new StringBuilder();

	    final var state = new StateEntity();

	    sql.append("SELECT ");
	    sql.append("  d.id AS idDepartamento, ");
	    sql.append("  d.nombre AS nombreDepartamento, ");
	    sql.append("  p.id AS idPais, ");
	    sql.append("  p.nombre AS nombrePais ");
	    sql.append("FROM \"Departamento\" AS d ");
	    sql.append("INNER JOIN \"Pais\" AS p ");
	    sql.append("  ON d.pais = p.id ");
	    sql.append("WHERE d.id = ?; ");

	    try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

	        preparedStatement.setObject(1, id);

	        try (var resultSet = preparedStatement.executeQuery()) {

	            if (resultSet.next()) {

	                var country = new CountryEntity();
	                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPais")));
	                country.setName(resultSet.getString("nombrePais"));

	                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamento")));
	                state.setName(resultSet.getString("nombreDepartamento"));
	                state.setCountry(country);
	            }
	        }

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_STATE.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE.getContent()
	                + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage =MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE.getContent();
	        var technicalMessage =MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }

	    return state;

	}

}
