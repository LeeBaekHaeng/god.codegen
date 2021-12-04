package god.codegen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import egovframework.dev.imp.codegen.template.model.Attribute;
import egovframework.dev.imp.codegen.template.model.DataModelContext;
import egovframework.dev.imp.codegen.template.model.Entity;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.java.sql.GodColumnDto;
import god.java.sql.GodDatabaseMetaData;
import god.java.sql.GodDatabaseMetaDataDto;
import god.java.sql.GodDriverManager_a1;
import god.java.sql.GodPrimaryKeyDto;
import lombok.extern.slf4j.Slf4j;
import operation.CrudCodeGen;

@Slf4j
class CRUD_프로그램_자동_생성_기능2 {

	List<GodDatabaseMetaDataDto> godDatabaseMetaDataDtos;

	void test() {
		try (Connection con = GodDriverManager_a1.getConnection();) {

			GodDatabaseMetaData godDatabaseMetaData = new GodDatabaseMetaData();

			String tableNamePattern = null;
//			tableNamePattern = "%";
//			tableNamePattern = "comtcadministcode";
			tableNamePattern = "comtcadministcoderecptnlog";

			godDatabaseMetaDataDtos = godDatabaseMetaData.getMetaData(con, tableNamePattern);

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
		test();

		crudCodeGen = new CrudCodeGen();

		for (GodDatabaseMetaDataDto godDatabaseMetaDataDto : godDatabaseMetaDataDtos) {
			dataModel = new DataModelContext();

//			dataModel.setPackageName("pkg");
			dataModel.setAuthor("이백행");
//			dataModel.setTeam("갓소프트");
			dataModel.setCreateDate(EgovDateUtil.toString(new Date(), null, null));

			dataModel.setVender(DataModelContext.VENDER_MySql); // HSQLDB, Oracle, MySql

			Entity entity = new Entity(godDatabaseMetaDataDto.getGodTableDto().getTableName());

			dataModel.setPrefixPackage("god.test");
			dataModel.setVoPackage(entity.getLcName());
			dataModel.setMapperPackage(entity.getLcName());

			dataModel.setEntity(entity);

			List<Attribute> attributes = new ArrayList<Attribute>();
			List<Attribute> primaryKeys = new ArrayList<Attribute>();

			for (GodColumnDto column : godDatabaseMetaDataDto.getGodColumnDtos()) {
				log.debug("getColumnName={}", column.getColumnName());
				log.debug("getRemarks={}", column.getRemarks());

				Attribute attr = new Attribute(column.getColumnName());
				attr.setJavaType(column.getTypeName());
				attributes.add(attr);

				for (GodPrimaryKeyDto primaryKey : godDatabaseMetaDataDto.getGodPrimaryKeyDtos()) {
					log.debug("getColumnName={}", primaryKey.getColumnName());
					log.debug("getKeySeq={}", primaryKey.getKeySeq());

					if (primaryKey.getColumnName().equals(column.getColumnName())) {
						primaryKeys.add(attr);
					}
				}
			}

			dataModel.setAttributes(attributes);
			dataModel.setPrimaryKeys(primaryKeys);

			generate();
		}
	}

	public void generate() throws Exception {
		String templateFile = "eGovFrameTemplates/crud/resource/pkg/EgovSample_Sample2_SQL.vm";
		String result = crudCodeGen.generate(dataModel, templateFile);

		templateFile = "eGovFrameTemplates/crud/resource/pkg/EgovSample_Sample2_MAPPER.vm";
		result = crudCodeGen.generate(dataModel, templateFile);

		templateFile = "eGovFrameTemplates/crud/java/pkg/service/Sample2VO.vm";
		result = crudCodeGen.generate(dataModel, templateFile);

//		templateFile = "eGovFrameTemplates/crud/java/pkg/service/Sample2DefaultVO.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
//		templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/Sample2DAO.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
//		templateFile = "eGovFrameTemplates/crud/java/pkg/service/impl/Sample2Mapper.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
//		templateFile = "eGovFrameTemplates/crud/java/pkg/service/EgovSample2Service.vm";
//		result = crudCodeGen.generate(dataModel, templateFile);
//
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

}
