package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import co.edu.uco.nose.entity.StateEntity;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgreSqlDAO extends SqlConnection implements UserDAO {

	public UserPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql= new StringBuilder();
		sql.append("INSERT INTO Usuario(id, tipoIdentificacion, numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, ciudadResidencia, correoElectronico, numeroTelefonoMovil, correoElectronicoConfirmado, numeroTelefonoMovilConfirmado) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getIdentificationType().getId());
			preparedStatement.setString(3, entity.getIdentificationNumber());
			preparedStatement.setString(4, entity.getFirstName());
			preparedStatement.setString(5, entity.getMiddleName());
			preparedStatement.setString(6, entity.getLastName());
			preparedStatement.setString(7, entity.getSecondLastName());
			preparedStatement.setObject(8, entity.getResidenceCity().getId());
			preparedStatement.setString(9, entity.getEmail());
			preparedStatement.setString(10, entity.getCellPhoneNumber());
			preparedStatement.setBoolean(11, entity.isEmailConfirmed());
			preparedStatement.setBoolean(12, entity.isCellPhoneNumberConfirmed());
			
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de registrar la información del nuevo usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
			var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar el registro de un nuevo usuario " + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
			var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar el registro de un nuevo usuario " + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findById(final UUID id) {
		
		final var sql = new StringBuilder();
		
		var User = new UserEntity();
		
		sql.append("SELECT ");
		sql.append("  u.id, ");
		sql.append("  ti.id AS idTipoIdentificacion, ");
		sql.append("  ti.nombre AS nombreTipoIdentificacion, ");
		sql.append("  u.numeroIdentificacion, ");
		sql.append("  u.primerNombre, ");
		sql.append("  u.segundoNombre, ");
		sql.append("  u.primerApellido, ");
		sql.append("  u.segundoApellido, ");
		sql.append("  c.id AS idCiudadResidencia, ");
		sql.append("  c.nombre AS nombreCiudadResidencia, ");
		sql.append("  d.id AS idDepartamentoCiudadResidencia, ");
		sql.append("  d.nombre AS nombreDepartamentoCiudadResidencia, ");
		sql.append("  p.id AS idPaisDepartamentoCiudadResidencia, ");
		sql.append("  p.nombre AS nombrePaisDepartamentoCiudadResidencia, ");
		sql.append("  u.correoElectronico, ");
		sql.append("  u.numeroTelefonoMovil, ");
		sql.append("  u.correoElectronicoConfirmado, ");
		sql.append("  u.numeroTelefonoMovilConfirmado ");
		sql.append("FROM Usuario AS u ");
		sql.append("INNER JOIN TipoIdentificacion AS ti ");
		sql.append("  ON u.tipoIdentificacion = ti.id ");
		sql.append("INNER JOIN Ciudad AS c ");
		sql.append("  ON u.ciudadResidencia = c.id ");
		sql.append("INNER JOIN Departamento AS d ");
		sql.append("  ON c.departamento = d.id ");
		sql.append("INNER JOIN Pais AS p ");
		sql.append("  ON d.pais = p.id;");
		sql.append("WHERE u.id = ? ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try(var resultSet = preparedStatement.executeQuery()){
				
				if(resultSet.next()) {
					
					var identificationType = new IdentificationTypeEntity();
					identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
					identificationType.setName(resultSet.getString("nombreTipoIdentificacion"));
					
					var country = new CountryEntity();
					country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPaisDepartamentoCiudadResidencia")));
					country.setName(resultSet.getString("nombrePaisDepartamentoCiudadResidencia"));
					
					var state = new StateEntity();
					state.setCountry(country);
					state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamentoCiudadResidencia")));
					state.setName(resultSet.getString("nombreDepartamentoCiudadResidencia"));
					
					var city = new CityEntity();
					city.setState(state);
					city.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCiudadResidencia")));
					city.setName(resultSet.getString("nombreCiudadResidencia"));
					
					User.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					User.setIdentificationType(identificationType);
					User.setIdentificationNumber(resultSet.getString("numeroIdentificacion"));
					User.setFirstName(resultSet.getString("primerNombre"));
					User.setMiddleName(resultSet.getString("segundoNombre"));
					User.setLastName(resultSet.getString("primerApellido"));
					User.setSecondLastName(resultSet.getString("segundoApellido"));
					User.setResidenceCity(city);
					User.setEmail(resultSet.getString("correoElectronico"));
					User.setCellPhoneNumber(resultSet.getString("numeroTelefonoMovil"));
					User.setEmailConfirmed(resultSet.getBoolean("correoElectronicoConfirmado"));
					User.setCellPhoneNumberConfirmed(resultSet.getBoolean("numeroTelefonoMovilConfirmado"));
					
				}
				
			}

		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de consultar la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
			var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del usuario " + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de consultar la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
			var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del usuario " + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return User;
	}
		

	@Override
	public void update(UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql= new StringBuilder();
		sql.append("UPDATE Usuario ");
		sql.append("SET tipoIdentificacion=?");
		sql.append("primerNombre=?");
		sql.append("segundoNombre=?");
		sql.append("primerApellido=?");
		sql.append("segundoApellido=?");
		sql.append("ciudadResidencia=?");
		sql.append("correoElectronico=?");
		sql.append("numeroTelefonoMovil=?");
		sql.append("correoElectronicoConfirmado=?");
		sql.append("numeroTelefonoMovilConfirmado=?");
		sql.append("WHERE id=?");
		
	try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
				
		preparedStatement.setObject(1, entity.getIdentificationType().getId());
		preparedStatement.setString(2, entity.getFirstName());
		preparedStatement.setString(3, entity.getMiddleName());
		preparedStatement.setString(4, entity.getLastName());
		preparedStatement.setString(5, entity.getSecondLastName());
		preparedStatement.setObject(6, entity.getResidenceCity().getId());
		preparedStatement.setString(7, entity.getEmail());
		preparedStatement.setString(8, entity.getCellPhoneNumber());
		preparedStatement.setBoolean(9, entity.isEmailConfirmed());
		preparedStatement.setBoolean(10, entity.isCellPhoneNumberConfirmed());
				
		preparedStatement.executeUpdate();
	
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de actualizar la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
			var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar la actualización de un usuario " + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de actualizar la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
			var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar la actualización de un usuario " + exception.getMessage();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
		
	

	@Override
	public void delete(UUID id) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql= new StringBuilder();
		sql.append("DELETE FROM Usuario ");
		sql.append("WHERE id=?");
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
		preparedStatement.setObject(1, id);
		preparedStatement.executeUpdate();
	
		} catch (final SQLException exception) {
				var userMessage = "Se ha presentado un problema tratando de eliminar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
				var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar " + exception.getMessage();
				throw NoseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
				var userMessage = "Se ha presentado un problema inesperado tratando de eliminar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
				var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar " + exception.getMessage();
				throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
		
}

