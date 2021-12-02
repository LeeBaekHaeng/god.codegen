package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodResultSetMetaData_all {

	@Test
	void test() {
//		log.debug("test");

//		String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/com";
		String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
		String user = "com";
		String password = "com01";

		try (

				Connection con = DriverManager.getConnection(url, user, password);

		) {

			DatabaseMetaData dmd = con.getMetaData();

			try (

					ResultSet rs = dmd.getTables(null, null, null, null);
//					ResultSet rs = dmd.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);

			) {

				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				StringBuffer sb = new StringBuffer();

				Map<Integer, String> map = new HashMap<>();
				map.put(1, "String");
				map.put(4, "Int");
				map.put(5, "Short");
				map.put(12, "String");

				for (int column = 1; column < columnCount; column++) {
					String columnLabel = rsmd.getColumnLabel(column);
					int columnType = rsmd.getColumnType(column);

//					debug(rsmd, column, columnLabel, columnType);

					sb.append("log.debug(\"");
					sb.append(columnLabel);
					sb.append("={}\", rs.get");
					sb.append(map.get(columnType));
					sb.append("(\"");
					sb.append(columnLabel);
					sb.append("\"));");
					sb.append("\n");
				}

				System.out.println(sb);

			} catch (SQLException e) {
				log.error("getColumns SQLException");
			}

		} catch (SQLException e) {
			log.error("getConnection SQLException");
		}
	}

	void debug(ResultSetMetaData rsmd, int column, String columnLabel, int columnType) throws SQLException {
		log.debug("columnLabel={}", columnLabel);
		log.debug("columnType={}", columnType);
		log.debug("getColumnTypeName={}", rsmd.getColumnTypeName(column));
	}

}
