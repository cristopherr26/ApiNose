package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public final class IdentificationTypePostgreSqlDAO extends SqlConnection implements IdentificationTypeDAO {

	public IdentificationTypePostgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<IdentificationTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdentificationTypeEntity> findByFilter(IdentificationTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentificationTypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
