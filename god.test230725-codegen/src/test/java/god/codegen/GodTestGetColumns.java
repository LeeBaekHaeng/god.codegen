package god.codegen;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.egovframe.rte.fdl.excel.EgovExcelService;
import org.egovframe.rte.fdl.excel.impl.EgovExcelServiceImpl;
import org.egovframe.rte.fdl.string.EgovDateUtil;
import org.egovframe.rte.psl.dataaccess.util.CamelUtil;
import org.junit.Test;

import god.test.java.sql.GodTestJavaSql;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 컬럼 가져와서 엑셀파일 생성
 * 
 * @author 이백행
 * @since 2023-07-28
 */
@NoArgsConstructor
@Slf4j
public class GodTestGetColumns {

    /**
     * GodTestJavaSql
     */
    private final GodTestJavaSql godTestJavaSql = new GodTestJavaSql();

    /**
     * 엑셀 서비스를 제공하는 인터페이스.
     */
    private final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

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

        final String templateName = SystemUtils.USER_HOME + "/Desktop/컬럼_"
                + EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + ".xlsx";
        log.debug("templateName={}", templateName);

        try (Connection con = godTestJavaSql.getConnection()) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            godTestJavaSql.debug(con, databaseMetaData);
            debug(databaseMetaData, catalog, schemaPattern, tableNamePattern, columnNamePattern, templateName);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void debug(final DatabaseMetaData databaseMetaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String columnNamePattern, final String templateName)
            throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schemaPattern={}", schemaPattern);
            log.debug("tableNamePattern={}", tableNamePattern);
            log.debug("columnNamePattern={}", columnNamePattern);
        }
        try (ResultSet rs = databaseMetaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)) {
            resultSetMetaData(rs.getMetaData());
            columns(rs, templateName);
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

        int i = 0;

        for (int column = 1; column < columnCount; column++) {

            final String columnLabel = resultSetMetaData.getColumnLabel(column);
//            final String columnLabel = resultSetMetaData.getColumnName(column);
//            final String columnLabel = resultSetMetaData.getSchemaName(column);
            final String columnLabelCcName = CamelUtil.convert2CamelCase(columnLabel);

            final int columnType = resultSetMetaData.getColumnType(column);
            final String columnTypeName = resultSetMetaData.getColumnTypeName(column);

            if (columnType == 4 || columnType == 5) {
                sb.append(", final int " + columnLabelCcName);
            } else {
                sb.append(", final String " + columnLabelCcName);
            }

//            sb2.append("final Cell cell" + i + " = row.createCell(" + i + ");\n");
            sb2.append("final Cell cell");
            sb2.append(i);
            sb2.append(" = row.createCell(");
            sb2.append(i);
            sb2.append(");\n");
//            sb2.append("if (cell" + i + " != null) {\n");
            sb2.append("if (cell");
            sb2.append(i);
            sb2.append(" != null) {\n");
            sb2.append("cell" + i + ".setCellValue(" + columnLabelCcName + ");\n");
            sb2.append("}\n\n");

//            sb3.append(columnLabel + "\t");
//            sb3.append("final Cell cell" + i + " = row.createCell(" + i + ");\n");
            sb3.append("final Cell cell");
            sb3.append(i);
            sb3.append(" = row.createCell(");
            sb3.append(i);
            sb3.append(");\n");
//            sb3.append("if (cell" + i + " != null) {\n");
            sb3.append("if (cell");
            sb3.append(i);
            sb3.append(" != null) {\n");
            sb3.append("cell" + i + ".setCellValue(\"" + columnLabel + "\");\n");
            sb3.append("}\n\n");

            if (log.isDebugEnabled()) {
                log.debug("column={}", column);

                log.debug("columnLabel={}", columnLabel);
                log.debug("columnType={}", columnType);
                log.debug("columnTypeName={}", columnTypeName);
                log.debug("");

            }

            i++;
        }

        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
            log.debug(sb2.toString());
            log.debug(sb3.toString());
        }
    }

    private void columns(final ResultSet rs, final String templateName) {
        try (Workbook type = new XSSFWorkbook()) {
            final Sheet sheet = type.createSheet("컬럼");
            int rownum = 0;
            createRow(sheet, rownum++);

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

                createRow(sheet, rownum++, tableCat, tableSchem, tableName, columnName, dataType, typeName, columnSize,
                        bufferLength, decimalDigits, numPrecRadix, nullable, remarks, columnDef, sqlDataType,
                        sqlDatetimeSub, charOctetLength, ordinalPosition, sisNullable, scopeCatalog, scopeSchema,
                        scopeTable, sourceDataType, sisAutoincrement);

                i++;
            }

            egovExcelService.createWorkbook(type, templateName);
        } catch (SQLException e) {
//          e.printStackTrace();
            log.error("SQLException");
        } catch (Exception e) {
//        e.printStackTrace();
            log.error("Exception");
        }
    }

    private void createRow(final Sheet sheet, final int rownum) {
        final Row row = sheet.createRow(rownum);
        createCell(row);
    }

    private void createCell(final Row row) {
        final Cell cell0 = row.createCell(0);
        if (cell0 != null) {
            cell0.setCellValue("TABLE_CAT");
        }

        final Cell cell1 = row.createCell(1);
        if (cell1 != null) {
            cell1.setCellValue("TABLE_SCHEM");
        }

        final Cell cell2 = row.createCell(2);
        if (cell2 != null) {
            cell2.setCellValue("TABLE_NAME");
        }

        final Cell cell3 = row.createCell(3);
        if (cell3 != null) {
            cell3.setCellValue("COLUMN_NAME");
        }

        final Cell cell4 = row.createCell(4);
        if (cell4 != null) {
            cell4.setCellValue("DATA_TYPE");
        }

        final Cell cell5 = row.createCell(5);
        if (cell5 != null) {
            cell5.setCellValue("TYPE_NAME");
        }

        final Cell cell6 = row.createCell(6);
        if (cell6 != null) {
            cell6.setCellValue("COLUMN_SIZE");
        }

        final Cell cell7 = row.createCell(7);
        if (cell7 != null) {
            cell7.setCellValue("BUFFER_LENGTH");
        }

        final Cell cell8 = row.createCell(8);
        if (cell8 != null) {
            cell8.setCellValue("DECIMAL_DIGITS");
        }

        final Cell cell9 = row.createCell(9);
        if (cell9 != null) {
            cell9.setCellValue("NUM_PREC_RADIX");
        }

        final Cell cell10 = row.createCell(10);
        if (cell10 != null) {
            cell10.setCellValue("NULLABLE");
        }

        final Cell cell11 = row.createCell(11);
        if (cell11 != null) {
            cell11.setCellValue("REMARKS");
        }

        final Cell cell12 = row.createCell(12);
        if (cell12 != null) {
            cell12.setCellValue("COLUMN_DEF");
        }

        final Cell cell13 = row.createCell(13);
        if (cell13 != null) {
            cell13.setCellValue("SQL_DATA_TYPE");
        }

        final Cell cell14 = row.createCell(14);
        if (cell14 != null) {
            cell14.setCellValue("SQL_DATETIME_SUB");
        }

        final Cell cell15 = row.createCell(15);
        if (cell15 != null) {
            cell15.setCellValue("CHAR_OCTET_LENGTH");
        }

        final Cell cell16 = row.createCell(16);
        if (cell16 != null) {
            cell16.setCellValue("ORDINAL_POSITION");
        }

        final Cell cell17 = row.createCell(17);
        if (cell17 != null) {
            cell17.setCellValue("IS_NULLABLE");
        }

        final Cell cell18 = row.createCell(18);
        if (cell18 != null) {
            cell18.setCellValue("SCOPE_CATALOG");
        }

        final Cell cell19 = row.createCell(19);
        if (cell19 != null) {
            cell19.setCellValue("SCOPE_SCHEMA");
        }

        final Cell cell20 = row.createCell(20);
        if (cell20 != null) {
            cell20.setCellValue("SCOPE_TABLE");
        }

        final Cell cell21 = row.createCell(21);
        if (cell21 != null) {
            cell21.setCellValue("SOURCE_DATA_TYPE");
        }

        final Cell cell22 = row.createCell(22);
        if (cell22 != null) {
            cell22.setCellValue("IS_AUTOINCREMENT");
        }
    }

    private void createRow(final Sheet sheet, final int rownum, final String tableCat, final String tableSchem,
            final String tableName, final String columnName, final int dataType, final String typeName,
            final int columnSize, final int bufferLength, final int decimalDigits, final int numPrecRadix,
            final int nullable, final String remarks, final String columnDef, final int sqlDataType,
            final int sqlDatetimeSub, final int charOctetLength, final int ordinalPosition, final String isNullable,
            final String scopeCatalog, final String scopeSchema, final String scopeTable, final int sourceDataType,
            final String isAutoincrement) {
        final Row row = sheet.createRow(rownum);
        createCell(row, tableCat, tableSchem, tableName, columnName, dataType, typeName, columnSize, bufferLength,
                decimalDigits, numPrecRadix, nullable, remarks, columnDef, sqlDataType, sqlDatetimeSub, charOctetLength,
                ordinalPosition, isNullable, scopeCatalog, scopeSchema, scopeTable, sourceDataType, isAutoincrement);
    }

    private void createCell(final Row row, final String tableCat, final String tableSchem, final String tableName,
            final String columnName, final int dataType, final String typeName, final int columnSize,
            final int bufferLength, final int decimalDigits, final int numPrecRadix, final int nullable,
            final String remarks, final String columnDef, final int sqlDataType, final int sqlDatetimeSub,
            final int charOctetLength, final int ordinalPosition, final String isNullable, final String scopeCatalog,
            final String scopeSchema, final String scopeTable, final int sourceDataType, final String isAutoincrement) {
        final Cell cell0 = row.createCell(0);
        if (cell0 != null) {
            cell0.setCellValue(tableCat);
        }

        final Cell cell1 = row.createCell(1);
        if (cell1 != null) {
            cell1.setCellValue(tableSchem);
        }

        final Cell cell2 = row.createCell(2);
        if (cell2 != null) {
            cell2.setCellValue(tableName);
        }

        final Cell cell3 = row.createCell(3);
        if (cell3 != null) {
            cell3.setCellValue(columnName);
        }

        final Cell cell4 = row.createCell(4);
        if (cell4 != null) {
            cell4.setCellValue(dataType);
        }

        final Cell cell5 = row.createCell(5);
        if (cell5 != null) {
            cell5.setCellValue(typeName);
        }

        final Cell cell6 = row.createCell(6);
        if (cell6 != null) {
            cell6.setCellValue(columnSize);
        }

        final Cell cell7 = row.createCell(7);
        if (cell7 != null) {
            cell7.setCellValue(bufferLength);
        }

        final Cell cell8 = row.createCell(8);
        if (cell8 != null) {
            cell8.setCellValue(decimalDigits);
        }

        final Cell cell9 = row.createCell(9);
        if (cell9 != null) {
            cell9.setCellValue(numPrecRadix);
        }

        final Cell cell10 = row.createCell(10);
        if (cell10 != null) {
            cell10.setCellValue(nullable);
        }

        final Cell cell11 = row.createCell(11);
        if (cell11 != null) {
            cell11.setCellValue(remarks);
        }

        final Cell cell12 = row.createCell(12);
        if (cell12 != null) {
            cell12.setCellValue(columnDef);
        }

        final Cell cell13 = row.createCell(13);
        if (cell13 != null) {
            cell13.setCellValue(sqlDataType);
        }

        final Cell cell14 = row.createCell(14);
        if (cell14 != null) {
            cell14.setCellValue(sqlDatetimeSub);
        }

        final Cell cell15 = row.createCell(15);
        if (cell15 != null) {
            cell15.setCellValue(charOctetLength);
        }

        final Cell cell16 = row.createCell(16);
        if (cell16 != null) {
            cell16.setCellValue(ordinalPosition);
        }

        final Cell cell17 = row.createCell(17);
        if (cell17 != null) {
            cell17.setCellValue(isNullable);
        }

        final Cell cell18 = row.createCell(18);
        if (cell18 != null) {
            cell18.setCellValue(scopeCatalog);
        }

        final Cell cell19 = row.createCell(19);
        if (cell19 != null) {
            cell19.setCellValue(scopeSchema);
        }

        final Cell cell20 = row.createCell(20);
        if (cell20 != null) {
            cell20.setCellValue(scopeTable);
        }

        final Cell cell21 = row.createCell(21);
        if (cell21 != null) {
            cell21.setCellValue(sourceDataType);
        }

        final Cell cell22 = row.createCell(22);
        if (cell22 != null) {
            cell22.setCellValue(isAutoincrement);
        }
    }

}
