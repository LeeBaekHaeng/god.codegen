package god.test.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.cmm.service.TestCmm001VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class TestCmm001DAO extends GodComCmmDAOImpl<TestCmm001VO, TestCmm001VO> {

	/**
	 * mapperNamespace 값설정
	 */
	public TestCmm001DAO() {
		super(TestCmm001DAO.class.getSimpleName());
	}

	@Override
	public int insert(final TestCmm001VO vo) {
		log.debug("vo={}", vo);
		return super.insert(vo);
	}

	public int insert2(final TestCmm001VO vo) {
		log.debug("vo={}", vo);
		return super.insert(getMapperNamespace() + "insert2", vo);
	}

	@Override
	public TestCmm001VO select(final TestCmm001VO vo) {
		log.debug("vo={}", vo);
		return super.select(vo);
	}

	public TestCmm001VO select2(final TestCmm001VO vo) {
		log.debug("vo={}", vo);
		return super.selectOne(super.getMapperNamespace() + "select2", vo);
	}

	@Override
	public List<TestCmm001VO> selectList(TestCmm001VO vo) {
		return super.selectList(vo);
	}

	@Override
	public int selectListTotCnt(TestCmm001VO vo) {
		return super.selectListTotCnt(vo);
	}

	@Override
	public int update(TestCmm001VO vo) {
		return super.update(vo);
	}

	public int update2(final TestCmm001VO vo) {
		log.debug("vo={}", vo);
		return super.update(super.getMapperNamespace() + "update2", vo);
	}

	@Override
	public int delete(TestCmm001VO vo) {
		return super.delete(vo);
	}

	public int delete2(final TestCmm001VO vo) {
		log.debug("vo={}", vo);
		return super.update(super.getMapperNamespace() + "delete2", vo);
	}

	@Override
	public int merge(TestCmm001VO vo) {
		return super.merge(vo);
	}

	@Override
	public int multi(TestCmm001VO vo) {
		return super.multi(vo);
	}

}
