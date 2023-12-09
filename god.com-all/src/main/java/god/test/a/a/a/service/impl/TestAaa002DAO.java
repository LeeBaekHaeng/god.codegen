package god.test.a.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmAbstractDAO;
import god.test.a.a.a.service.TestAaa002VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 * @since 2023-11-19
 */
@Repository
@NoArgsConstructor
@Slf4j
public class TestAaa002DAO extends GodCoreCmmAbstractDAO<TestAaa002VO, TestAaa002VO> {

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	protected void postConstruct() {
		super.postConstruct(TestAaa002DAO.class.getSimpleName());
	}

	/**
	 * 행정코드 등록
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int insert(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.insert(vo);
	}

	/**
	 * 행정코드 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public TestAaa002VO select(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.select(vo);
	}

	/**
	 * 행정코드 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	@Override
	public List<TestAaa002VO> selectList(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.selectList(vo);
	}

	/**
	 * 행정코드 수정
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int update(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.update(vo);
	}

	/**
	 * 행정코드 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int delete(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.delete(vo);
	}

	/**
	 * 행정코드 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int merge(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.merge(vo);
	}

	/**
	 * 행정코드 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int multi(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.multi(vo);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return totCnt
	 */
	@Override
	public int selectListTotCnt(final TestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.selectListTotCnt(vo);
	}

	/**
	 * 행정코드 등록
	 * 
	 * @param vo
	 * @return result
	 */
	public int insert2(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "insert2", vo);
	}

	/**
	 * 행정코드 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	public TestAaa002VO select2(final TestAaa002VO vo) {
		return selectOne(super.getNamespace() + "select2", vo);
	}

	/**
	 * 행정코드 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	public List<TestAaa002VO> select2List(final TestAaa002VO vo) {
		return selectList(super.getNamespace() + "select2List", vo);
	}

	/**
	 * 행정코드 수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int update2(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "update2", vo);
	}

	/**
	 * 행정코드 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int delete2(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "delete2", vo);
	}

	/**
	 * 행정코드 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int merge2(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "merge2", vo);
	}

	/**
	 * 행정코드 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int multi2(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "multi2", vo);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return result
	 */
	public int select2ListTotCnt(final TestAaa002VO vo) {
		return selectOne(super.getNamespace() + "select2ListTotCnt", vo);
	}

}
