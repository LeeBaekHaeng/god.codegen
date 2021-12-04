package god.codegen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import god.java.sql.GodColumnDto;
import god.java.sql.GodDatabaseMetaData;
import god.java.sql.GodDatabaseMetaDataDto;
import god.java.sql.GodDriverManager_a1;
import god.java.sql.GodPrimaryKeyDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CRUD_프로그램_자동_생성_기능 {

	@Test
	void test() {
		try (

				Connection con = GodDriverManager_a1.getConnection()

		) {

			GodDatabaseMetaData godDatabaseMetaData = new GodDatabaseMetaData();

			String tableNamePattern = null;
//			tableNamePattern = "%";
//			tableNamePattern = "comtcadministcode";

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
			log.error("getConnection SQLException");
		}
	}

}
