package god.sample.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmAbstractDAO;
import god.sample.a.a.service.SampleAa01VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 * @since 2023-12-15
 */
@Repository
@NoArgsConstructor
@Slf4j
public class SampleAa01DAO extends GodCoreCmmAbstractDAO<SampleAa01VO, SampleAa01VO> {

	/**
	 * Debug VO
	 */
	public static final String DEBUG_VO = "vo={}";

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	public void postConstruct() {
		super.postConstruct(SampleAa01DAO.class.getSimpleName());
	}

	/**
	 * 행정코드 등록
	 * 
	 * @param vo
	 * @return result
	 */
	public int insert2(final SampleAa01VO vo) {
		return insert(super.getNamespace() + "insert2", vo);
	}

	/**
	 * 행정코드 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	public SampleAa01VO select2(final SampleAa01VO vo) {
		return selectOne(super.getNamespace() + "select2", vo);
	}

	/**
	 * 행정코드 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	public List<SampleAa01VO> select2List(final SampleAa01VO vo) {
		return selectList(super.getNamespace() + "select2List", vo);
	}

	/**
	 * 행정코드 수정
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int update(final SampleAa01VO vo) {
		if (log.isDebugEnabled()) {
			log.debug(DEBUG_VO, vo);
		}
		return super.update(vo);
	}

	/**
	 * 행정코드 수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int update2(final SampleAa01VO vo) {
		return insert(super.getNamespace() + "update2", vo);
	}

	/**
	 * 행정코드 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int delete(final SampleAa01VO vo) {
		if (log.isDebugEnabled()) {
			log.debug(DEBUG_VO, vo);
		}
		return super.delete(vo);
	}

	/**
	 * 행정코드 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int delete2(final SampleAa01VO vo) {
		return insert(super.getNamespace() + "delete2", vo);
	}

	/**
	 * 행정코드 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int merge(final SampleAa01VO vo) {
		if (log.isDebugEnabled()) {
			log.debug(DEBUG_VO, vo);
		}
		return super.merge(vo);
	}

	/**
	 * 행정코드 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int merge2(final SampleAa01VO vo) {
		return insert(super.getNamespace() + "merge2", vo);
	}

	/**
	 * 행정코드 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int multi(final SampleAa01VO vo) {
		if (log.isDebugEnabled()) {
			log.debug(DEBUG_VO, vo);
		}
		return super.multi(vo);
	}

	/**
	 * 행정코드 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int multi2(final SampleAa01VO vo) {
		return insert(super.getNamespace() + "multi2", vo);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return totCnt
	 */
	@Override
	public int selectListTotCnt(final SampleAa01VO vo) {
		if (log.isDebugEnabled()) {
			log.debug(DEBUG_VO, vo);
		}
		return super.selectListTotCnt(vo);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return result
	 */
	public int select2ListTotCnt(final SampleAa01VO vo) {
		return selectOne(super.getNamespace() + "select2ListTotCnt", vo);
	}

}
