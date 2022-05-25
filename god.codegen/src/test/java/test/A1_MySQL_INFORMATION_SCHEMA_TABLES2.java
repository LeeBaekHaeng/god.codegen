package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
import egovframework.dev.imp.codegen.template.util.NamingUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class A1_MySQL_INFORMATION_SCHEMA_TABLES2 {

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
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		String filepath = SystemUtils.USER_HOME + "/Desktop/god.codegen/"
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_INFORMATION_SCHEMA.TABLES2.xlsx";

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

					row = sheet.createRow(rownum);
					cellA = row.createCell(0);
					cellA.setCellValue(tableCatalog); // TABLE_CATALOG

					cellB = row.createCell(1);
					cellB.setCellValue(tableSchema); // TABLE_SCHEMA

					cellC = row.createCell(2);
					cellC.setCellValue(tableName); // TABLE_NAME

					cellD = row.createCell(3);
					cellD.setCellValue(tableType); // TABLE_TYPE

					cellE = row.createCell(4);
					cellE.setCellValue(engine); // ENGINE

					cellF = row.createCell(5);
					cellF.setCellValue(version); // VERSION

					cellG = row.createCell(6);
					cellG.setCellValue(rowFormat); // ROW_FORMAT

					cellH = row.createCell(7);
					cellH.setCellValue(tableRows); // TABLE_ROWS

					cellI = row.createCell(8);
					cellI.setCellValue(avgRowLength); // AVG_ROW_LENGTH

					cellJ = row.createCell(9);
					cellJ.setCellValue(dataLength); // DATA_LENGTH

					cellK = row.createCell(10);
					cellK.setCellValue(maxDataLength); // MAX_DATA_LENGTH

					cellL = row.createCell(11);
					cellL.setCellValue(indexLength); // INDEX_LENGTH

					cellM = row.createCell(12);
					cellM.setCellValue(dataFree); // DATA_FREE

					cellN = row.createCell(13);
					cellN.setCellValue(autoIncrement); // AUTO_INCREMENT

					cellO = row.createCell(14);
					cellO.setCellValue(createTime); // CREATE_TIME

					cellP = row.createCell(15);
					cellP.setCellValue(updateTime); // UPDATE_TIME

					cellQ = row.createCell(16);
					cellQ.setCellValue(checkTime); // CHECK_TIME

					cellR = row.createCell(17);
					cellR.setCellValue(tableCollation); // TABLE_COLLATION

					cellS = row.createCell(18);
					cellS.setCellValue(checksum); // CHECKSUM

					cellT = row.createCell(19);
					cellT.setCellValue(createOptions); // CREATE_OPTIONS

					cellU = row.createCell(20);
					cellU.setCellValue(tableComment); // TABLE_COMMENT

					cellV = row.createCell(21);
					cellV.setCellValue(maxIndexLength); // MAX_INDEX_LENGTH

					cellW = row.createCell(22);
					cellW.setCellValue(temporary); // TEMPORARY

					i++;
					rownum++;

				}

			}

		} catch (SQLException e) {
			egovLogger.error("SQLException");
			e.printStackTrace();
		}

		try {
			egovExcelService.createWorkbook(wb, filepath);
		} catch (Exception e) {
			egovLogger.error("createWorkbook Exception");
		}

	}

}
