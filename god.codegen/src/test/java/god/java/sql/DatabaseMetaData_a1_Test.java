package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DatabaseMetaData_a1_Test {

	@Test
	void test() {
		log.debug("test");

//		String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com";
		String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
		String user = "com";
		String password = "com01";

		try (

				Connection con = DriverManager.getConnection(url, user, password);

		) {

			DatabaseMetaData metaData = con.getMetaData();

			log.debug("getDatabaseProductName={}", metaData.getDatabaseProductName());
			log.debug("getDatabaseProductName={}", metaData.getDatabaseProductVersion());

			log.debug("getDatabaseProductName={}", metaData.getDriverName());
			log.debug("getDatabaseProductName={}", metaData.getDriverVersion());

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
