package egovframework.example.bat.jdbc.cubrid.incrementer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.support.DefaultDataFieldMaxValueIncrementerFactory;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

/**
 * @author 유지보수팀
 * @since 2013. 01.28
 * @version 1.0
 * @see
 *  <pre>
 *      개정이력(Modification Information)
 *
 *   수정일      수정자           	수정내용
 *  ----------	----------		---------------------------
 *  2013.01.28  유지보수팀     		최초 생성
 *  </pre>
 */

public class CubridDataFieldMaxValueIncrementerFactory extends DefaultDataFieldMaxValueIncrementerFactory {
	private DataSource dataSource;

	public CubridDataFieldMaxValueIncrementerFactory(DataSource dataSource) {
		super(dataSource);
		this.dataSource = dataSource;
	}

	@Override
	public DataFieldMaxValueIncrementer getIncrementer(String incrementerType, String incrementerName) {

		return new CubridSequenceMaxValueIncrementer(dataSource, incrementerName);
	}

}
