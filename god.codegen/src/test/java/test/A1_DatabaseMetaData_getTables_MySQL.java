package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.codegen.sample2.service.impl.Sample2ServiceImplTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class A1_DatabaseMetaData_getTables_MySQL {

	protected Logger egovLogger = LoggerFactory.getLogger(Sample2ServiceImplTest.class);

	private final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void a1_test() {
		String catalog = "com";
		String schemaPattern = "";
		String tableNamePattern = "%";
		String[] types = {};

		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		String filepath = SystemUtils.USER_HOME + "/Desktop/god.codegen/"
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_DatabaseMetaData_getTables.xlsx";

//		String url = "jdbc:egovLogger4jdbc:mysql://127.0.0.1:3306/com";
		String url = "jdbc:mysql://127.0.0.1:3306/com?useInformationSchema=true";
		String user = "com";
		String password = "com01";

		try (

				Connection con = DriverManager.getConnection(url, user, password);

		) {

//			egovLogger.debug("con={}", con);
			egovLogger.debug("getCatalog={}", con.getCatalog());
			egovLogger.debug("getSchema={}", con.getSchema());
			egovLogger.debug("getTypeMap={}", con.getTypeMap());

			DatabaseMetaData metaData = con.getMetaData();

			String databaseProductName = metaData.getDatabaseProductName();
			egovLogger.debug("databaseProductName={}", databaseProductName);

			try (

					ResultSet tables = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);

			) {

				int i = 1;
				int rownum = 0;

				Row row = sheet.createRow(rownum);
				Cell cellA = row.createCell(0);
				cellA.setCellValue("TABLE_CAT");

				Cell cellB = row.createCell(1);
				cellB.setCellValue("TABLE_SCHEM");

				Cell cellC = row.createCell(2);
				cellC.setCellValue("TABLE_NAME");

				Cell cellD = row.createCell(3);
				cellD.setCellValue("TABLE_TYPE");

				Cell cellE = row.createCell(4);
				cellE.setCellValue("REMARKS");

				Cell cellF = row.createCell(5);
				cellF.setCellValue("TYPE_CAT");

				Cell cellG = row.createCell(6);
				cellG.setCellValue("TYPE_SCHEM");

				Cell cellH = row.createCell(7);
				cellH.setCellValue("TYPE_NAME");

				Cell cellI = row.createCell(8);
				cellI.setCellValue("REF_GENERATION");

				Cell cellJ = row.createCell(8);
				cellJ.setCellValue("AVG_ROW_LENGTH");

				rownum++;

				while (tables.next()) {

					String tableCat = tables.getString("TABLE_CAT");
					String tableSchem = tables.getString("TABLE_SCHEM");
					String tableName = tables.getString("TABLE_NAME");
					String tableType = tables.getString("TABLE_TYPE");
					String remarks = tables.getString("REMARKS");
					String typeCat = tables.getString("TYPE_CAT");
					String typeSchem = tables.getString("TYPE_SCHEM");
					String typeName = tables.getString("TYPE_NAME");
					String selfReferencingColName = tables.getString("SELF_REFERENCING_COL_NAME");
					String refGeneration = tables.getString("REF_GENERATION");

					egovLogger.debug("i={}", i);
//					egovLogger.debug("tables={}", tables);
					egovLogger.debug("tableCat={}", tableCat);
					egovLogger.debug("tableSchem={}", tableSchem);
					egovLogger.debug("tableName={}", tableName);
					egovLogger.debug("tableType={}", tableType);
					egovLogger.debug("remarks={}", remarks);
					egovLogger.debug("typeCat={}", typeCat);
					egovLogger.debug("typeSchem={}", typeSchem);
					egovLogger.debug("typeName={}", typeName);
					egovLogger.debug("selfReferencingColName={}", selfReferencingColName);
					egovLogger.debug("refGeneration={}", refGeneration);
					egovLogger.debug("");

					row = sheet.createRow(rownum);
					cellA = row.createCell(0);
					cellA.setCellValue(tableCat); // TABLE_CAT

					cellB = row.createCell(1);
					cellB.setCellValue(tableSchem); // TABLE_SCHEM

					cellC = row.createCell(2);
					cellC.setCellValue(tableName); // TABLE_NAME

					cellD = row.createCell(3);
					cellD.setCellValue(tableType); // TABLE_TYPE

					cellE = row.createCell(4);
					cellE.setCellValue(remarks); // REMARKS

					cellF = row.createCell(5);
					cellF.setCellValue(typeCat); // TYPE_CAT

					cellG = row.createCell(6);
					cellG.setCellValue(typeSchem); // TYPE_SCHEM

					cellH = row.createCell(7);
					cellH.setCellValue(typeName); // TYPE_NAME

					cellI = row.createCell(8);
					cellI.setCellValue(selfReferencingColName); // SELF_REFERENCING_COL_NAME

					cellJ = row.createCell(9);
					cellJ.setCellValue(refGeneration); // REF_GENERATION

					i++;
					rownum++;

				}

			} catch (SQLException e) {
				egovLogger.error("getTables SQLException");
			}

		} catch (SQLException e) {
			egovLogger.error("getConnection SQLException");
		}

		try {
			egovExcelService.createWorkbook(wb, filepath);
		} catch (Exception e1) {
			egovLogger.error("createWorkbook Exception");
		}

	}

}
