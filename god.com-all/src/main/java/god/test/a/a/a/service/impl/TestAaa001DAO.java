package god.test.a.a.a.service.impl;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmm001DAOImpl;
import god.test.a.a.a.service.TestAaa001VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class TestAaa001DAO extends GodComCmm001DAOImpl<TestAaa001VO, TestAaa001VO> {

	/**
	 * mapperNamespace 값설정
	 */
	public TestAaa001DAO() {
		super(TestAaa001DAO.class.getSimpleName());
		log.debug("getMapperNamespace={}", getMapperNamespace());
	}

	@Override
	public int insert(TestAaa001VO vo) {
		log.debug("이백행");
		return super.insert(vo);
	}

	public int insert3(final TestAaa001VO vo) {
		return super.insert(getMapperNamespace() + "insert3", vo);
	}

}
