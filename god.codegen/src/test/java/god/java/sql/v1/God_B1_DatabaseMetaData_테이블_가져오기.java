package god.java.sql.v1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class God_B1_DatabaseMetaData_테이블_가져오기 extends God_A1_CodeGenBase {

	String types[] = {};
//	String types[] = { "TABLE", "VIEW", "SYNONYM" };

	@Test
	void test() {
		log.debug("test");

		try (

				Connection con = getConnection();

		) {
			DatabaseMetaData dmd = con.getMetaData();

			try (

					ResultSet tables = dmd.getTables(catalog, schemaPattern, tableNamePattern, types);

			) {
				int i = 1;

				while (tables.next()) {
					log.debug("i={}", i);

					log.debug("TABLE_CAT={}", tables.getString("TABLE_CAT"));
					log.debug("TABLE_SCHEM={}", tables.getString("TABLE_SCHEM"));
					log.debug("TABLE_NAME={}", tables.getString("TABLE_NAME"));
					log.debug("TABLE_TYPE={}", tables.getString("TABLE_TYPE"));
					log.debug("REMARKS={}", tables.getString("REMARKS"));
					log.debug("TYPE_CAT={}", tables.getString("TYPE_CAT"));
					log.debug("TYPE_SCHEM={}", tables.getString("TYPE_SCHEM"));
					log.debug("TYPE_NAME={}", tables.getString("TYPE_NAME"));
					log.debug("SELF_REFERENCING_COL_NAME={}", tables.getString("SELF_REFERENCING_COL_NAME"));
					log.debug("REF_GENERATION={}", tables.getString("REF_GENERATION"));

					log.debug("");

					i++;
				}
			}
		} catch (SQLException e) {
			log.error("SQLException");
		}
	}

}
