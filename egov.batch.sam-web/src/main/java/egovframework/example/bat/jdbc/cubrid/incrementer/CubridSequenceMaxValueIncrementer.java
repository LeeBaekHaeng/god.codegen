package egovframework.example.bat.jdbc.cubrid.incrementer;

import javax.sql.DataSource;

import org.springframework.jdbc.support.incrementer.AbstractSequenceMaxValueIncrementer;

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

public class CubridSequenceMaxValueIncrementer extends AbstractSequenceMaxValueIncrementer {

	/**
	 * Default constructor for bean property style usage.
	 * @see #setDataSource
	 * @see #setIncrementerName
	 */
	public CubridSequenceMaxValueIncrementer() {
	}

	/**
	 * Convenience constructor.
	 * @param dataSource the DataSource to use
	 * @param incrementerName the name of the sequence/table to use
	 */
	public CubridSequenceMaxValueIncrementer(DataSource dataSource, String incrementerName) {
		super(dataSource, incrementerName);
	}

	@Override
	protected String getSequenceQuery() {
		return "select " + getIncrementerName() + ".nextval from db_root";
	}

}