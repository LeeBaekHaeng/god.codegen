package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DatabaseMetaData_getTables_Test {

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

			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String types[] = {};

			try (

					ResultSet tables = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);

			) {

				int i = 1;

				while (tables.next()) {
					log.debug("i={}", i);

					log.debug("TABLE_CAT={}", tables.getString("TABLE_CAT"));
					log.debug("TABLE_SCHEM={}", tables.getString("TABLE_SCHEM"));
					log.debug("TABLE_NAME={}", tables.getString("TABLE_NAME"));
					log.debug("TABLE_TYPE={}", tables.getString("TABLE_TYPE"));
					log.debug("REMARKS={}", tables.getString("REMARKS"));
					log.debug("TYPE_CAT={}", tables.getString("TYPE_CAT"));
					log.debug("TYPE_SCHEM={}", tables.getString("TYPE_SCHEM"));
					log.debug("TYPE_NAME={}", tables.getString("TYPE_NAME"));
					log.debug("SELF_REFERENCING_COL_NAME={}", tables.getString("SELF_REFERENCING_COL_NAME"));
					log.debug("REF_GENERATION={}", tables.getString("REF_GENERATION"));

					log.debug("");

					i++;
				}

			}

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
