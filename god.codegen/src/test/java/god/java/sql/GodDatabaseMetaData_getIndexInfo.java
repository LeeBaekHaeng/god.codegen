package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodDatabaseMetaData_getIndexInfo {

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
			boolean unique = false;
			boolean approximate = false;

			try (

					ResultSet indexInfo = metaData.getIndexInfo(catalog, schema, table, unique, approximate);

			) {

				int i = 1;

				while (indexInfo.next()) {
					log.debug("i={}", i);
					log.debug("TABLE_CAT={}", indexInfo.getString("TABLE_CAT"));
					log.debug("TABLE_SCHEM={}", indexInfo.getString("TABLE_SCHEM"));
					log.debug("TABLE_NAME={}", indexInfo.getString("TABLE_NAME"));
					log.debug("NON_UNIQUE={}", indexInfo.getBoolean("NON_UNIQUE"));
					log.debug("INDEX_QUALIFIER={}", indexInfo.getString("INDEX_QUALIFIER"));
					log.debug("INDEX_NAME={}", indexInfo.getString("INDEX_NAME"));
					log.debug("TYPE={}", indexInfo.getShort("TYPE"));
					log.debug("ORDINAL_POSITION={}", indexInfo.getShort("ORDINAL_POSITION"));
					log.debug("COLUMN_NAME={}", indexInfo.getString("COLUMN_NAME"));
					log.debug("ASC_OR_DESC={}", indexInfo.getString("ASC_OR_DESC"));
					log.debug("CARDINALITY={}", indexInfo.getLong("CARDINALITY"));
					log.debug("PAGES={}", indexInfo.getLong("PAGES"));
					log.debug("FILTER_CONDITION={}", indexInfo.getString("FILTER_CONDITION"));
					log.debug("");

					i++;
				}

			}

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
