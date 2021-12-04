package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ResultSetMetaData_a2_Test {

	@Test
	void test() {
		try (

				Connection con = GodDriverManager_a1.getConnection();

		) {

			DatabaseMetaData dmd = con.getMetaData();

			try (

					ResultSet tables = dmd.getTables(null, null, null, null);
//					ResultSet rs = dmd.getColumns(null, null, null, null);

			) {

				tables.next();

				try (ResultSet rs = dmd.getPrimaryKeys(null, null, tables.getString("TABLE_NAME"))) {

					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					StringBuffer sb = new StringBuffer();

					for (int column = 1; column < columnCount; column++) {
						GodResultSetMetaDataDto dto = getGodResultSetMetaDataDto(rsmd, column);
//						debug(sb, dto);
//						vo(sb, dto);
						builder(sb, dto);
					}

					System.out.println(sb);

				}

			}

		} catch (SQLException e) {
			log.error("SQLException");
			e.printStackTrace();
		}
	}

	GodResultSetMetaDataDto getGodResultSetMetaDataDto(ResultSetMetaData rsmd, int column) throws SQLException {
		String columnLabel = rsmd.getColumnLabel(column);
		int columnType = rsmd.getColumnType(column);
		String columnTypeName = rsmd.getColumnTypeName(column);
		String columnClassName = rsmd.getColumnClassName(column);

//		log.debug("column={}", column);
//
//		log.debug("columnLabel={}", columnLabel);
//		log.debug("columnType={}", columnType);
//		log.debug("columnTypeName={}", columnTypeName);
//		log.debug("columnClassName={}", columnClassName);
//
//		log.debug("");

		return GodResultSetMetaDataDto.builder().columnLabel(columnLabel).columnType(columnType)
				.columnTypeName(columnTypeName).columnClassName(columnClassName).build();
	}

	void debug(StringBuffer sb, GodResultSetMetaDataDto dto) {
		sb.append("log.debug(\"");
		sb.append(dto.getColumnLabel());
		sb.append("={}\", rs.get");
		sb.append(dto.getColumnClassName());
		sb.append("(\"");
		sb.append(dto.getColumnLabel());
		sb.append("\"));");
		sb.append("\n");
	}

	void vo(StringBuffer sb, GodResultSetMetaDataDto dto) {
		sb.append("private ");
		sb.append(dto.getColumnClassName());
		sb.append(" ");
		sb.append(dto.getColumnLabelCamelCase());
		sb.append(";\n\n");
	}

	void builder(StringBuffer sb, GodResultSetMetaDataDto dto) {
		sb.append(".");
		sb.append(dto.getColumnLabelCamelCase());
		sb.append("(rs.get");
		sb.append(dto.getColumnClassName());
		sb.append("(\"");
		sb.append(dto.getColumnLabel());
		sb.append("\"))\n\n");
	}

}
