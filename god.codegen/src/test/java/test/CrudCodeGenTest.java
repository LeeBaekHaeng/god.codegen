package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.egovframe.rte.fdl.string.EgovDateUtil;
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

	@Before
	public void setUp() throws Exception {
		crudCodeGen = new CrudCodeGen();

		dataModel = new DataModelContext();

//		dataModel.setPackageName("pkg");
		dataModel.setAuthor("코드생성팀 이백행");
//		dataModel.setTeam("실행환경 개발팀");
		dataModel.setCreateDate(EgovDateUtil.toString(new Date(), null, null));

		Entity entity = new Entity("SAMPLE2");

		dataModel.setEntity(entity);

		List<Attribute> attributes = new ArrayList<Attribute>();
		List<Attribute> primaryKeys = new ArrayList<Attribute>();

		Attribute attr = new Attribute("ID");
		attr.setJavaType("String");
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

		String name = "egovframework.com.codegen." + entity.getLcName();
		EgovPackage egovPackage = new EgovPackage(name);
		dataModel.setEgovPackage(egovPackage);

		Folder folder = new Folder(name, entity.getPcName());
		dataModel.setFolder(folder);
	}

	@Test
	public void testSQLMap() throws Exception {
		String templateFile = "";
		String result = "";
		String pathname = "";

		templateFile = "eGovFrameTemplates/crud/java/pkg/service/Sample2DefaultVO.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getDefaultVOFolder();
		writeStringToFile(pathname, result);

		templateFile = "eGovFrameTemplates/crud/java/pkg/service/Sample2VO.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getVoFolder();
		writeStringToFile(pathname, result);

//		templateFile = "eGovFrameTemplates/crud/resource/pkg/EgovSample_Sample2_SQL.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);

//		templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/Sample2DAO.vm";
		templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/Sample2DAO2.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getDaoFolder();
		writeStringToFile(pathname, result);

		templateFile = "eGovFrameTemplates/crud/java/pkg/service/EgovSample2Service.vm";
		result = crudCodeGen.generate(dataModel, templateFile);
		pathname = dataModel.getFolder().getServiceFolder();
		writeStringToFile(pathname, result);

//		templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/EgovSample2ServiceImpl.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
//		templateFile = "eGovFrameTemplates/crud/java/pkg/web/EgovSample2Controller.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
//		templateFile = "eGovFrameTemplates/crud/jsp/pkg/egovSample2List.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
//		templateFile = "eGovFrameTemplates/crud/jsp/pkg/egovSample2Register.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
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
