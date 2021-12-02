package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodDatabaseMetaData_getColumns {

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
			String tableNamePattern = "%";
			String columnNamePattern = null;

			try (

					ResultSet columns = metaData.getColumns(catalog, schemaPattern, tableNamePattern,
							columnNamePattern);

			) {

				int i = 1;

				while (columns.next()) {
					log.debug("i={}", i);
					log.debug("TABLE_CAT={}", columns.getString("TABLE_CAT"));
					log.debug("TABLE_SCHEM={}", columns.getString("TABLE_SCHEM"));
					log.debug("TABLE_NAME={}", columns.getString("TABLE_NAME"));
					log.debug("COLUMN_NAME={}", columns.getString("COLUMN_NAME"));
					log.debug("DATA_TYPE={}", columns.getInt("DATA_TYPE"));
					log.debug("TYPE_NAME={}", columns.getString("TYPE_NAME"));
					log.debug("COLUMN_SIZE={}", columns.getInt("COLUMN_SIZE"));
					log.debug("BUFFER_LENGTH={}", columns.getString("BUFFER_LENGTH")); // TODO String ?
					log.debug("DECIMAL_DIGITS={}", columns.getInt("DECIMAL_DIGITS"));
					log.debug("NUM_PREC_RADIX={}", columns.getInt("NUM_PREC_RADIX"));
					log.debug("NULLABLE={}", columns.getInt("NULLABLE"));
					log.debug("REMARKS={}", columns.getString("REMARKS"));
					log.debug("COLUMN_DEF={}", columns.getString("COLUMN_DEF"));
					log.debug("SQL_DATA_TYPE={}", columns.getInt("SQL_DATA_TYPE"));
					log.debug("SQL_DATETIME_SUB={}", columns.getInt("SQL_DATETIME_SUB"));
					log.debug("CHAR_OCTET_LENGTH={}", columns.getInt("CHAR_OCTET_LENGTH"));
					log.debug("ORDINAL_POSITION={}", columns.getInt("ORDINAL_POSITION"));
					log.debug("IS_NULLABLE={}", columns.getString("IS_NULLABLE"));
					log.debug("SCOPE_CATALOG={}", columns.getString("SCOPE_CATALOG"));
					log.debug("SCOPE_SCHEMA={}", columns.getString("SCOPE_SCHEMA"));
					log.debug("SCOPE_TABLE={}", columns.getString("SCOPE_TABLE"));
					log.debug("SOURCE_DATA_TYPE={}", columns.getShort("SOURCE_DATA_TYPE"));
					log.debug("IS_AUTOINCREMENT={}", columns.getString("IS_AUTOINCREMENT"));
					log.debug("IS_GENERATEDCOLUMN={}", columns.getString("IS_GENERATEDCOLUMN"));
					log.debug("");

					i++;
				}

			}

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

}
