package god.test.cmm.service.impl;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.cmm.service.TestCmm002VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class TestCmm002DAO extends GodComCmmDAOImpl<TestCmm002VO, TestCmm002VO> {

	/**
	 * mapperNamespace 값설정
	 */
	public TestCmm002DAO() {
		super(TestCmm002DAO.class.getSimpleName());
	}

	@Override
	public int insert(final TestCmm002VO vo) {
		log.debug("vo={}", vo);
		return super.insert(vo);
	}

	public int insert2(final TestCmm002VO vo) {
		log.debug("vo={}", vo);
		return super.insert(getMapperNamespace() + "insert2", vo);
	}

	@Override
	public TestCmm002VO select(TestCmm002VO vo) {
		return super.select(vo);
	}

	public TestCmm002VO select2(TestCmm002VO vo) {
		return super.selectOne(getMapperNamespace() + "select2", vo);
	}

}
