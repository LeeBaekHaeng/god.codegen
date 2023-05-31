package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.egovframe.rte.fdl.excel.EgovExcelService;
import org.egovframe.rte.fdl.excel.impl.EgovExcelServiceImpl;
import org.egovframe.rte.fdl.excel.util.EgovExcelUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.codegen.sample2.service.impl.Sample2ServiceImplTest;
import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.EgovPackage;
import egovframework.dev.imp.codegen.template.model.Entity;
import egovframework.dev.imp.codegen.template.model.Folder;
import operation.CrudCodeGen;

public class CRUD_프로그램_자동_생성_기능 {

	protected Logger egovLogger = LoggerFactory.getLogger(Sample2ServiceImplTest.class);

	private final EgovExcelService egovExcelService = new EgovExcelServiceImpl();

//	private CrudCodeGen crudCodeGen;
//	private DataModelContext dataModel;

//	String eGovFrameTemplates = "eGovFrameTemplates/crud/";
//	String eGovFrameTemplates = "eGovFrameTemplates/crud2/";
//	String eGovFrameTemplates = "eGovFrameTemplates/crud-com/";
	String eGovFrameTemplates = "eGovFrameTemplates/crud-com-4.1.0/";

	@Test
	public void a1_test() {
		String parent = SystemUtils.USER_HOME + "/Desktop/god.codegen/";
		String child = "2023-05-31 13-27-12_batchmenubind_메뉴샘플.xls";
		String filepath = new File(parent, child).getAbsolutePath();
		egovLogger.debug("filepath={}", filepath);

		Workbook wb = null;
		try {
			wb = egovExcelService.loadWorkbook(filepath);
		} catch (Exception e) {
			egovLogger.error("loadWorkbook Exception");
			return;
		}

		Sheet sheet = wb.getSheetAt(0);
		String sheetName = sheet.getSheetName();

		CrudCodeGen crudCodeGen = new CrudCodeGen();
		DataModelContext dataModel = new DataModelContext();

		for (Row row : sheet) {
			String cellF = EgovExcelUtil.getValue(row.getCell(5)); // 코드생성여부
			if (!"Y".equals(cellF)) {
				continue;
			}

			String cellG = EgovExcelUtil.getValue(row.getCell(6)); // 테이블 영문명
			String cellH = EgovExcelUtil.getValue(row.getCell(7)); // 관련엔터티명

			int rowNum = row.getRowNum();
			egovLogger.debug("rowNum={}", rowNum);
			for (Cell cell : row) {
				egovLogger.debug("sheetName={}, rowNum={}, getValue={}", sheetName, rowNum,
						EgovExcelUtil.getValue(cell));
			}
			egovLogger.debug("");

			dataModel = new DataModelContext();
			set(dataModel, cellG, cellH);
			generate(crudCodeGen, dataModel);
		}
	}

	void set(DataModelContext dataModel, String cellG, String cellH) {
//		dataModel.setVender("HSQLDB");
//		dataModel.setVender("Oracle");
		dataModel.setVender("MySql");
//		dataModel.setVender("postgres");

//		dataModel.setPackageName("pkg");
		dataModel.setAuthor("코드생성팀 이백행");
//		dataModel.setTeam("실행환경 개발팀");
//		dataModel.setCreateDate(EgovDateUtil.toString(new Date(), null, null));
		dataModel.setCreateDate("2022-04-24");

		Entity entity = new Entity(cellH);
		entity.setTableName(cellG);

		dataModel.setEntity(entity);

		List<Attribute> attributes = new ArrayList<Attribute>();
		List<Attribute> primaryKeys = new ArrayList<Attribute>();

		Sheet sheet = getColumns();

		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}

			String cellC = EgovExcelUtil.getValue(row.getCell(2)); // TABLE_NAME
			String cellD = EgovExcelUtil.getValue(row.getCell(3)); // COLUMN_NAME
			String cellH2 = EgovExcelUtil.getValue(row.getCell(7)); // DATA_TYPE
			String cellQ = EgovExcelUtil.getValue(row.getCell(16)); // COLUMN_KEY

			if (cellG.equals(cellC)) {
				Attribute attr = new Attribute(cellD);
				if ("decimal".equals(cellH2)) {
					attr.setJavaType("int");
				} else {
					attr.setJavaType("String");
				}
				if ("PRI".equals(cellQ)) {
					attr.setPrimaryKey(true);
					primaryKeys.add(attr);
				}
				attributes.add(attr);
			}
		}

		dataModel.setAttributes(attributes);
		dataModel.setPrimaryKeys(primaryKeys);

		String topLevelPackage = "egovframework.com";
		String egovPackageName2 = "codegen";
		String egovPackageName3 = entity.getCcName().toLowerCase();
		EgovPackage egovPackage = new EgovPackage(topLevelPackage, egovPackageName2, egovPackageName3);
		dataModel.setEgovPackage(egovPackage);

		Folder folder = new Folder(topLevelPackage, egovPackageName2, egovPackageName3, entity.getPcName());
		dataModel.setFolder(folder);
	}

	void generate(CrudCodeGen crudCodeGen, DataModelContext dataModel) {
		String templateFile = "";
		String result = "";
		String pathname = "";

		templateFile = eGovFrameTemplates + "java/pkg/service/Sample2DefaultVO.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getDefaultVOFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/Sample2VO.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getVoPackageFolder();
		writeStringToFile(pathname, result);

//		templateFile = eGovFrameTemplates + "resource/pkg/EgovSample_Sample2_SQL.vm";
//		try {
//			result = crudCodeGen.generate(dataModel, templateFile);
//		} catch (Exception e) {
//			System.err.println("generate Exception");
//		}
//		pathname = dataModel.getFolder().getSqlMapFolder();
//		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "resource/pkg/EgovSample_Sample2_MAPPER.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getMapperFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2DAO.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getDaoPackageFolder();
		writeStringToFile(pathname, result);

//		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2Mapper.vm";
//		try {
//			result = crudCodeGen.generate(dataModel, templateFile);
//		} catch (Exception e) {
//			System.err.println("generate Exception");
//		}
//		pathname = dataModel.getFolder().getMapperPackageFolder();
//		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/EgovSample2Service.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getServicePackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/EgovSample2ServiceImpl.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getImplPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/web/EgovSample2Controller.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getControllerPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "jsp/pkg/egovSample2List.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getJspListFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "jsp/pkg/egovSample2Register.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getJspRegistFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "jsp/pkg/egovSample2Detail.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getJspDetailFolder();
		writeStringToFile(pathname, result);

		// test
		templateFile = eGovFrameTemplates + "java/pkg/service/Sample2VOTest.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getVoPackageTestFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2DAOTest.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getDaoPackageTestFolder();
		writeStringToFile(pathname, result);

//		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2MapperTest.vm";
//		try {
//			result = crudCodeGen.generate(dataModel, templateFile);
//		} catch (Exception e) {
//			System.err.println("generate Exception");
//		}
//		pathname = dataModel.getFolder().getMapperPackageTestFolder();
//		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/EgovSample2ServiceImplTest.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getImplPackageTestFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/web/EgovSample2ControllerTest.vm";
		try {
			result = crudCodeGen.generate(dataModel, templateFile);
		} catch (Exception e) {
			System.err.println("generate Exception");
		}
		pathname = dataModel.getFolder().getControllerPackageTestFolder();
		writeStringToFile(pathname, result);
	}

	private void writeStringToFile(String pathname, String result) {
		System.out.println(pathname);
		try {
			FileUtils.writeStringToFile(new File(pathname), result, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("파일 생성 실패: " + pathname);
		}
	}

	@SuppressWarnings("resource")
	private Sheet getColumns() {
		String parent = SystemUtils.USER_HOME + "/Desktop/god.codegen/";
		String child = "2023-05-31 13-28-41_INFORMATION_SCHEMA.COLUMNS.xlsx";
		String filepath = new File(parent, child).getAbsolutePath();
		egovLogger.debug("filepath={}", filepath);

		XSSFWorkbook wb = new XSSFWorkbook();
		try {
			wb = egovExcelService.loadWorkbook(filepath, wb);
		} catch (Exception e) {
			egovLogger.error("loadWorkbook Exception");
			return null;
		}

		return wb.getSheetAt(0);
	}

}
