package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.mapper.CityMapper;
import co.edu.uco.nose.entity.CityEntity;


public final class CityPostgreSqlDAO extends SqlConnection implements CityDAO {

	public CityPostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<CityEntity> findAll() {
		final var sql = new StringBuilder();

	    final var cities = new ArrayList<CityEntity>();

	    sql.append("SELECT ");
	    sql.append("  c.id AS idCiudad, ");
	    sql.append("  c.nombre AS nombreCiudad, ");
	    sql.append("  d.id AS idDepartamento, ");
	    sql.append("  d.nombre AS nombreDepartamento, ");
	    sql.append("  p.id AS idPais, ");
	    sql.append("  p.nombre AS nombrePais ");
	    sql.append("FROM \"Ciudad\" AS c ");
		sql.append("INNER JOIN \"Departamento\" AS d ");
		sql.append("  ON c.departamento = d.id ");
		sql.append("INNER JOIN \"Pais\" AS p ");
		sql.append("  ON d.pais = p.id;");

	    try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {


	        try (var resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {

	                var city = CityMapper.map(resultSet);
	                
	                cities.add(city);
	            }
	        }

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_CITY.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_CITY.getContent()
	                + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage =MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY.getContent();
	        var technicalMessage =MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }

	    return cities;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		final var sql = new StringBuilder();

	    var city = new CityEntity();

	    sql.append("SELECT ");
	    sql.append("  c.id AS idCiudad, ");
	    sql.append("  c.nombre AS nombreCiudad, ");
	    sql.append("  d.id AS idDepartamento, ");
	    sql.append("  d.nombre AS nombreDepartamento, ");
	    sql.append("  p.id AS idPais, ");
	    sql.append("  p.nombre AS nombrePais ");
	    sql.append("FROM \"Ciudad\" AS c ");
		sql.append("INNER JOIN \"Departamento\" AS d ");
		sql.append("  ON c.departamento = d.id ");
		sql.append("INNER JOIN \"Pais\" AS p ");
		sql.append("  ON d.pais = p.id;");
	    sql.append("WHERE c.id = ?; ");

	    try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

	        preparedStatement.setObject(1, id);

	        try (var resultSet = preparedStatement.executeQuery()) {

	            if (resultSet.next()) {

	                city = CityMapper.map(resultSet);
	            }
	        }

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_FINDING_CITY.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_CITY.getContent()
	                + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage =MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY.getContent();
	        var technicalMessage =MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY.getContent() + exception.getMessage();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }

	    return city;
	}

}
