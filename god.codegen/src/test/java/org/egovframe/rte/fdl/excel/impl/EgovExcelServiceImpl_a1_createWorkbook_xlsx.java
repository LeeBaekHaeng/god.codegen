package org.egovframe.rte.fdl.excel.impl;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.egovframe.rte.fdl.excel.EgovExcelService;
import org.egovframe.rte.fdl.excel.util.EgovExcelUtil;
import org.egovframe.rte.fdl.string.EgovDateUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class EgovExcelServiceImpl_a1_createWorkbook_xlsx {

	protected Logger egovLogger = LoggerFactory.getLogger(EgovExcelServiceImpl_a1_createWorkbook_xlsx.class);

	private final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

	@Test
	public void test() {
		String filepath = SystemUtils.USER_HOME + "/Desktop/god.codegen/"
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_batchmenubind_메뉴샘플.xlsx";

		String path = "test/batchmenubind_메뉴샘플.xlsx";
		egovLogger.debug("path={}", path);

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new ClassPathResource(path).getInputStream());
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			egovLogger
					.error("WorkbookFactory.create EncryptedDocumentException | InvalidFormatException | IOException ");
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

		try {
			egovExcelService.createWorkbook(wb, filepath);
		} catch (Exception e) {
			egovLogger.error("createWorkbook Exception");
			return;
		}
	}

}
