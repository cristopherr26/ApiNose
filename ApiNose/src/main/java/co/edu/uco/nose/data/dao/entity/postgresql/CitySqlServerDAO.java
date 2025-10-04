package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;

public final class CitySqlServerDAO extends SqlConnection implements CityDAO {

	protected CitySqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<CityEntity> findAll() {
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		return null;
	}

}
