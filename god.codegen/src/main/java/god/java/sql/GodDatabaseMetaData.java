package god.java.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GodDatabaseMetaData {

	public List<GodTablesDto> getTables(Connection con, String tableNamePattern) {
//		log.debug("getTables");

		List<GodTablesDto> godTablesDtos = new ArrayList<>();

		try {

			DatabaseMetaData dmd = con.getMetaData();

			String catalog = null;
			String schemaPattern = null;
//			String tableNamePattern = null;
			String types[] = {};

			try (

					ResultSet tables = dmd.getTables(catalog, schemaPattern, tableNamePattern, types);

			) {

				while (tables.next()) {
					GodTablesDto godTablesDto = GodTablesDto.builder()

							.tableCat(tables.getString("TABLE_CAT"))

							.tableSchem(tables.getString("TABLE_SCHEM"))

							.tableName(tables.getString("TABLE_NAME"))

							.tableType(tables.getString("TABLE_TYPE"))

							.remarks(tables.getString("REMARKS"))

							.typeCat(tables.getString("TYPE_CAT"))

							.typeSchem(tables.getString("TYPE_SCHEM"))

							.typeName(tables.getString("TYPE_NAME"))

							.selfReferencingColName(tables.getString("SELF_REFERENCING_COL_NAME"))

							.build();

					godTablesDtos.add(godTablesDto);
				}

			} catch (SQLException e) {
				log.error("getTables SQLException");
			}

		} catch (SQLException e) {
			log.error("DatabaseMetaData SQLException");
		}

		return godTablesDtos;
	}

}
