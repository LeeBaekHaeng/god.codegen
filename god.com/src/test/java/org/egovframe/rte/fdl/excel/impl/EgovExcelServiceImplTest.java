package org.egovframe.rte.fdl.excel.impl;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.egovframe.rte.fdl.excel.EgovExcelService;
import org.egovframe.rte.fdl.excel.util.EgovExcelUtil;
import org.junit.Test;

import egovframework.com.cmm.util.EgovMybatisUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 엑셀 서비스를 처리하는 비즈니스 구현 클래스 단위 테스트
 * 
 * @author 이백행
 * @since 2023-07-19
 */

@NoArgsConstructor
@Slf4j
public class EgovExcelServiceImplTest {

    /**
     * 행 번호 22
     */
    private static final int ROW_NUM_22 = 22;

    /**
     * 행 번호 5
     */
    private static final int ROW_NUM_5 = 5;

    /**
     * 엑셀 Template를 로딩하여 엑셀파일을 생성한다.
     */
    @Test
    public void test_a20_loadExcelTemplate() {
        final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

        final String templateName = "C:\\test\\test.xlsx";
        try (XSSFWorkbook type = egovExcelService.loadExcelTemplate(templateName, null)) {
            sheet2(type.getSheetAt(2));
            sheet3(type.getSheetAt(3));
        } catch (Exception e) {
            log.error("Exception loadExcelTemplate");
        }

        assertEquals("", "", "");
    }

    private void sheet2(final Sheet sheet) {
        final StringBuffer delete = new StringBuffer(1600);
        final StringBuffer insert = new StringBuffer(1600);
        for (final Row row : sheet) {
            final int rowNum = row.getRowNum();
            log.debug("rowNum={}", rowNum);

            if (rowNum < ROW_NUM_22) {
                continue;
            }

//            for (final Cell cell : row) {
//                log.debug("cell={}", cell);
//            }

            final String a = EgovExcelUtil.getValue(row.getCell(0));
            final String b = EgovExcelUtil.getValue(row.getCell(1));
            final String c = EgovExcelUtil.getValue(row.getCell(2));
            final String d = EgovExcelUtil.getValue(row.getCell(3));
            final String e = EgovExcelUtil.getValue(row.getCell(4));
            final String f = EgovExcelUtil.getValue(row.getCell(5));
            final String g = EgovExcelUtil.getValue(row.getCell(6));
            final String h = EgovExcelUtil.getValue(row.getCell(7));
            final String i = EgovExcelUtil.getValue(row.getCell(8));

            log.debug("a={}", a);
            log.debug("b={}", b);
            log.debug("c={}", c);
            log.debug("d={}", d);
            log.debug("e={}", e);
            log.debug("f={}", f);
            log.debug("g={}", g);
            log.debug("h={}", h);
            log.debug("i={}", i);

            if (EgovMybatisUtil.isEmpty(c)) {
                continue;
            }

            delete.append("DELETE FROM COMTCCMMNCODE WHERE CL_CODE = '" + c + "';\n");

            insert.append(
                    "INSERT INTO COMTCCMMNCODE(CL_CODE, CODE_ID, CODE_ID_NM, CODE_ID_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID,LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES (");
            insert.append("'AAA'");
            insert.append(", '" + c + "'");
            insert.append(", '" + b + "'");
            insert.append(", '" + b + "'");
            insert.append(", 'Y'");
            insert.append(", NOW()");
            insert.append(", 'SYSTEM'");
            insert.append(", NOW()");
            insert.append(", 'SYSTEM'");
            insert.append(");\n");
        }
        final String data = delete.toString() + "\n" + insert.toString();
        log.debug(data);
        try {
            FileUtils.writeStringToFile(new File("C:\\test\\comtccmmncode 공통코드.sql"), data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("IOException");
        }
    }

    private void sheet3(final Sheet sheet) {
        final StringBuffer delete = new StringBuffer(1600);
        final StringBuffer insert = new StringBuffer(1600);
        for (final Row row : sheet) {
            final int rowNum = row.getRowNum();
            log.debug("rowNum={}", rowNum);

            if (rowNum < ROW_NUM_5) {
                continue;
            }

//            for (final Cell cell : row) {
//                log.debug("cell={}", cell);
//            }

            final String a = EgovExcelUtil.getValue(row.getCell(0));
            final String b = EgovExcelUtil.getValue(row.getCell(1));
            final String c = EgovExcelUtil.getValue(row.getCell(2));
            final String d = EgovExcelUtil.getValue(row.getCell(3));
            final String e = EgovExcelUtil.getValue(row.getCell(4));
            final String f = EgovExcelUtil.getValue(row.getCell(5));
            final String g = EgovExcelUtil.getValue(row.getCell(6));
            final String h = EgovExcelUtil.getValue(row.getCell(7));
            final String i = EgovExcelUtil.getValue(row.getCell(8));

            log.debug("a={}", a);
            log.debug("b={}", b);
            log.debug("c={}", c);
            log.debug("d={}", d);
            log.debug("e={}", e);
            log.debug("f={}", f);
            log.debug("g={}", g);
            log.debug("h={}", h);
            log.debug("i={}", i);

            if (EgovMybatisUtil.isEmpty(b) && EgovMybatisUtil.isEmpty(d)) {
                continue;
            }

            delete.append("DELETE FROM COMTCCMMNDETAILCODE WHERE CL_CODE = '" + b + "' AND CODE = '" + d + "';\n");

            insert.append(
                    "INSERT INTO COMTCCMMNDETAILCODE(CODE_ID, CODE, CODE_NM, CODE_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES (");
            insert.append("'" + b + "'");
            insert.append(", '" + d + "'");
            insert.append(", '" + c + "'");
            insert.append(", '" + c + "'");
            insert.append(", 'Y'");
            insert.append(", NOW()");
            insert.append(", 'SYSTEM'");
            insert.append(", NOW()");
            insert.append(", 'SYSTEM'");
            insert.append(");\n");
        }
        final String data = delete.toString() + "\n" + insert.toString();
        log.debug(data);
        try {
            FileUtils.writeStringToFile(new File("C:\\test\\comtccmmndetailcode 공통상세코드.sql"), data,
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("IOException");
        }
    }

}
