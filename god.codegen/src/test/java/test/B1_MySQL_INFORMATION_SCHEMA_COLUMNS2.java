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
public class B1_MySQL_INFORMATION_SCHEMA_COLUMNS2 {

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
				+ EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH-mm-ss", null) + "_INFORMATION_SCHEMA.COLUMNS2.xlsx";

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

					ResultSet columns = stmt
							.executeQuery("SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'COM'");

			) {

				ResultSetMetaData rsmd = columns.getMetaData();
				int columnCount = rsmd.getColumnCount();
				egovLogger.debug("columnCount={}", columnCount);
				StringBuffer sb = new StringBuffer();
				StringBuffer sb2 = new StringBuffer();
				StringBuffer sb3 = new StringBuffer();
				StringBuffer sb4 = new StringBuffer();
				int column2 = 0;
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
						sb.append("String " + columnLabelCcName + " = columns.getString(\"" + columnLabel + "\");");
					} else if ("DATETIME".equals(columnTypeName)) {
						sb.append("String " + columnLabelCcName + " = columns.getString(\"" + columnLabel + "\");");
					} else {
						sb.append("int " + columnLabelCcName + " = columns.getInt(\"" + columnLabel + "\");");
					}
					sb.append("\n");

					sb2.append("egovLogger.debug(\"" + columnLabelCcName + "={}\", " + columnLabelCcName + ");");
					sb2.append("\n");

					char abc = (char) (65 + column2);
					sb3.append("Cell cell" + abc + " = row.createCell(" + column2 + ");\n");
					sb3.append("cell" + abc + ".setCellValue(\"" + columnLabel + "\");\n\n");

					sb4.append("cell" + abc + " = row.createCell(" + column2 + ");\n");
					sb4.append("cell" + abc + ".setCellValue(" + columnLabelCcName + "); // " + columnLabel + "\n\n");

					column2++;
				}
				System.out.println(sb);
				System.out.println(sb2);
				System.out.println(sb3);
				System.out.println(sb4);

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

					String tableCatalog = columns.getString("TABLE_CATALOG");
					String tableSchema = columns.getString("TABLE_SCHEMA");
					String tableName = columns.getString("TABLE_NAME");
					String columnName = columns.getString("COLUMN_NAME");
					int ordinalPosition = columns.getInt("ORDINAL_POSITION");
					String columnDefault = columns.getString("COLUMN_DEFAULT");
					String isNullable = columns.getString("IS_NULLABLE");
					String dataType = columns.getString("DATA_TYPE");
					int characterMaximumLength = columns.getInt("CHARACTER_MAXIMUM_LENGTH");
					int characterOctetLength = columns.getInt("CHARACTER_OCTET_LENGTH");
					int numericPrecision = columns.getInt("NUMERIC_PRECISION");
					int numericScale = columns.getInt("NUMERIC_SCALE");
					int datetimePrecision = columns.getInt("DATETIME_PRECISION");
					String characterSetName = columns.getString("CHARACTER_SET_NAME");
					String collationName = columns.getString("COLLATION_NAME");
					String columnType = columns.getString("COLUMN_TYPE");
					String columnKey = columns.getString("COLUMN_KEY");
					String extra = columns.getString("EXTRA");
					String privileges = columns.getString("PRIVILEGES");
					String columnComment = columns.getString("COLUMN_COMMENT");
					String isGenerated = columns.getString("IS_GENERATED");
					String generationExpression = columns.getString("GENERATION_EXPRESSION");

					egovLogger.debug("i={}", i);
					egovLogger.debug("tableCatalog={}", tableCatalog);
					egovLogger.debug("tableSchema={}", tableSchema);
					egovLogger.debug("tableName={}", tableName);
					egovLogger.debug("columnName={}", columnName);
					egovLogger.debug("ordinalPosition={}", ordinalPosition);
					egovLogger.debug("columnDefault={}", columnDefault);
					egovLogger.debug("isNullable={}", isNullable);
					egovLogger.debug("dataType={}", dataType);
					egovLogger.debug("characterMaximumLength={}", characterMaximumLength);
					egovLogger.debug("characterOctetLength={}", characterOctetLength);
					egovLogger.debug("numericPrecision={}", numericPrecision);
					egovLogger.debug("numericScale={}", numericScale);
					egovLogger.debug("datetimePrecision={}", datetimePrecision);
					egovLogger.debug("characterSetName={}", characterSetName);
					egovLogger.debug("collationName={}", collationName);
					egovLogger.debug("columnType={}", columnType);
					egovLogger.debug("columnKey={}", columnKey);
					egovLogger.debug("extra={}", extra);
					egovLogger.debug("privileges={}", privileges);
					egovLogger.debug("columnComment={}", columnComment);
					egovLogger.debug("isGenerated={}", isGenerated);
					egovLogger.debug("generationExpression={}", generationExpression);
					egovLogger.debug("");

					row = sheet.createRow(rownum);

					cellA = row.createCell(0);
					cellA.setCellValue(tableCatalog); // TABLE_CATALOG

					cellB = row.createCell(1);
					cellB.setCellValue(tableSchema); // TABLE_SCHEMA

					cellC = row.createCell(2);
					cellC.setCellValue(tableName); // TABLE_NAME

					cellD = row.createCell(3);
					cellD.setCellValue(columnName); // COLUMN_NAME

					cellE = row.createCell(4);
					cellE.setCellValue(ordinalPosition); // ORDINAL_POSITION

					cellF = row.createCell(5);
					cellF.setCellValue(columnDefault); // COLUMN_DEFAULT

					cellG = row.createCell(6);
					cellG.setCellValue(isNullable); // IS_NULLABLE

					cellH = row.createCell(7);
					cellH.setCellValue(dataType); // DATA_TYPE

					cellI = row.createCell(8);
					cellI.setCellValue(characterMaximumLength); // CHARACTER_MAXIMUM_LENGTH

					cellJ = row.createCell(9);
					cellJ.setCellValue(characterOctetLength); // CHARACTER_OCTET_LENGTH

					cellK = row.createCell(10);
					cellK.setCellValue(numericPrecision); // NUMERIC_PRECISION

					cellL = row.createCell(11);
					cellL.setCellValue(numericScale); // NUMERIC_SCALE

					cellM = row.createCell(12);
					cellM.setCellValue(datetimePrecision); // DATETIME_PRECISION

					cellN = row.createCell(13);
					cellN.setCellValue(characterSetName); // CHARACTER_SET_NAME

					cellO = row.createCell(14);
					cellO.setCellValue(collationName); // COLLATION_NAME

					cellP = row.createCell(15);
					cellP.setCellValue(columnType); // COLUMN_TYPE

					cellQ = row.createCell(16);
					cellQ.setCellValue(columnKey); // COLUMN_KEY

					cellR = row.createCell(17);
					cellR.setCellValue(extra); // EXTRA

					cellS = row.createCell(18);
					cellS.setCellValue(privileges); // PRIVILEGES

					cellT = row.createCell(19);
					cellT.setCellValue(columnComment); // COLUMN_COMMENT

					cellU = row.createCell(20);
					cellU.setCellValue(isGenerated); // IS_GENERATED

					cellV = row.createCell(21);
					cellV.setCellValue(generationExpression); // GENERATION_EXPRESSION

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
