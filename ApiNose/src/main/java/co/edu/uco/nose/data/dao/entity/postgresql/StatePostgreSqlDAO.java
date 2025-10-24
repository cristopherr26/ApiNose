package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
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
	return findByFilter(new StateEntity());
	}
	
	@Override
	public List<StateEntity> findByFilter(final StateEntity filterEntity) {
		
		var parametersList = new ArrayList<Object>();
		
		var sql = createSentenceFindByFilter(filterEntity, parametersList);
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql)){
			
			for (int index = 0; index < parametersList.size(); index++) {
				preparedStatement.setObject(index+1, parametersList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final NoseException exception) {
			throw exception;
		} catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_EXECUTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_PREPARATION.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_EXECUTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_PREPARATION.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }
	}
	  


	private String createSentenceFindByFilter(final StateEntity filterEntity, final List<Object> parametersList) {
		
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  d.\"id\" AS \"idDepartamento\", ");
		sql.append("  d.\"nombre\" AS \"nombreDepartamento\", ");
		sql.append("  d.\"pais\" AS \"idPais\", ");
		sql.append("  p.\"nombre\" AS \"nombrePais\" ");
		sql.append("FROM \"Departamento\" AS d ");
		sql.append("INNER JOIN \"Pais\" AS p ");
		sql.append("  ON d.\"pais\" = p.\"id\" ");

	    
	    createWhereClauseFindByFilter(sql, parametersList, filterEntity);
	    
	    return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
			final StateEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StateEntity());
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
		"p.\"id\" = ", filterEntityValidated.getId());
		
		
		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
		"p.\"nombre\" = ", filterEntityValidated.getName());
		
		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCountry().getId()),
		"d.\"pais\" = ", filterEntityValidated.getId());
				
		
		
		if(!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}

	private void addCondition(final List<String> conditions, final List<Object> parametersList, final boolean condition,
			final String clause, final Object value) {
		
		if(condition) {
			conditions.add(clause + " ?");
			parametersList.add(value);
		}
		
	}
	
	private List<StateEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		
		var states = new ArrayList<StateEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {

		            var country = new CountryEntity();
		            country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPais")));	   
		            country.setName(resultSet.getString("nombrePais"));
		            
		            var state = new StateEntity();
		            state.setCountry(country);
		            state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamento")));
		            state.setName(resultSet.getString("nombreDepartamento"));
		           
		            states.add(state);
		        }

		    } catch (final SQLException exception) {
		        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_EXECUTION.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_EXECUTION + exception.getMessage();
		        throw NoseException.create(exception, userMessage, technicalMessage);
		    } catch (final Exception exception) {
		        var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_EXECUTION.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_EXECUTION.getContent() + exception.getMessage();
		        throw NoseException.create(exception, userMessage, technicalMessage);
		    }

		    return states;
		}

	@Override
	public StateEntity findById(final UUID id) {
		return findByFilter(new StateEntity(id)).stream().findFirst().orElse(new StateEntity());
	}

}
