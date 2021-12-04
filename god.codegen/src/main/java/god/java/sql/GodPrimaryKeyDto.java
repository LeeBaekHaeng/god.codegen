package god.java.sql;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GodPrimaryKeyDto {

	private String tableCat;

	private String tableSchem;

	private String tableName;

	private String columnName;

	private Integer keySeq;

	@Builder
	public GodPrimaryKeyDto(String tableCat, String tableSchem, String tableName, String columnName, Integer keySeq) {
		this.tableCat = tableCat;
		this.tableSchem = tableSchem;
		this.tableName = tableName;
		this.columnName = columnName;
		this.keySeq = keySeq;
	}

}
