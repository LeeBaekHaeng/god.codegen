package god.java.sql;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GodTablesDto {

	private String tableCat;

	private String tableSchem;

	private String tableName;

	private String tableType;

	private String remarks;

	private String typeCat;

	private String typeSchem;

	private String typeName;

	private String selfReferencingColName;

	@Builder
	public GodTablesDto(String tableCat, String tableSchem, String tableName, String tableType, String remarks,
			String typeCat, String typeSchem, String typeName, String selfReferencingColName) {
		this.tableCat = tableCat;
		this.tableSchem = tableSchem;
		this.tableName = tableName;
		this.tableType = tableType;
		this.remarks = remarks;
		this.typeCat = typeCat;
		this.typeSchem = typeSchem;
		this.typeName = typeName;
		this.selfReferencingColName = selfReferencingColName;
	}

}
