package connectionPool;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import fr.pds.floralis.server.configurationpool.DataSource;
import fr.pds.floralis.server.configurationpool.JDBCConnectionPool;

public class DataSourceTest {

	
	public void TestConnection() throws ClassNotFoundException, SQLException {
		JDBCConnectionPool jdbc = new JDBCConnectionPool();

		try {
			DataSource.createPool();
			for (int i = 1; i < 10; i++) {
				Connection connection = DataSource.getConnectionFromPool(jdbc);
				System.out.println("Connection " + i + " Used: " + connection);
				assertNotNull(connection);
				System.out.println();
			}
			
			Connection connection2 = DataSource.getConnectionFromPool(jdbc);
			System.out.println("Connection 10 Used: " + connection2);
			assertNotNull(connection2);
			System.out.println();
			
			/*
			 * You can toggle the next line to get the error when we ask for a connection
			 * and that our available connections are all used
			 */
			DataSource.backConnection(jdbc, connection2);
			
			Connection connection3 = DataSource.getConnectionFromPool(jdbc);
			assertNotNull(connection3);
			
			DataSource.close(jdbc);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
