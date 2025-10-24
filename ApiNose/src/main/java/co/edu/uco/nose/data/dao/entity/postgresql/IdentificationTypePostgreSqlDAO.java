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
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public final class IdentificationTypePostgreSqlDAO extends SqlConnection implements IdentificationTypeDAO {

	public IdentificationTypePostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<IdentificationTypeEntity> findAll() {
		return findByFilter(new IdentificationTypeEntity());
	}


	@Override
	public List<IdentificationTypeEntity> findByFilter(final IdentificationTypeEntity filterEntity) {
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
	        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_PREPARATION.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY_WHILE_EXECUTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY_WHILE_PREPARATION.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }
	}
	  


	private String createSentenceFindByFilter(final IdentificationTypeEntity filterEntity, final List<Object> parametersList) {
		
		final var sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  i.\"id\" as \"idTipoDocumento\", ");
		sql.append("  i.\"nombre\" as \"nombreTipoDocumento\" ");
		sql.append("  from \"TipoIdentificacion\" as i ");
		
	    
	    createWhereClauseFindByFilter(sql, parametersList, filterEntity);
	    
	    return sql.toString();
	}

	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList,
			final IdentificationTypeEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new IdentificationTypeEntity());
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
		"i.\"id\" = ", filterEntityValidated.getId());
		
		
		addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
		"i.\"nombre\" = ", filterEntityValidated.getName());
		
		
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
	
	private List<IdentificationTypeEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		
		var identificationTypes = new ArrayList<IdentificationTypeEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {

		            var identificationType = new IdentificationTypeEntity();
		            identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoDocumento")));	   
		            identificationType.setName(resultSet.getString("nombreTipoDocumento"));
		           
		            identificationTypes.add(identificationType);
		        }

		    } catch (final SQLException exception) {
		        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION + exception.getMessage();
		        throw NoseException.create(exception, userMessage, technicalMessage);
		    } catch (final Exception exception) {
		        var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION.getContent();
		        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION.getContent() + exception.getMessage();
		        throw NoseException.create(exception, userMessage, technicalMessage);
		    }

		    return identificationTypes;
		}

	@Override
	public IdentificationTypeEntity findById(final UUID id) {
		return findByFilter(new IdentificationTypeEntity(id)).stream().findFirst().orElse(new IdentificationTypeEntity());
	}

}


