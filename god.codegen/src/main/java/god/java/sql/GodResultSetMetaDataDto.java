package god.java.sql;

import egovframework.rte.psl.dataaccess.util.CamelUtil;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GodResultSetMetaDataDto {

	private int columnCount;

	private String columnLabel;

	private int columnType;

	private String columnTypeName;

	private String columnClassName;

	//

	private String columnLabelCamelCase;

	@Builder
	public GodResultSetMetaDataDto(int columnCount, String columnLabel, int columnType, String columnTypeName,
			String columnClassName) {
		this.columnCount = columnCount;
		this.columnLabel = columnLabel;
		this.columnType = columnType;
		this.columnTypeName = columnTypeName;
		this.columnClassName = columnClassName.substring(columnClassName.lastIndexOf(".") + 1);

		this.columnLabelCamelCase = CamelUtil.convert2CamelCase(columnLabel);
	}

}
