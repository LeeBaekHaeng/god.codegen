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
public class A1_MySQL_INFORMATION_SCHEMA_TABLES {

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
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_INFORMATION_SCHEMA.TABLES.xlsx";

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
				cellA.setCellValue("TABLE_CATALOG");

				Cell cellB = row.createCell(1);
				cellB.setCellValue("TABLE_SCHEMA");

				Cell cellC = row.createCell(2);
				cellC.setCellValue("TABLE_NAME");

				Cell cellD = row.createCell(3);
				cellD.setCellValue("TABLE_TYPE");

				Cell cellE = row.createCell(4);
				cellE.setCellValue("ENGINE");

				Cell cellF = row.createCell(5);
				cellF.setCellValue("VERSION");

				Cell cellG = row.createCell(6);
				cellG.setCellValue("ROW_FORMAT");

				Cell cellH = row.createCell(7);
				cellH.setCellValue("TABLE_ROWS");

				Cell cellI = row.createCell(8);
				cellI.setCellValue("AVG_ROW_LENGTH");

				Cell cellJ = row.createCell(9);
				cellJ.setCellValue("DATA_LENGTH");

				Cell cellK = row.createCell(10);
				cellK.setCellValue("MAX_DATA_LENGTH");

				Cell cellL = row.createCell(11);
				cellL.setCellValue("INDEX_LENGTH");

				Cell cellM = row.createCell(12);
				cellM.setCellValue("DATA_FREE");

				Cell cellN = row.createCell(13);
				cellN.setCellValue("AUTO_INCREMENT");

				Cell cellO = row.createCell(14);
				cellO.setCellValue("CREATE_TIME");

				Cell cellP = row.createCell(15);
				cellP.setCellValue("UPDATE_TIME");

				Cell cellQ = row.createCell(16);
				cellQ.setCellValue("CHECK_TIME");

				Cell cellR = row.createCell(17);
				cellR.setCellValue("TABLE_COLLATION");

				Cell cellS = row.createCell(18);
				cellS.setCellValue("CHECKSUM");

				Cell cellT = row.createCell(19);
				cellT.setCellValue("CREATE_OPTIONS");

				Cell cellU = row.createCell(20);
				cellU.setCellValue("TABLE_COMMENT");

				Cell cellV = row.createCell(21);
				cellV.setCellValue("MAX_INDEX_LENGTH");

				Cell cellW = row.createCell(22);
				cellW.setCellValue("TEMPORARY");

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
					cellA.setCellValue(tableCat); // TABLE_CATALOG

					cellB = row.createCell(1);
					cellB.setCellValue(tableSchem); // TABLE_SCHEMA

					cellC = row.createCell(2);
					cellC.setCellValue(tableName); // TABLE_NAME

					cellD = row.createCell(3);
					cellD.setCellValue(tableType); // TABLE_TYPE

					cellE = row.createCell(4);
					cellE.setCellValue(""); // ENGINE

					cellF = row.createCell(5);
					cellF.setCellValue(""); // VERSION

					cellG = row.createCell(6);
					cellG.setCellValue(""); // ROW_FORMAT

					cellH = row.createCell(7);
					cellH.setCellValue(""); // TABLE_ROWS

					cellI = row.createCell(8);
					cellI.setCellValue(""); // AVG_ROW_LENGTH

					cellJ = row.createCell(9);
					cellJ.setCellValue(""); // DATA_LENGTH

					cellK = row.createCell(10);
					cellK.setCellValue(""); // MAX_DATA_LENGTH

					cellL = row.createCell(11);
					cellL.setCellValue(""); // INDEX_LENGTH

					cellM = row.createCell(12);
					cellM.setCellValue(""); // DATA_FREE

					cellN = row.createCell(13);
					cellN.setCellValue(""); // AUTO_INCREMENT

					cellO = row.createCell(14);
					cellO.setCellValue(""); // CREATE_TIME

					cellP = row.createCell(15);
					cellP.setCellValue(""); // UPDATE_TIME

					cellQ = row.createCell(16);
					cellQ.setCellValue(""); // CHECK_TIME

					cellR = row.createCell(17);
					cellR.setCellValue(""); // TABLE_COLLATION

					cellS = row.createCell(18);
					cellS.setCellValue(""); // CHECKSUM

					cellT = row.createCell(19);
					cellT.setCellValue(""); // CREATE_OPTIONS

					cellU = row.createCell(20);
					cellU.setCellValue(remarks); // TABLE_COMMENT

					cellV = row.createCell(21);
					cellV.setCellValue(""); // MAX_INDEX_LENGTH

					cellW = row.createCell(22);
					cellW.setCellValue(""); // TEMPORARY

					i++;
					rownum++;

				}

			}

		} catch (SQLException e) {
			egovLogger.error("SQLException");
		}

		try {
			egovExcelService.createWorkbook(wb, filepath);
		} catch (Exception e) {
			egovLogger.error("createWorkbook Exception");
		}

	}

}
