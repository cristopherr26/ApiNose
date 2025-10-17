package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
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
		final var identificationTypes = new ArrayList<IdentificationTypeEntity>();
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("  t.id, ");
		sql.append("  t.nombre, ");
		sql.append("  from \"Tipolidentificacion\" as t ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				while (resultSet.next()) {
					
					var identificationType = new IdentificationTypeEntity();
					
					identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					identificationType.setName(resultSet.getString("nombre"));
					identificationTypes.add(identificationType);
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATIONTYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTFICATIONTYPE.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return identificationTypes;
	}


	@Override
	public List<IdentificationTypeEntity> findByFilter(IdentificationTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentificationTypeEntity findById(UUID id) {
		
		final var identificationType = new IdentificationTypeEntity();
		final var sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("  t.id, ");
		sql.append("  t.nombre, ");
		sql.append("  from \"Tipolidentificacion\" as t ");
		sql.append("  where t.id = ? ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				if(resultSet.next()) {
					
					identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					identificationType.setName(resultSet.getString("nombre"));
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATIONTYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTFICATIONTYPE.getContent() + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return identificationType;
	}

}


