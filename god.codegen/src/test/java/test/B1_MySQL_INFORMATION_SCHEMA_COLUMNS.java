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
public class B1_MySQL_INFORMATION_SCHEMA_COLUMNS {

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
		String columnNamePattern = "%";

		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		String filepath = SystemUtils.USER_HOME + "/Desktop/god.codegen/"
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_INFORMATION_SCHEMA.COLUMNS.xlsx";

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

					ResultSet columns = metaData.getColumns(catalog, schemaPattern, tableNamePattern,
							columnNamePattern);

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
				cellD.setCellValue("COLUMN_NAME");

				Cell cellE = row.createCell(4);
				cellE.setCellValue("ORDINAL_POSITION");

				Cell cellF = row.createCell(5);
				cellF.setCellValue("COLUMN_DEFAULT");

				Cell cellG = row.createCell(6);
				cellG.setCellValue("IS_NULLABLE");

				Cell cellH = row.createCell(7);
				cellH.setCellValue("DATA_TYPE");

				Cell cellI = row.createCell(8);
				cellI.setCellValue("CHARACTER_MAXIMUM_LENGTH");

				Cell cellJ = row.createCell(9);
				cellJ.setCellValue("CHARACTER_OCTET_LENGTH");

				Cell cellK = row.createCell(10);
				cellK.setCellValue("NUMERIC_PRECISION");

				Cell cellL = row.createCell(11);
				cellL.setCellValue("NUMERIC_SCALE");

				Cell cellM = row.createCell(12);
				cellM.setCellValue("DATETIME_PRECISION");

				Cell cellN = row.createCell(13);
				cellN.setCellValue("CHARACTER_SET_NAME");

				Cell cellO = row.createCell(14);
				cellO.setCellValue("COLLATION_NAME");

				Cell cellP = row.createCell(15);
				cellP.setCellValue("COLUMN_TYPE");

				Cell cellQ = row.createCell(16);
				cellQ.setCellValue("COLUMN_KEY");

				Cell cellR = row.createCell(17);
				cellR.setCellValue("EXTRA");

				Cell cellS = row.createCell(18);
				cellS.setCellValue("PRIVILEGES");

				Cell cellT = row.createCell(19);
				cellT.setCellValue("COLUMN_COMMENT");

				Cell cellU = row.createCell(20);
				cellU.setCellValue("IS_GENERATED");

				Cell cellV = row.createCell(21);
				cellV.setCellValue("GENERATION_EXPRESSION");

				rownum++;

				while (columns.next()) {

					String tableCat = columns.getString("TABLE_CAT");
					String tableSchem = columns.getString("TABLE_SCHEM");
					String tableName = columns.getString("TABLE_NAME");
					String columnName = columns.getString("COLUMN_NAME");
					int dataType = columns.getInt("DATA_TYPE");
					String typeName = columns.getString("TYPE_NAME");
					int columnSize = columns.getInt("COLUMN_SIZE");
					int bufferLength = columns.getInt("BUFFER_LENGTH");
					int decimalDigits = columns.getInt("DECIMAL_DIGITS");
					int numPrecRadix = columns.getInt("NUM_PREC_RADIX");
					int nullable = columns.getInt("NULLABLE");
					String remarks = columns.getString("REMARKS");
					String columnDef = columns.getString("COLUMN_DEF");
					int sqlDataType = columns.getInt("SQL_DATA_TYPE");
					int sqlDatetimeSub = columns.getInt("SQL_DATETIME_SUB");
					int charOctetLength = columns.getInt("CHAR_OCTET_LENGTH");
					int ordinalPosition = columns.getInt("ORDINAL_POSITION");
					String isNullable = columns.getString("IS_NULLABLE");
					String scopeCatalog = columns.getString("SCOPE_CATALOG");
					String scopeSchema = columns.getString("SCOPE_SCHEMA");
					String scopeTable = columns.getString("SCOPE_TABLE");
					short sourceDataType = columns.getShort("SOURCE_DATA_TYPE");
					String isAutoincrement = columns.getString("IS_AUTOINCREMENT");
					String isGeneratedcolumn = columns.getString("IS_GENERATEDCOLUMN");

					egovLogger.debug("i={}", i);
//					egovLogger.debug("tables={}", tables);
					egovLogger.debug("tableCat={}", tableCat);
					egovLogger.debug("tableSchem={}", tableSchem);
					egovLogger.debug("tableName={}", tableName);
					egovLogger.debug("columnName={}", columnName);
					egovLogger.debug("dataType={}", dataType);
					egovLogger.debug("typeName={}", typeName);
					egovLogger.debug("columnSize={}", columnSize);
					egovLogger.debug("bufferLength={}", bufferLength);
					egovLogger.debug("decimalDigits={}", decimalDigits);
					egovLogger.debug("numPrecRadix={}", numPrecRadix);
					egovLogger.debug("nullable={}", nullable);
					egovLogger.debug("remarks={}", remarks);
					egovLogger.debug("columnDef={}", columnDef);
					egovLogger.debug("sqlDataType={}", sqlDataType);
					egovLogger.debug("sqlDatetimeSub={}", sqlDatetimeSub);
					egovLogger.debug("charOctetLength={}", charOctetLength);
					egovLogger.debug("ordinalPosition={}", ordinalPosition);
					egovLogger.debug("isNullable={}", isNullable);
					egovLogger.debug("scopeCatalog={}", scopeCatalog);
					egovLogger.debug("scopeSchema={}", scopeSchema);
					egovLogger.debug("scopeTable={}", scopeTable);
					egovLogger.debug("sourceDataType={}", sourceDataType);
					egovLogger.debug("isAutoincrement={}", isAutoincrement);
					egovLogger.debug("isGeneratedcolumn={}", isGeneratedcolumn);
					egovLogger.debug("");

					row = sheet.createRow(rownum);
					cellA = row.createCell(0);
					cellA.setCellValue(tableCat); // TABLE_CATALOG

					cellB = row.createCell(1);
					cellB.setCellValue(tableSchem); // TABLE_SCHEMA

					cellC = row.createCell(2);
					cellC.setCellValue(tableName); // TABLE_NAME

					cellD = row.createCell(3);
					cellD.setCellValue(columnName); // COLUMN_NAME

					cellE = row.createCell(4);
					cellE.setCellValue(ordinalPosition); // ORDINAL_POSITION

					cellF = row.createCell(5);
					cellF.setCellValue(columnDef); // COLUMN_DEFAULT

					cellG = row.createCell(6);
					cellG.setCellValue(nullable); // IS_NULLABLE

					cellH = row.createCell(7);
					cellH.setCellValue(dataType); // DATA_TYPE

					cellI = row.createCell(8);
					cellI.setCellValue(columnSize); // CHARACTER_MAXIMUM_LENGTH

					cellJ = row.createCell(9);
					cellJ.setCellValue(numPrecRadix); // CHARACTER_OCTET_LENGTH

					cellK = row.createCell(10);
					cellK.setCellValue(""); // NUMERIC_PRECISION

					cellL = row.createCell(11);
					cellL.setCellValue(""); // NUMERIC_SCALE

					cellM = row.createCell(12);
					cellM.setCellValue(""); // DATETIME_PRECISION

					cellN = row.createCell(13);
					cellN.setCellValue(""); // CHARACTER_SET_NAME

					cellO = row.createCell(14);
					cellO.setCellValue(""); // COLLATION_NAME

					cellP = row.createCell(15);
					cellP.setCellValue(""); // COLUMN_TYPE

					cellP = row.createCell(16);
					cellP.setCellValue(""); // COLUMN_KEY

					cellQ = row.createCell(17);
					cellQ.setCellValue(""); // EXTRA

					cellS = row.createCell(18);
					cellS.setCellValue(""); // PRIVILEGES

					cellT = row.createCell(19);
					cellT.setCellValue(remarks); // COLUMN_COMMENT

					cellU = row.createCell(20);
					cellU.setCellValue(""); // IS_GENERATED

					cellV = row.createCell(21);
					cellV.setCellValue(""); // GENERATION_EXPRESSION

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
