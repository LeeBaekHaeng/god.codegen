package god.java.sql;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GodDatabaseMetaDataDto {

	private GodTableDto godTableDto;

	private List<GodColumnDto> godColumnDtos;

}
