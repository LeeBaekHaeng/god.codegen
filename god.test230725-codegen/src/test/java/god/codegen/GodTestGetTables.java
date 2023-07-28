package god.codegen;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
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
 * ResultSet 메타데이터 테이블 가져오기 테스트
 * 
 * @author 이백행
 * @since 2023-07-28
 */
@NoArgsConstructor
@Slf4j
public class GodTestGetTables {

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
//        final String schemaPattern = "%%";

        final String tableNamePattern = null;
//        final String tableNamePattern = "%%";
//        final String tableNamePattern = "%com%";
//        final String tableNamePattern = "comtcadministcode"; // 행정코드
//        final String tableNamePattern = "COMTCADMINISTCODE"; // 행정코드

        final String[] types = null;
//        final String[] types = { "TABLE", "VIEW" };

        final String templateName = SystemUtils.USER_HOME + "/Desktop/테이블_"
                + EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + ".xlsx";
        log.debug("templateName={}", templateName);

        try (Connection con = godTestJavaSql.getConnection()) {
            final DatabaseMetaData databaseMetaData = con.getMetaData();
            godTestJavaSql.debug(con, databaseMetaData);
            tables(databaseMetaData, catalog, schemaPattern, tableNamePattern, types, templateName);
        } catch (SQLException e) {
//            e.printStackTrace();
            log.error("SQLException getConnection");
        }

        assertEquals("", "", "");
    }

    private void tables(final DatabaseMetaData databaseMetaData, final String catalog, final String schemaPattern,
            final String tableNamePattern, final String[] types, final String templateName) throws SQLException {
        if (log.isDebugEnabled()) {
            log.debug("catalog={}", catalog);
            log.debug("schemaPattern={}", schemaPattern);
            log.debug("tableNamePattern={}", tableNamePattern);
            log.debug("types={}", Arrays.toString(types));
        }
        try (ResultSet rs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types)) {
            resultSetMetaData(rs.getMetaData());
            tables(rs, templateName);
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
        final StringBuffer sb3 = new StringBuffer(1600);

        int i = 0;

        for (int column = 1; column < columnCount; column++) {

            final String columnLabel = resultSetMetaData.getColumnLabel(column);
//            final String columnLabel = resultSetMetaData.getColumnName(column);
//            final String columnLabel = resultSetMetaData.getSchemaName(column);
            final String columnLabelCcName = CamelUtil.convert2CamelCase(columnLabel);

            final int columnType = resultSetMetaData.getColumnType(column);
            final String columnTypeName = resultSetMetaData.getColumnTypeName(column);

            sb.append(", final String " + columnLabelCcName);

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

    private void tables(final ResultSet rs, final String templateName) {
        try (Workbook type = new XSSFWorkbook()) {
            final Sheet sheet = type.createSheet("테이블");
            int rownum = 0;
            createRow(sheet, rownum++);

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

                createRow(sheet, rownum++, tableCat, tableSchem, tableName, tableType, remarks, typeCat, typeSchem,
                        typeName, selfReferencingColName);

                i++;
            }

            egovExcelService.createWorkbook(type, templateName);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("Exception");
        }
    }

    private void createRow(final Sheet sheet, final int rownum) {
        final Row row = sheet.createRow(rownum);
        createCell(row);
        createCell2(row);
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
            cell3.setCellValue("TABLE_TYPE");
        }

        final Cell cell4 = row.createCell(4);
        if (cell4 != null) {
            cell4.setCellValue("REMARKS");
        }

        final Cell cell5 = row.createCell(5);
        if (cell5 != null) {
            cell5.setCellValue("TYPE_CAT");
        }

        final Cell cell6 = row.createCell(6);
        if (cell6 != null) {
            cell6.setCellValue("TYPE_SCHEM");
        }
    }

    private void createCell2(final Row row) {
        final Cell cell7 = row.createCell(7);
        if (cell7 != null) {
            cell7.setCellValue("TYPE_NAME");
        }

        final Cell cell8 = row.createCell(8);
        if (cell8 != null) {
            cell8.setCellValue("SELF_REFERENCING_COL_NAME");
        }
    }

    private void createRow(final Sheet sheet, final int rownum, final String tableCat, final String tableSchem,
            final String tableName, final String tableType, final String remarks, final String typeCat,
            final String typeSchem, final String typeName, final String selfReferencingColName) {
        final Row row = sheet.createRow(rownum);
        createCell(row, tableCat, tableSchem, tableName, tableType, remarks, typeCat, typeSchem);
        createCell2(row, typeName, selfReferencingColName);
    }

    private void createCell(final Row row, final String tableCat, final String tableSchem, final String tableName,
            final String tableType, final String remarks, final String typeCat, final String typeSchem) {
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
            cell3.setCellValue(tableType);
        }

        final Cell cell4 = row.createCell(4);
        if (cell4 != null) {
            cell4.setCellValue(remarks);
        }

        final Cell cell5 = row.createCell(5);
        if (cell5 != null) {
            cell5.setCellValue(typeCat);
        }

        final Cell cell6 = row.createCell(6);
        if (cell6 != null) {
            cell6.setCellValue(typeSchem);
        }
    }

    private void createCell2(final Row row, final String typeName, final String selfReferencingColName) {
        final Cell cell7 = row.createCell(7);
        if (cell7 != null) {
            cell7.setCellValue(typeName);
        }

        final Cell cell8 = row.createCell(8);
        if (cell8 != null) {
            cell8.setCellValue(selfReferencingColName);
        }
    }

}
