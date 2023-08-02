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
 * ResultSet 메타데이터 컬럼 가져오기 테스트
 * 
 * @author 이백행
 * @since 2023-07-27
 */
@NoArgsConstructor
@Slf4j
public class GodTestResultSetMetaDataGetColumns {

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

//        final String catalog = null;
        final String catalog = "com";

        final String schemaPattern = null;

        final String tableNamePattern = null;
//        final String tableNamePattern = "%%";
//        final String tableNamePattern = "%com%";
//        final String tableNamePattern = "comtcadministcode"; // 행정코드
//        final String tableNamePattern = "COMTCADMINISTCODE"; // 행정코드

        final String columnNamePattern = null;
//        final String columnNamePattern = "%%";

        try (Connection con = godTestJavaSql.getConnection()) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            godTestJavaSql.debug(con, databaseMetaData);
            debug(databaseMetaData, catalog, schemaPattern, tableNamePattern, columnNamePattern);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void debug(final DatabaseMetaData databaseMetaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String columnNamePattern) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schemaPattern={}", schemaPattern);
            log.debug("tableNamePattern={}", tableNamePattern);
            log.debug("columnNamePattern={}", columnNamePattern);
        }
        try (ResultSet rs = databaseMetaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)) {
            resultSetMetaData(rs.getMetaData());
            columns(rs);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getColumns");
        }
    }

    private void resultSetMetaData(final ResultSetMetaData resultSetMetaData) throws SQLException {
        final int columnCount = resultSetMetaData.getColumnCount();
        log.debug("columnCount={}", columnCount);

        final StringBuffer sb = new StringBuffer(1600);
        final StringBuffer sb2 = new StringBuffer(1600);
        final StringBuffer sb3 = new StringBuffer(1600);
        final StringBuffer sb4 = new StringBuffer(1600);

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

                sb3.append("    /**\n");
                sb3.append("     * ");
                sb3.append(columnLabel);
                sb3.append("\n");
                sb3.append("     */\n");

                if (columnType == 4 || columnType == 5) {
                    sb.append("final int " + columnLabelCcName + " = rs.getInt(\"" + columnLabel + "\");\n");
                    sb3.append("    private int " + columnLabelCcName + ";\n");
                } else {
                    sb.append("final String " + columnLabelCcName + " = rs.getString(\"" + columnLabel + "\");\n");
                    sb3.append("    private String " + columnLabelCcName + ";\n");
                }

                sb2.append("log.debug(\"" + columnLabel + "={}\", " + columnLabelCcName + ");\n");

                sb3.append("\n");

                sb4.append("." + columnLabelCcName + "(" + columnLabelCcName + ")");
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
            log.debug(sb2.toString());
            log.debug(sb3.toString());
            log.debug(sb4.toString());
        }
    }

    private void columns(final ResultSet rs) throws SQLException {
        int i = 1;
        while (rs.next()) {
            final String tableCat = rs.getString("TABLE_CAT");
            final String tableSchem = rs.getString("TABLE_SCHEM");
            final String tableName = rs.getString("TABLE_NAME");
            final String columnName = rs.getString("COLUMN_NAME");
            final int dataType = rs.getInt("DATA_TYPE");
            final String typeName = rs.getString("TYPE_NAME");
            final int columnSize = rs.getInt("COLUMN_SIZE");
            final int bufferLength = rs.getInt("BUFFER_LENGTH");
            final int decimalDigits = rs.getInt("DECIMAL_DIGITS");
            final int numPrecRadix = rs.getInt("NUM_PREC_RADIX");
            final int nullable = rs.getInt("NULLABLE");
            final String remarks = rs.getString("REMARKS");
            final String columnDef = rs.getString("COLUMN_DEF");
            final int sqlDataType = rs.getInt("SQL_DATA_TYPE");
            final int sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB");
            final int charOctetLength = rs.getInt("CHAR_OCTET_LENGTH");
            final int ordinalPosition = rs.getInt("ORDINAL_POSITION");
            final String sisNullable = rs.getString("IS_NULLABLE");
            final String scopeCatalog = rs.getString("SCOPE_CATALOG");
            final String scopeSchema = rs.getString("SCOPE_SCHEMA");
            final String scopeTable = rs.getString("SCOPE_TABLE");
            final int sourceDataType = rs.getInt("SOURCE_DATA_TYPE");
            final String sisAutoincrement = rs.getString("IS_AUTOINCREMENT");

            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("TABLE_CAT={}", tableCat);
                log.debug("TABLE_SCHEM={}", tableSchem);
                log.debug("TABLE_NAME={}", tableName);
                log.debug("COLUMN_NAME={}", columnName);
                log.debug("DATA_TYPE={}", dataType);
                log.debug("TYPE_NAME={}", typeName);
                log.debug("COLUMN_SIZE={}", columnSize);
                log.debug("BUFFER_LENGTH={}", bufferLength);
                log.debug("DECIMAL_DIGITS={}", decimalDigits);
                log.debug("NUM_PREC_RADIX={}", numPrecRadix);
                log.debug("NULLABLE={}", nullable);
                log.debug("REMARKS={}", remarks);
                log.debug("COLUMN_DEF={}", columnDef);
                log.debug("SQL_DATA_TYPE={}", sqlDataType);
                log.debug("SQL_DATETIME_SUB={}", sqlDatetimeSub);
                log.debug("CHAR_OCTET_LENGTH={}", charOctetLength);
                log.debug("ORDINAL_POSITION={}", ordinalPosition);
                log.debug("IS_NULLABLE={}", sisNullable);
                log.debug("SCOPE_CATALOG={}", scopeCatalog);
                log.debug("SCOPE_SCHEMA={}", scopeSchema);
                log.debug("SCOPE_TABLE={}", scopeTable);
                log.debug("SOURCE_DATA_TYPE={}", sourceDataType);
                log.debug("IS_AUTOINCREMENT={}", sisAutoincrement);
                log.debug("");
            }

            i++;
        }
    }

}
