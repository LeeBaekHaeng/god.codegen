package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.Entity;
import operation.CrudCodeGen;

public class CrudCodeGenTest {
	private CrudCodeGen crudCodeGen;
	private DataModelContext dataModel;

	@Before
	public void setUp() throws Exception {
		crudCodeGen = new CrudCodeGen();

		dataModel = new DataModelContext();

//		dataModel.setPackageName("pkg");
//		dataModel.setAuthor("홍길동");
//		dataModel.setTeam("실행환경 개발팀");
//		dataModel.setCreateDate("2009.02.01");

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

	}

	private void genAndDiff(String templateFile) throws Exception {
		String result = crudCodeGen.generate(dataModel, templateFile);
	}

	@Test
	public void testSQLMap() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/resource/pkg/EgovSample_Sample2_SQL.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testService() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/java/pkg/service/EgovSample2Service.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testVO() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/java/pkg/service/Sample2VO.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testServiceImpl() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/EgovSample2ServiceImpl.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testDAO() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/Sample2DAO.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testController() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/java/pkg/web/EgovSample2Controller.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testListView() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/jsp/pkg/egovSample2List.vm";

		genAndDiff(templateFile);
	}

	@Test
	public void testRegisterView() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/jsp/pkg/egovSample2Register.vm";

		genAndDiff(templateFile);
	}

}
