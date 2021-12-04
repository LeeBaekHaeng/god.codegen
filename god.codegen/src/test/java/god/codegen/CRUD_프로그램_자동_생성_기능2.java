package god.codegen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.Entity;
import god.java.sql.GodColumnDto;
import god.java.sql.GodDatabaseMetaData;
import god.java.sql.GodDatabaseMetaDataDto;
import god.java.sql.GodDriverManager_a1;
import god.java.sql.GodPrimaryKeyDto;
import lombok.extern.slf4j.Slf4j;
import operation.CrudCodeGen;

@Slf4j
class CRUD_프로그램_자동_생성_기능2 {

	void test() {
		try (Connection con = GodDriverManager_a1.getConnection();) {

			GodDatabaseMetaData godDatabaseMetaData = new GodDatabaseMetaData();

			String tableNamePattern = null;
//			tableNamePattern = "%";
			tableNamePattern = "comtcadministcode";

			List<GodDatabaseMetaDataDto> godDatabaseMetaDataDtos = godDatabaseMetaData.getMetaData(con,
					tableNamePattern);

			int i = 1;

			for (GodDatabaseMetaDataDto godDatabaseMetaDataDto : godDatabaseMetaDataDtos) {
				log.debug("i={}", i);

				log.debug("getTableName={}", godDatabaseMetaDataDto.getGodTableDto().getTableName());
				log.debug("getTableType={}", godDatabaseMetaDataDto.getGodTableDto().getTableType());
				log.debug("getRemarks={}", godDatabaseMetaDataDto.getGodTableDto().getRemarks());

				log.debug("");
				for (GodColumnDto column : godDatabaseMetaDataDto.getGodColumnDtos()) {
					log.debug("getColumnName={}", column.getColumnName());
					log.debug("getRemarks={}", column.getRemarks());
				}

				log.debug("");
				for (GodPrimaryKeyDto primaryKey : godDatabaseMetaDataDto.getGodPrimaryKeyDtos()) {
					log.debug("getColumnName={}", primaryKey.getColumnName());
					log.debug("getKeySeq={}", primaryKey.getKeySeq());
				}

				log.debug("");

				i++;
			}

		} catch (SQLException e) {
			log.error("SQLException");
		}
	}

	private CrudCodeGen crudCodeGen;
	private DataModelContext dataModel;

	@Test
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

		String templateFile = "eGovFrameTemplates/crud/resource/pkg/EgovSample_Sample2_SQL.vm";
		String result = crudCodeGen.generate(dataModel, templateFile);
	}

}
