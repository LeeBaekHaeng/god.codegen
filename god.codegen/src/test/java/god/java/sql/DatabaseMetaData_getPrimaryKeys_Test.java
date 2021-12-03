package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DatabaseMetaData_getPrimaryKeys_Test {

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
			String schema = null;
			String table = "%";

			try (

					ResultSet primaryKeys = metaData.getPrimaryKeys(catalog, schema, table);

			) {

				int i = 1;

				while (primaryKeys.next()) {
					log.debug("i={}", i);
					log.debug("TABLE_CAT={}", primaryKeys.getString("TABLE_CAT"));
					log.debug("TABLE_SCHEM={}", primaryKeys.getString("TABLE_SCHEM"));
					log.debug("TABLE_NAME={}", primaryKeys.getString("TABLE_NAME"));
					log.debug("COLUMN_NAME={}", primaryKeys.getString("COLUMN_NAME"));
					log.debug("KEY_SEQ={}", primaryKeys.getShort("KEY_SEQ"));
					log.debug("PK_NAME={}", primaryKeys.getString("PK_NAME"));
					log.debug("");

					i++;
				}

			}

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
