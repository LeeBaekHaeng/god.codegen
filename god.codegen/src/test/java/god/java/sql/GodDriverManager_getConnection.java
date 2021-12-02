package god.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodDriverManager_getConnection {

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

			log.debug("con={}", con);
			log.debug("getCatalog={}", con.getCatalog());
			log.debug("getSchema={}", con.getSchema());
			log.debug("getTypeMap={}", con.getTypeMap());

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
