package god.test.a.a.b.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.a.a.b.service.TestAab001VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class TestAab001DAO extends GodComCmmDAOImpl<TestAab001VO, TestAab001VO> {

	/**
	 * mapperNamespace 값설정
	 */
	public TestAab001DAO() {
		super(TestAab001DAO.class.getSimpleName());
	}

	@Override
	public int insert(final TestAab001VO vo) {
		log.debug("vo={}", vo);
		return super.insert(vo);
	}

	public int insert2(final TestAab001VO vo) {
		log.debug("vo={}", vo);
		return super.insert(getMapperNamespace() + "insert2", vo);
	}

	@Override
	public TestAab001VO select(final TestAab001VO vo) {
		log.debug("vo={}", vo);
		return super.select(vo);
	}

	public TestAab001VO select2(final TestAab001VO vo) {
		log.debug("vo={}", vo);
		return super.selectOne(super.getMapperNamespace() + "select2", vo);
	}

	@Override
	public List<TestAab001VO> selectList(TestAab001VO vo) {
		return super.selectList(vo);
	}

	@Override
	public int selectListTotCnt(TestAab001VO vo) {
		return super.selectListTotCnt(vo);
	}

	@Override
	public int update(TestAab001VO vo) {
		return super.update(vo);
	}

	public int update2(final TestAab001VO vo) {
		log.debug("vo={}", vo);
		return super.update(super.getMapperNamespace() + "update2", vo);
	}

	@Override
	public int delete(TestAab001VO vo) {
		return super.delete(vo);
	}

	public int delete2(final TestAab001VO vo) {
		log.debug("vo={}", vo);
		return super.update(super.getMapperNamespace() + "delete2", vo);
	}

	@Override
	public int merge(TestAab001VO vo) {
		return super.merge(vo);
	}

	@Override
	public int multi(TestAab001VO vo) {
		return super.multi(vo);
	}

}
