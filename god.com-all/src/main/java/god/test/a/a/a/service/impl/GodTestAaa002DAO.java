package god.test.a.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmAbstractDAO;
import god.test.a.a.a.service.GodTestAaa002VO;
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
public class GodTestAaa002DAO extends GodCoreCmmAbstractDAO<GodTestAaa002VO, GodTestAaa002VO> {

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	protected void postConstruct() {
		super.postConstruct(GodTestAaa002DAO.class.getSimpleName());
	}

	@Override
	public int insert(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.insert(vo);
	}

	@Override
	public GodTestAaa002VO select(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.select(vo);
	}

	@Override
	public List<GodTestAaa002VO> selectList(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.selectList(vo);
	}

	@Override
	public int update(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.update(vo);
	}

	@Override
	public int delete(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.delete(vo);
	}

	@Override
	public int merge(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.merge(vo);
	}

	@Override
	public int multi(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.multi(vo);
	}

	@Override
	public int selectListTotCnt(final GodTestAaa002VO vo) {
		if (log.isDebugEnabled()) {
			log.debug("vo", vo);
		}
		return super.selectListTotCnt(vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int insert2(final GodTestAaa002VO vo) {
		return insert(super.getNamespace() + "insert2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public GodTestAaa002VO select2(final GodTestAaa002VO vo) {
		return selectOne(super.getNamespace() + "select2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public List<GodTestAaa002VO> select2List(final GodTestAaa002VO vo) {
		return selectList(super.getNamespace() + "select2List", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int update2(final GodTestAaa002VO vo) {
		return insert(super.getNamespace() + "update2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int delete2(final GodTestAaa002VO vo) {
		return insert(super.getNamespace() + "delete2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int merge2(final GodTestAaa002VO vo) {
		return insert(super.getNamespace() + "merge2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int multi2(final GodTestAaa002VO vo) {
		return insert(super.getNamespace() + "multi2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int select2ListTotCnt(final GodTestAaa002VO vo) {
		return selectOne(super.getNamespace() + "select2ListTotCnt", vo);
	}

}
