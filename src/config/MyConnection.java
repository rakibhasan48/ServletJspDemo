package config;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyConnection {
	private DataSource dataSource;
	
	public void setConnection(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public Connection getMyConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
