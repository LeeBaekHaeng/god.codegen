package org.egovframe.rte.fdl.excel.impl;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.egovframe.rte.fdl.excel.EgovExcelService;
import org.egovframe.rte.fdl.excel.util.EgovExcelUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class EgovExcelServiceImpl_d1_loadWorkbook_xls {

	protected Logger egovLogger = LoggerFactory.getLogger(EgovExcelServiceImpl_d1_loadWorkbook_xls.class);

	private final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

	@Test
	public void test() {
		String path = "test/batchmenubind_메뉴샘플.xls";
		egovLogger.debug("path={}", path);

		String filepath = null;
		try {
			filepath = new ClassPathResource(path).getFile().getAbsolutePath();
		} catch (IOException e) {
			egovLogger.error("ClassPathResource IOException");
			return;
		}
		egovLogger.debug("filepath={}", filepath);

		Workbook wb = null;
		try {
			wb = egovExcelService.loadWorkbook(filepath);
		} catch (Exception e) {
			egovLogger.error("loadWorkbook Exception");
			return;
		}

		int numberOfSheets = wb.getNumberOfSheets();

		for (int index = 0; index < numberOfSheets; index++) {
			Sheet sheet = wb.getSheetAt(index);
			String sheetName = sheet.getSheetName();

			for (Row row : sheet) {
				int rowNum = row.getRowNum();
				egovLogger.debug("rowNum={}", rowNum);
				for (Cell cell : row) {
					egovLogger.debug("sheetName={}, rowNum={}, getValue={}", sheetName, rowNum,
							EgovExcelUtil.getValue(cell));
				}
				egovLogger.debug("");
			}
		}
	}

}
