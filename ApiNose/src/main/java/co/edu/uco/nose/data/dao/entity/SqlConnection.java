package co.edu.uco.nose.data.dao.entity;

import java.sql.Connection;


import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;

public abstract class SqlConnection {
	
	private Connection connection;
	
	protected SqlConnection(final Connection connection) {
		
		setConnection(connection);
		
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		
		SqlConnectionHelper.ensureConnectionIsOpen(connection);
		
		this.connection = connection;
	
	}
	
	

}
