package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.EgovPackage;
import egovframework.dev.imp.codegen.template.model.Entity;
import egovframework.dev.imp.codegen.template.model.Folder;
import operation.CrudCodeGen;

public class CrudCodeGenTest {
	private CrudCodeGen crudCodeGen;
	private DataModelContext dataModel;

//	String eGovFrameTemplates = "eGovFrameTemplates/crud/";
//	String eGovFrameTemplates = "eGovFrameTemplates/crud2/";
	String eGovFrameTemplates = "eGovFrameTemplates/crud-com/";

	@Before
	public void setUp() throws Exception {
		crudCodeGen = new CrudCodeGen();

		dataModel = new DataModelContext();

//		dataModel.setVender("HSQLDB");
//		dataModel.setVender("Oracle");
		dataModel.setVender("MySql");
//		dataModel.setVender("postgres");

//		dataModel.setPackageName("pkg");
		dataModel.setAuthor("코드생성팀 이백행");
//		dataModel.setTeam("실행환경 개발팀");
//		dataModel.setCreateDate(EgovDateUtil.toString(new Date(), null, null));
		dataModel.setCreateDate("2022-04-24");

		Entity entity = new Entity("SAMPLE2");

		dataModel.setEntity(entity);

		List<Attribute> attributes = new ArrayList<Attribute>();
		List<Attribute> primaryKeys = new ArrayList<Attribute>();

		Attribute attr = new Attribute("ID");
		attr.setJavaType("String");
		attr.setPrimaryKey(true);
		attributes.add(attr);
		primaryKeys.add(attr);

		attr = new Attribute("NAME");
		attr.setJavaType("String");
		attributes.add(attr);
//		primaryKeys.add(attr);

		attr = new Attribute("DESCRIPTION");
		attr.setJavaType("String");
		attributes.add(attr);

		attr = new Attribute("USE_YN");
		attr.setJavaType("String");
		attributes.add(attr);

		attr = new Attribute("REG_USER");
		attr.setJavaType("String");
		attributes.add(attr);

		dataModel.setAttributes(attributes);
		dataModel.setPrimaryKeys(primaryKeys);

		String topLevelPackage = "egovframework.com";
		String egovPackageName2 = "codegen";
		String egovPackageName3 = entity.getLcName();
		EgovPackage egovPackage = new EgovPackage(topLevelPackage, egovPackageName2, egovPackageName3);
		dataModel.setEgovPackage(egovPackage);

		Folder folder = new Folder(topLevelPackage, egovPackageName2, egovPackageName3, entity.getPcName());
		dataModel.setFolder(folder);
	}

	@Test
	public void testSQLMap() throws Exception {
		String templateFile = "";
		String result = "";
		String pathname = "";

		templateFile = eGovFrameTemplates + "java/pkg/service/Sample2DefaultVO.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getDefaultVOFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/Sample2VO.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getVoPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "resource/pkg/EgovSample_Sample2_SQL.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getSqlMapFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "resource/pkg/EgovSample_Sample2_MAPPER.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getMapperFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2DAO.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getDaoPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2Mapper.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getMapperPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/EgovSample2Service.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getServicePackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/service/impl/EgovSample2ServiceImpl.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getImplPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "java/pkg/web/EgovSample2Controller.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getControllerPackageFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "jsp/pkg/egovSample2List.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getJspListFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "jsp/pkg/egovSample2Register.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getJspRegistFolder();
		writeStringToFile(pathname, result);

		templateFile = eGovFrameTemplates + "jsp/pkg/egovSample2Detail.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getJspDetailFolder();
		writeStringToFile(pathname, result);

		// test
		templateFile = eGovFrameTemplates + "java/pkg/service/Sample2VOTest.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getVoPackageTestFolder();
		writeStringToFile(pathname, result);
		
		templateFile = eGovFrameTemplates + "java/pkg/service/impl/Sample2DAOTest.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getDaoPackageTestFolder();
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

}
