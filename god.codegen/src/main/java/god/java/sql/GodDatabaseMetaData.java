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

	public List<GodDatabaseMetaDataDto> getMetaData(Connection con, String tableNamePattern) {
		List<GodDatabaseMetaDataDto> godDatabaseMetaDataDtos = new ArrayList<>();

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
					String tableName = tables.getString("TABLE_NAME");

					GodDatabaseMetaDataDto godDatabaseMetaDataDto = new GodDatabaseMetaDataDto();

					godDatabaseMetaDataDto.setGodTableDto(getGodTableDto(tables, tableName));

					godDatabaseMetaDataDto.setGodColumnDtos(getGodColumnDtos(dmd, catalog, schemaPattern, tableName));

					godDatabaseMetaDataDtos.add(godDatabaseMetaDataDto);
				}

			}

		} catch (SQLException e) {
			log.error("SQLException");
		}

		return godDatabaseMetaDataDtos;
	}

	private GodTableDto getGodTableDto(ResultSet tables, String tableName) throws SQLException {
		GodTableDto godTableDto = GodTableDto.builder()

				.tableCat(tables.getString("TABLE_CAT"))

				.tableSchem(tables.getString("TABLE_SCHEM"))

				.tableName(tableName)

				.tableType(tables.getString("TABLE_TYPE"))

				.remarks(tables.getString("REMARKS"))

				.typeCat(tables.getString("TYPE_CAT"))

				.typeSchem(tables.getString("TYPE_SCHEM"))

				.typeName(tables.getString("TYPE_NAME"))

				.selfReferencingColName(tables.getString("SELF_REFERENCING_COL_NAME"))

				.build();
		return godTableDto;
	}

	private List<GodColumnDto> getGodColumnDtos(DatabaseMetaData dmd, String catalog, String schemaPattern,
			String tableName) throws SQLException {
		List<GodColumnDto> godColumnDtos = new ArrayList<>();

		try (

				ResultSet columns = dmd.getColumns(catalog, schemaPattern, tableName, null);

		) {

			while (columns.next()) {
				GodColumnDto godColumnsDto = GodColumnDto.builder()

						.tableCat(columns.getString("TABLE_CAT"))

						.tableSchem(columns.getString("TABLE_SCHEM"))

						.tableName(columns.getString("TABLE_NAME"))

						.columnName(columns.getString("COLUMN_NAME"))

						.dataType(columns.getInt("DATA_TYPE"))

						.typeName(columns.getString("TYPE_NAME"))

						.columnSize(columns.getInt("COLUMN_SIZE"))

						.bufferLength(columns.getInt("BUFFER_LENGTH"))

						.decimalDigits(columns.getInt("DECIMAL_DIGITS"))

						.numPrecRadix(columns.getInt("NUM_PREC_RADIX"))

						.nullable(columns.getInt("NULLABLE"))

						.remarks(columns.getString("REMARKS"))

						.columnDef(columns.getString("COLUMN_DEF"))

						.sqlDataType(columns.getInt("SQL_DATA_TYPE"))

						.sqlDatetimeSub(columns.getInt("SQL_DATETIME_SUB"))

						.charOctetLength(columns.getInt("CHAR_OCTET_LENGTH"))

						.ordinalPosition(columns.getInt("ORDINAL_POSITION"))

						.isNullable(columns.getString("IS_NULLABLE"))

						.scopeCatalog(columns.getString("SCOPE_CATALOG"))

						.scopeSchema(columns.getString("SCOPE_SCHEMA"))

						.scopeTable(columns.getString("SCOPE_TABLE"))

						.sourceDataType(columns.getInt("SOURCE_DATA_TYPE"))

						.isAutoincrement(columns.getString("IS_AUTOINCREMENT"))

						.build();

				godColumnDtos.add(godColumnsDto);
			}

		}

		return godColumnDtos;
	}

}
