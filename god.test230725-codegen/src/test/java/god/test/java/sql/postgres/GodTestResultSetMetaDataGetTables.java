package god.test.java.sql.postgres;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import org.egovframe.rte.psl.dataaccess.util.CamelUtil;
import org.junit.Test;

import god.test.java.sql.GodTestJavaSql;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ResultSet 메타데이터 테이블 가져오기 테스트
 * 
 * @author 이백행
 * @since 2023-08-25
 */
@NoArgsConstructor
@Slf4j
public class GodTestResultSetMetaDataGetTables {

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

        final String schemaPattern = "public";

        final String tableNamePattern = null;

        final String[] types = null;
//        final String[] types = { "TABLE", "VIEW" };

        try (Connection con = godTestJavaSql.getConnectionPostgres()) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            godTestJavaSql.debug(con, databaseMetaData);
            tables(databaseMetaData, catalog, schemaPattern, tableNamePattern, types);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void tables(final DatabaseMetaData databaseMetaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String... types) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schemaPattern={}", schemaPattern);
            log.debug("tableNamePattern={}", tableNamePattern);
            log.debug("types={}", Arrays.toString(types));
        }
        try (ResultSet rs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types)) {
            resultSetMetaData(rs.getMetaData());
            tables(rs);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getTables");
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

                sb.append("final String " + columnLabelCcName + " = rs.getString(\"" + columnLabel + "\");\n");

                sb2.append("log.debug(\"" + columnLabel + "={}\", " + columnLabelCcName + ");\n");
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
            log.debug(sb2.toString());
        }
    }

    private void tables(final ResultSet rs) throws SQLException {
        int i = 1;
        while (rs.next()) {
            final String tableCat = rs.getString("TABLE_CAT");
            final String tableSchem = rs.getString("TABLE_SCHEM");
            final String tableName = rs.getString("TABLE_NAME");
            final String tableType = rs.getString("TABLE_TYPE");
            final String remarks = rs.getString("REMARKS");
            final String typeCat = rs.getString("TYPE_CAT");
            final String typeSchem = rs.getString("TYPE_SCHEM");
            final String typeName = rs.getString("TYPE_NAME");
            final String selfReferencingColName = rs.getString("SELF_REFERENCING_COL_NAME");

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("TABLE_CAT={}", tableCat);
                log.debug("TABLE_SCHEM={}", tableSchem);
                log.debug("TABLE_NAME={}", tableName);
                log.debug("TABLE_TYPE={}", tableType);
                log.debug("REMARKS={}", remarks);
                log.debug("TYPE_CAT={}", typeCat);
                log.debug("TYPE_SCHEM={}", typeSchem);
                log.debug("TYPE_NAME={}", typeName);
                log.debug("SELF_REFERENCING_COL_NAME={}", selfReferencingColName);
                log.debug("");
            }

            i++;
        }
    }

}
