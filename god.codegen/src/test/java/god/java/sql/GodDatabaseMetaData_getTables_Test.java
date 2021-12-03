package god.java.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodDatabaseMetaData_getTables_Test {

	@Test
	void test() {
		try (

				Connection con = GodDriverManager_a1.getConnectionMySQL()

		) {

			GodDatabaseMetaData godDatabaseMetaData = new GodDatabaseMetaData();

			String tableNamePattern = null;
//			tableNamePattern = "%";

			List<GodTablesDto> tables = godDatabaseMetaData.getTables(con, tableNamePattern);

			int i = 1;

			for (GodTablesDto table : tables) {
				log.debug("i={}", i);

				log.debug("getTableName={}", table.getTableName());
				log.debug("getTableType={}", table.getTableType());
				log.debug("getRemarks={}", table.getRemarks());

				log.debug("");

				i++;
			}

		} catch (SQLException e) {
			log.error("getConnectionMySQL SQLException");
		}
	}

}
