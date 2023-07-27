package god.test.java.sql;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.egovframe.rte.psl.dataaccess.util.CamelUtil;
import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ResultSet 메타데이터 기본 키 가져오기 테스트
 * 
 * @author 이백행
 * @since 2023-07-27
 */
@NoArgsConstructor
@Slf4j
public class GodTestResultSetMetaDataGetPrimaryKeys {

    /**
     * GodTestJavaSql
     */
    private final GodTestJavaSql godTestJavaSql = new GodTestJavaSql();

    /**
     * test
     */
    @Test
    public void test() {
        log.debug("test");

        final String catalog = "com";

        final String schema = null;
//        final String schema = "";

        final String table = "comtcadministcode"; // 행정코드
//        final String table = "COMTCADMINISTCODE"; // 행정코드

        try (Connection con = godTestJavaSql.getConnection()) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            godTestJavaSql.debug(con, databaseMetaData);
            debug(databaseMetaData, catalog, schema, table);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void debug(final DatabaseMetaData databaseMetaData, final String catalog, final String schema,
            final String table) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schema={}", schema);
            log.debug("table={}", table);
        }
        try (ResultSet rs = databaseMetaData.getPrimaryKeys(catalog, schema, table)) {
            resultSetMetaData(rs.getMetaData());
            primaryKeys(rs);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getPrimaryKeys");
        }
    }

    private void resultSetMetaData(final ResultSetMetaData resultSetMetaData) throws SQLException {
        final int columnCount = resultSetMetaData.getColumnCount();
        log.debug("columnCount={}", columnCount);

        final StringBuffer sb = new StringBuffer(1600);
        final StringBuffer sb2 = new StringBuffer(1600);

        for (int column = 1; column < columnCount; column++) {
            if (log.isDebugEnabled()) {
                log.debug("column={}", column);

                final String columnLabel = resultSetMetaData.getColumnLabel(column);
//                final String columnLabel = resultSetMetaData.getColumnName(column);
//                final String columnLabel = resultSetMetaData.getSchemaName(column);
                final String columnLabelCcName = CamelUtil.convert2CamelCase(columnLabel);

                final int columnType = resultSetMetaData.getColumnType(column);
                final String columnTypeName = resultSetMetaData.getColumnTypeName(column);

                log.debug("columnLabel={}", columnLabel);
                log.debug("columnType={}", columnType);
                log.debug("columnTypeName={}", columnTypeName);
                log.debug("");

                if (columnType == 4 || columnType == 5) {
                    sb.append("final int " + columnLabelCcName + " = rs.getInt(\"" + columnLabel + "\");\n");
                } else {
                    sb.append("final String " + columnLabelCcName + " = rs.getString(\"" + columnLabel + "\");\n");
                }

                sb2.append("log.debug(\"" + columnLabel + "={}\", " + columnLabelCcName + ");\n");
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
            log.debug(sb2.toString());
        }
    }

    private void primaryKeys(final ResultSet rs) throws SQLException {
        int i = 1;
        while (rs.next()) {
            final String tableCat = rs.getString("TABLE_CAT");
            final String tableSchem = rs.getString("TABLE_SCHEM");
            final String tableName = rs.getString("TABLE_NAME");
            final String columnName = rs.getString("COLUMN_NAME");
            final int keySeq = rs.getInt("KEY_SEQ");

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("TABLE_CAT={}", tableCat);
                log.debug("TABLE_SCHEM={}", tableSchem);
                log.debug("TABLE_NAME={}", tableName);
                log.debug("COLUMN_NAME={}", columnName);
                log.debug("KEY_SEQ={}", keySeq);

                log.debug("");
            }

            i++;
        }
    }

}
