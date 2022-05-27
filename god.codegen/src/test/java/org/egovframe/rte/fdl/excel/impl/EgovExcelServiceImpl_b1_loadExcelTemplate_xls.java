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

public class EgovExcelServiceImpl_b1_loadExcelTemplate_xls {

	protected Logger egovLogger = LoggerFactory.getLogger(EgovExcelServiceImpl_b1_loadExcelTemplate_xls.class);

	private final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

	@Test
	public void test() {
		String path = "test/batchmenubind_메뉴샘플.xls";
		egovLogger.debug("path={}", path);

		String templateName = null;
		try {
			templateName = new ClassPathResource(path).getFile().getAbsolutePath();
		} catch (IOException e) {
			egovLogger.error("ClassPathResource IOException");
			return;
		}
		egovLogger.debug("templateName={}", templateName);

		Workbook wb = null;
		try {
			wb = egovExcelService.loadExcelTemplate(templateName);
		} catch (Exception e) {
			egovLogger.error("loadExcelTemplate Exception");
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
