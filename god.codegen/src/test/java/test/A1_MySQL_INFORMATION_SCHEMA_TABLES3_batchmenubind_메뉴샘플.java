package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.springframework.core.io.ClassPathResource;

import egovframework.com.codegen.sample2.service.impl.Sample2ServiceImplTest;
import egovframework.dev.imp.codegen.template.util.NamingUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class A1_MySQL_INFORMATION_SCHEMA_TABLES3_batchmenubind_메뉴샘플 {

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
		String prefix = "aaa";
//		prefix = "baa";
//		prefix = "caa";

//		String prefixPcName = NamingUtils.convertCamelcaseToPascalcase(prefix);

		String filepath = SystemUtils.USER_HOME + "/Desktop/god.codegen/"
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_batchmenubind_메뉴샘플.xls";

		String classPathResourcePath = "test/batchmenubind_메뉴샘플.xls";
		egovLogger.debug("classPathResourcePath={}", classPathResourcePath);

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new ClassPathResource(classPathResourcePath).getInputStream());
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			egovLogger
					.error("WorkbookFactory.create EncryptedDocumentException | InvalidFormatException | IOException ");
			return;
		}

		Sheet sheet = wb.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();

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
			egovLogger.debug("");

			DatabaseMetaData metaData = con.getMetaData();

			String databaseProductName = metaData.getDatabaseProductName();
			egovLogger.debug("databaseProductName={}", databaseProductName);
			egovLogger.debug("");

			try (

					Statement stmt = con.createStatement();

					ResultSet tables = stmt
							.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'COM'");

			) {

				ResultSetMetaData rsmd = tables.getMetaData();
				int columnCount = rsmd.getColumnCount();
				egovLogger.debug("columnCount={}", columnCount);
				StringBuffer sb = new StringBuffer();
				StringBuffer sb2 = new StringBuffer();
				for (int column = 1; column <= columnCount; column++) {
					String columnLabel = rsmd.getColumnLabel(column);
					String columnTypeName = rsmd.getColumnTypeName(column);
					String columnLabelCcName = NamingUtils.convertUnderscoreNameToCamelcase(columnLabel);

					egovLogger.debug("columnLabel={}", columnLabel);
					egovLogger.debug("getColumnName={}", rsmd.getColumnName(column));
					egovLogger.debug("getColumnType={}", rsmd.getColumnType(column));
					egovLogger.debug("columnTypeName={}", columnTypeName);
					egovLogger.debug("");

					if ("VARCHAR".equals(columnTypeName)) {
						sb.append("String " + columnLabelCcName + " = tables.getString(\"" + columnLabel + "\");");
					} else if ("DATETIME".equals(columnTypeName)) {
						sb.append("String " + columnLabelCcName + " = tables.getString(\"" + columnLabel + "\");");
					} else {
						sb.append("int " + columnLabelCcName + " = tables.getInt(\"" + columnLabel + "\");");
					}
					sb.append("\n");

					sb2.append("egovLogger.debug(\"" + columnLabelCcName + "={}\", " + columnLabelCcName + ");");
					sb2.append("\n");
				}
				System.out.println(sb);
				System.out.println(sb2);

				int i = 1;
				int rownum = lastRowNum + 1;

				while (tables.next()) {

					String tableCatalog = tables.getString("TABLE_CATALOG");
					String tableSchema = tables.getString("TABLE_SCHEMA");
					String tableName = tables.getString("TABLE_NAME");
					String tableType = tables.getString("TABLE_TYPE");
					String engine = tables.getString("ENGINE");
					int version = tables.getInt("VERSION");
					String rowFormat = tables.getString("ROW_FORMAT");
					int tableRows = tables.getInt("TABLE_ROWS");
					int avgRowLength = tables.getInt("AVG_ROW_LENGTH");
					int dataLength = tables.getInt("DATA_LENGTH");
					int maxDataLength = tables.getInt("MAX_DATA_LENGTH");
					int indexLength = tables.getInt("INDEX_LENGTH");
					int dataFree = tables.getInt("DATA_FREE");
					int autoIncrement = tables.getInt("AUTO_INCREMENT");
					String createTime = tables.getString("CREATE_TIME");
					String updateTime = tables.getString("UPDATE_TIME");
					String checkTime = tables.getString("CHECK_TIME");
					String tableCollation = tables.getString("TABLE_COLLATION");
					int checksum = tables.getInt("CHECKSUM");
					String createOptions = tables.getString("CREATE_OPTIONS");
					String tableComment = tables.getString("TABLE_COMMENT");
					int maxIndexLength = tables.getInt("MAX_INDEX_LENGTH");
					String temporary = tables.getString("TEMPORARY");

					egovLogger.debug("i={}", i);
					egovLogger.debug("tableCatalog={}", tableCatalog);
					egovLogger.debug("tableSchema={}", tableSchema);
					egovLogger.debug("tableName={}", tableName);
					egovLogger.debug("tableType={}", tableType);
					egovLogger.debug("engine={}", engine);
					egovLogger.debug("version={}", version);
					egovLogger.debug("rowFormat={}", rowFormat);
					egovLogger.debug("tableRows={}", tableRows);
					egovLogger.debug("avgRowLength={}", avgRowLength);
					egovLogger.debug("dataLength={}", dataLength);
					egovLogger.debug("maxDataLength={}", maxDataLength);
					egovLogger.debug("indexLength={}", indexLength);
					egovLogger.debug("dataFree={}", dataFree);
					egovLogger.debug("autoIncrement={}", autoIncrement);
					egovLogger.debug("createTime={}", createTime);
					egovLogger.debug("updateTime={}", updateTime);
					egovLogger.debug("checkTime={}", checkTime);
					egovLogger.debug("tableCollation={}", tableCollation);
					egovLogger.debug("checksum={}", checksum);
					egovLogger.debug("createOptions={}", createOptions);
					egovLogger.debug("tableComment={}", tableComment);
					egovLogger.debug("maxIndexLength={}", maxIndexLength);
					egovLogger.debug("temporary={}", temporary);
					egovLogger.debug("");

					String tableNameCcName = NamingUtils.convertUnderscoreNameToCamelcase(prefix + "_" + tableName);
					String tableNamePcName = NamingUtils.convertCamelcaseToPascalcase(tableNameCcName);

					String entityName = (prefix + "_" + tableName).toUpperCase();

					insert(sheet, rownum, tableNamePcName, prefix, tableName, tableComment, entityName);
					rownum++;

					select(sheet, rownum, tableNamePcName, prefix, tableName, tableComment, entityName);
					rownum++;

					selectList(sheet, rownum, tableNamePcName, prefix, tableName, tableComment, entityName);
					rownum++;

					update(sheet, rownum, tableNamePcName, prefix, tableName, tableComment, entityName);
					rownum++;

					delete(sheet, rownum, tableNamePcName, prefix, tableName, tableComment, entityName);
					rownum++;

					i++;
//					rownum++;

				}

			}

		} catch (SQLException e) {
			egovLogger.error("SQLException");
			return;
		}

		try {
			egovExcelService.createWorkbook(wb, filepath);
		} catch (Exception e) {
			egovLogger.error("createWorkbook Exception");
			return;
		}

	}

	private void insert(Sheet sheet, int rownum, String tableNamePcName, String prefix, String tableName,
			String tableComment, String entityName) {

		String progrmFileNm = tableNamePcName + "Insert"; // 프로그램명, 프로그램파일명
		String progrmKoreanNm = tableComment + " 등록"; // 프로그램한글명
		String progrmStrePath = "/" + prefix + "/insert" + tableNamePcName; // 프로그램저장경로
		String url = progrmStrePath + "/insert" + tableNamePcName + ".do"; // URL
		String progrmDc = progrmKoreanNm; // 프로그램설명

		Row row = sheet.createRow(rownum);

		Cell cellA = row.createCell(0);
		cellA.setCellValue(progrmFileNm); // 프로그램명

		Cell cellB = row.createCell(1);
		cellB.setCellValue(progrmKoreanNm); // 프로그램한글명

		Cell cellC = row.createCell(2);
		cellC.setCellValue(progrmStrePath); // 프로그램저장경로

		Cell cellD = row.createCell(3);
		cellD.setCellValue(url); // URL

		Cell cellE = row.createCell(4);
		cellE.setCellValue(progrmDc); // 프로그램설명

		Cell cellF = row.createCell(5);
		cellF.setCellValue("N"); // 코드생성여부

		Cell cellG = row.createCell(6);
		cellG.setCellValue(tableName); // 테이블 영문명

		Cell cellH = row.createCell(7);
		cellH.setCellValue(entityName); // 관련엔터티명
	}

	private void select(Sheet sheet, int rownum, String tableNamePcName, String prefix, String tableName,
			String tableComment, String entityName) {

		String progrmFileNm = tableNamePcName + "Select"; // 프로그램명, 프로그램파일명
		String progrmKoreanNm = tableComment + " 조회(단건)"; // 프로그램한글명
		String progrmStrePath = "/" + prefix + "/select" + tableNamePcName; // 프로그램저장경로
		String url = progrmStrePath + "/select" + tableNamePcName + ".do"; // URL
		String progrmDc = progrmKoreanNm; // 프로그램설명

		Row row = sheet.createRow(rownum);

		Cell cellA = row.createCell(0);
		cellA.setCellValue(progrmFileNm); // 프로그램명

		Cell cellB = row.createCell(1);
		cellB.setCellValue(progrmKoreanNm); // 프로그램한글명

		Cell cellC = row.createCell(2);
		cellC.setCellValue(progrmStrePath); // 프로그램저장경로

		Cell cellD = row.createCell(3);
		cellD.setCellValue(url); // URL

		Cell cellE = row.createCell(4);
		cellE.setCellValue(progrmDc); // 프로그램설명

		Cell cellF = row.createCell(5);
		cellF.setCellValue("N"); // 코드생성여부

		Cell cellG = row.createCell(6);
		cellG.setCellValue(tableName); // 테이블 영문명

		Cell cellH = row.createCell(7);
		cellH.setCellValue(entityName); // 관련엔터티명
	}

	private void selectList(Sheet sheet, int rownum, String tableNamePcName, String prefix, String tableName,
			String tableComment, String entityName) {

		String progrmFileNm = tableNamePcName + "SelectList"; // 프로그램명, 프로그램파일명
		String progrmKoreanNm = tableComment + " 조회(멀티건)"; // 프로그램한글명
		String progrmStrePath = "/" + prefix + "/select" + tableNamePcName + "List"; // 프로그램저장경로
		String url = progrmStrePath + "/select" + tableNamePcName + "List.do"; // URL
		String progrmDc = progrmKoreanNm; // 프로그램설명

		Row row = sheet.createRow(rownum);

		Cell cellA = row.createCell(0);
		cellA.setCellValue(progrmFileNm); // 프로그램명

		Cell cellB = row.createCell(1);
		cellB.setCellValue(progrmKoreanNm); // 프로그램한글명

		Cell cellC = row.createCell(2);
		cellC.setCellValue(progrmStrePath); // 프로그램저장경로

		Cell cellD = row.createCell(3);
		cellD.setCellValue(url); // URL

		Cell cellE = row.createCell(4);
		cellE.setCellValue(progrmDc); // 프로그램설명

		Cell cellF = row.createCell(5);
		cellF.setCellValue("N"); // 코드생성여부

		Cell cellG = row.createCell(6);
		cellG.setCellValue(tableName); // 테이블 영문명

		Cell cellH = row.createCell(7);
		cellH.setCellValue(entityName); // 관련엔터티명
	}

	private void update(Sheet sheet, int rownum, String tableNamePcName, String prefix, String tableName,
			String tableComment, String entityName) {

		String progrmFileNm = tableNamePcName + "Update"; // 프로그램명, 프로그램파일명
		String progrmKoreanNm = tableComment + " 수정"; // 프로그램한글명
		String progrmStrePath = "/" + prefix + "/update" + tableNamePcName; // 프로그램저장경로
		String url = progrmStrePath + "/update" + tableNamePcName; // URL
		String progrmDc = progrmKoreanNm; // 프로그램설명

		Row row = sheet.createRow(rownum);

		Cell cellA = row.createCell(0);
		cellA.setCellValue(progrmFileNm); // 프로그램명

		Cell cellB = row.createCell(1);
		cellB.setCellValue(progrmKoreanNm); // 프로그램한글명

		Cell cellC = row.createCell(2);
		cellC.setCellValue(progrmStrePath); // 프로그램저장경로

		Cell cellD = row.createCell(3);
		cellD.setCellValue(url); // URL

		Cell cellE = row.createCell(4);
		cellE.setCellValue(progrmDc); // 프로그램설명

		Cell cellF = row.createCell(5);
		cellF.setCellValue("N"); // 코드생성여부

		Cell cellG = row.createCell(6);
		cellG.setCellValue(tableName); // 테이블 영문명

		Cell cellH = row.createCell(7);
		cellH.setCellValue(entityName); // 관련엔터티명
	}

	private void delete(Sheet sheet, int rownum, String tableNamePcName, String prefix, String tableName,
			String tableComment, String entityName) {

		String progrmFileNm = tableNamePcName + "Delete"; // 프로그램명, 프로그램파일명
		String progrmKoreanNm = tableComment + " 삭제"; // 프로그램한글명
		String progrmStrePath = "/" + prefix + "/delete" + tableNamePcName; // 프로그램저장경로
		String url = progrmStrePath + "/delete" + tableNamePcName; // URL
		String progrmDc = progrmKoreanNm; // 프로그램설명

		Row row = sheet.createRow(rownum);

		Cell cellA = row.createCell(0);
		cellA.setCellValue(progrmFileNm); // 프로그램명

		Cell cellB = row.createCell(1);
		cellB.setCellValue(progrmKoreanNm); // 프로그램한글명

		Cell cellC = row.createCell(2);
		cellC.setCellValue(progrmStrePath); // 프로그램저장경로

		Cell cellD = row.createCell(3);
		cellD.setCellValue(url); // URL

		Cell cellE = row.createCell(4);
		cellE.setCellValue(progrmDc); // 프로그램설명

		Cell cellF = row.createCell(5);
		cellF.setCellValue("N"); // 코드생성여부

		Cell cellG = row.createCell(6);
		cellG.setCellValue(tableName); // 테이블 영문명

		Cell cellH = row.createCell(7);
		cellH.setCellValue(entityName); // 관련엔터티명
	}

}
