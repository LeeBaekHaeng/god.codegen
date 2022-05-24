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
public class B1_DatabaseMetaData_getColumns_MySQL {

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
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_DatabaseMetaData_getColumns.xlsx";

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
				cellA.setCellValue("TABLE_CAT");

				Cell cellB = row.createCell(1);
				cellB.setCellValue("TABLE_SCHEM");

				Cell cellC = row.createCell(2);
				cellC.setCellValue("TABLE_NAME");

				Cell cellD = row.createCell(3);
				cellD.setCellValue("COLUMN_NAME");

				Cell cellE = row.createCell(4);
				cellE.setCellValue("DATA_TYPE");

				Cell cellF = row.createCell(5);
				cellF.setCellValue("TYPE_NAME");

				Cell cellG = row.createCell(6);
				cellG.setCellValue("COLUMN_SIZE");

				Cell cellH = row.createCell(7);
				cellH.setCellValue("BUFFER_LENGTH");

				Cell cellI = row.createCell(8);
				cellI.setCellValue("DECIMAL_DIGITS");

				Cell cellJ = row.createCell(9);
				cellJ.setCellValue("NUM_PREC_RADIX");

				Cell cellK = row.createCell(10);
				cellK.setCellValue("NULLABLE");

				Cell cellL = row.createCell(11);
				cellL.setCellValue("REMARKS");

				Cell cellM = row.createCell(12);
				cellM.setCellValue("COLUMN_DEF");

				Cell cellN = row.createCell(13);
				cellN.setCellValue("SQL_DATA_TYPE");

				Cell cellO = row.createCell(14);
				cellO.setCellValue("SQL_DATETIME_SUB");

				Cell cellP = row.createCell(15);
				cellP.setCellValue("CHAR_OCTET_LENGTH");

				Cell cellQ = row.createCell(16);
				cellQ.setCellValue("ORDINAL_POSITION");

				Cell cellR = row.createCell(17);
				cellR.setCellValue("IS_NULLABLE");

				Cell cellS = row.createCell(18);
				cellS.setCellValue("SCOPE_CATALOG");

				Cell cellT = row.createCell(19);
				cellT.setCellValue("SCOPE_SCHEMA");

				Cell cellU = row.createCell(20);
				cellU.setCellValue("SCOPE_TABLE");

				Cell cellV = row.createCell(21);
				cellV.setCellValue("SOURCE_DATA_TYPE");

				Cell cellW = row.createCell(22);
				cellW.setCellValue("IS_AUTOINCREMENT");

				Cell cellX = row.createCell(23);
				cellX.setCellValue("IS_GENERATEDCOLUMN");

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
					cellA.setCellValue(tableCat); // TABLE_CAT

					cellB = row.createCell(1);
					cellB.setCellValue(tableSchem); // TABLE_SCHEM

					cellC = row.createCell(2);
					cellC.setCellValue(tableName); // TABLE_NAME

					cellD = row.createCell(3);
					cellD.setCellValue(columnName); // COLUMN_NAME

					cellE = row.createCell(4);
					cellE.setCellValue(dataType); // DATA_TYPE

					cellF = row.createCell(5);
					cellF.setCellValue(typeName); // TYPE_NAME

					cellG = row.createCell(6);
					cellG.setCellValue(columnSize); // COLUMN_SIZE

					cellH = row.createCell(7);
					cellH.setCellValue(bufferLength); // BUFFER_LENGTH

					cellI = row.createCell(8);
					cellI.setCellValue(decimalDigits); // DECIMAL_DIGITS

					cellJ = row.createCell(9);
					cellJ.setCellValue(numPrecRadix); // NUM_PREC_RADIX

					cellK = row.createCell(10);
					cellK.setCellValue(nullable); // NULLABLE

					cellL = row.createCell(11);
					cellL.setCellValue(remarks); // REMARKS

					cellM = row.createCell(12);
					cellM.setCellValue(columnDef); // COLUMN_DEF

					cellN = row.createCell(13);
					cellN.setCellValue(sqlDataType); // SQL_DATA_TYPE

					cellO = row.createCell(14);
					cellO.setCellValue(sqlDatetimeSub); // SQL_DATETIME_SUB

					cellP = row.createCell(15);
					cellP.setCellValue(charOctetLength); // CHAR_OCTET_LENGTH

					cellP = row.createCell(16);
					cellP.setCellValue(ordinalPosition); // ORDINAL_POSITION

					cellQ = row.createCell(17);
					cellQ.setCellValue(isNullable); // IS_NULLABLE

					cellS = row.createCell(18);
					cellS.setCellValue(scopeCatalog); // SCOPE_CATALOG

					cellT = row.createCell(19);
					cellT.setCellValue(scopeSchema); // SCOPE_SCHEMA

					cellU = row.createCell(20);
					cellU.setCellValue(scopeTable); // SCOPE_TABLE

					cellV = row.createCell(21);
					cellV.setCellValue(sourceDataType); // SOURCE_DATA_TYPE

					cellW = row.createCell(22);
					cellW.setCellValue(isAutoincrement); // IS_AUTOINCREMENT

					cellX = row.createCell(23);
					cellX.setCellValue(isGeneratedcolumn); // IS_GENERATEDCOLUMN

					i++;
					rownum++;

				}

			} catch (SQLException e) {
				egovLogger.error("getColumns SQLException");
				e.printStackTrace();
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
