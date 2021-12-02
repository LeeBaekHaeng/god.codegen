package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodDatabaseMetaData_getExportedKeys {

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
			String table = "comtccmmncode";

			try (

					ResultSet exportedKeys = metaData.getExportedKeys(catalog, schema, table);

			) {

				int i = 1;

				while (exportedKeys.next()) {
					log.debug("i={}", i);
					log.debug("PKTABLE_CAT={}", exportedKeys.getString("PKTABLE_CAT"));
					log.debug("PKTABLE_SCHEM={}", exportedKeys.getString("PKTABLE_SCHEM"));
					log.debug("PKTABLE_NAME={}", exportedKeys.getString("PKTABLE_NAME"));
					log.debug("PKCOLUMN_NAME={}", exportedKeys.getString("PKCOLUMN_NAME"));
					log.debug("FKTABLE_CAT={}", exportedKeys.getString("FKTABLE_CAT"));
					log.debug("FKTABLE_SCHEM={}", exportedKeys.getString("FKTABLE_SCHEM"));
					log.debug("FKTABLE_NAME={}", exportedKeys.getString("FKTABLE_NAME"));
					log.debug("FKCOLUMN_NAME={}", exportedKeys.getString("FKCOLUMN_NAME"));
					log.debug("KEY_SEQ={}", exportedKeys.getShort("KEY_SEQ"));
					log.debug("UPDATE_RULE={}", exportedKeys.getShort("UPDATE_RULE"));
					log.debug("DELETE_RULE={}", exportedKeys.getShort("DELETE_RULE"));
					log.debug("FK_NAME={}", exportedKeys.getString("FK_NAME"));
					log.debug("PK_NAME={}", exportedKeys.getString("PK_NAME"));
					log.debug("DEFERRABILITY={}", exportedKeys.getShort("DEFERRABILITY"));
					log.debug("");

					i++;
				}

			}

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
