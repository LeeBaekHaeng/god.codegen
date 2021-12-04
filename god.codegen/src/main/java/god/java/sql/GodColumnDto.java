package god.java.sql;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GodColumnDto {

	private String tableCat;

	private String tableSchem;

	private String tableName;

	private String columnName;

	private Integer dataType;

	private String typeName;

	private Integer columnSize;

	private Integer bufferLength;

	private Integer decimalDigits;

	private Integer numPrecRadix;

	private Integer nullable;

	private String remarks;

	private String columnDef;

	private Integer sqlDataType;

	private Integer sqlDatetimeSub;

	private Integer charOctetLength;

	private Integer ordinalPosition;

	private String isNullable;

	private String scopeCatalog;

	private String scopeSchema;

	private String scopeTable;

	private Integer sourceDataType;

	private String isAutoincrement;

	@Builder
	public GodColumnDto(String tableCat, String tableSchem, String tableName, String columnName, Integer dataType,
			String typeName, Integer columnSize, Integer bufferLength, Integer decimalDigits, Integer numPrecRadix,
			Integer nullable, String remarks, String columnDef, Integer sqlDataType, Integer sqlDatetimeSub,
			Integer charOctetLength, Integer ordinalPosition, String isNullable, String scopeCatalog,
			String scopeSchema, String scopeTable, Integer sourceDataType, String isAutoincrement) {
		this.tableCat = tableCat;
		this.tableSchem = tableSchem;
		this.tableName = tableName;
		this.columnName = columnName;
		this.dataType = dataType;
		this.typeName = typeName;
		this.columnSize = columnSize;
		this.bufferLength = bufferLength;
		this.decimalDigits = decimalDigits;
		this.numPrecRadix = numPrecRadix;
		this.nullable = nullable;
		this.remarks = remarks;
		this.columnDef = columnDef;
		this.sqlDataType = sqlDataType;
		this.sqlDatetimeSub = sqlDatetimeSub;
		this.charOctetLength = charOctetLength;
		this.ordinalPosition = ordinalPosition;
		this.isNullable = isNullable;
		this.scopeCatalog = scopeCatalog;
		this.scopeSchema = scopeSchema;
		this.scopeTable = scopeTable;
		this.sourceDataType = sourceDataType;
		this.isAutoincrement = isAutoincrement;
	}

}
