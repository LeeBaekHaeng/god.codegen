package god.test.java.sql.postgres;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.egovframe.rte.psl.dataaccess.util.CamelUtil;
import org.junit.Test;

import god.test.java.sql.GodTestJavaSql;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * GodTestResultSetMetaDatagetIndexInfo
 * 
 * @author 이백행
 * @since 2023-09-25
 */
@NoArgsConstructor
@Slf4j
public class GodTestResultSetMetaDatagetIndexInfo {

    /**
     * GodTestJavaSql
     */
    private final GodTestJavaSql godTestJavaSql = new GodTestJavaSql();

    /**
     * test
     * 
     * @throws SQLException
     */
    @Test
    public void test() throws SQLException {
        log.debug("test");

        try (Connection con = godTestJavaSql.getConnectionPostgres()) {
            final DatabaseMetaData dmd = con.getMetaData();

            try (ResultSet rs = dmd.getIndexInfo(null, "com", "comtcadministcode", false, false)) {
                resultSetMetaData(rs.getMetaData());
                debug(rs);
            }
        }

        assertEquals("", "", "");
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

    private void debug(final ResultSet rs) throws SQLException {
        int i = 1;
        while (rs.next()) {
            final String tableCat = rs.getString("TABLE_CAT");
            final String tableSchem = rs.getString("TABLE_SCHEM");
            final String tableName = rs.getString("TABLE_NAME");
            final String nonUnique = rs.getString("NON_UNIQUE");
            final String indexQualifier = rs.getString("INDEX_QUALIFIER");
            final String indexName = rs.getString("INDEX_NAME");
            final String type = rs.getString("TYPE");
            final String ordinalPosition = rs.getString("ORDINAL_POSITION");
            final String columnName = rs.getString("COLUMN_NAME");
            final String ascOrDesc = rs.getString("ASC_OR_DESC");
            final String cardinality = rs.getString("CARDINALITY");
            final String pages = rs.getString("PAGES");

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("TABLE_CAT={}", tableCat);
                log.debug("TABLE_SCHEM={}", tableSchem);
                log.debug("TABLE_NAME={}", tableName);
                log.debug("NON_UNIQUE={}", nonUnique);
                log.debug("INDEX_QUALIFIER={}", indexQualifier);
                log.debug("INDEX_NAME={}", indexName);
                log.debug("TYPE={}", type);
                log.debug("ORDINAL_POSITION={}", ordinalPosition);
                log.debug("COLUMN_NAME={}", columnName);
                log.debug("ASC_OR_DESC={}", ascOrDesc);
                log.debug("CARDINALITY={}", cardinality);
                log.debug("PAGES={}", pages);

                log.debug("");
            }

            i++;
        }
    }

}
