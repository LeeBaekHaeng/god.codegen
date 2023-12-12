package god.test.a.a.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.core.cmm.service.GodCoreCmmDAO;
import god.test.a.a.a.service.GodTestAaa003VO;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 * @since 2023-12-11
 *
 */
@Repository
public class GodTestAaa003DAO extends EgovComAbstractDAO implements GodCoreCmmDAO<GodTestAaa003VO, GodTestAaa003VO> {

//	@Override
	public void postConstruct(String namespace) {
	}

//	@Override
	public String getNamespace() {
		return null;
	}

	@Override
	public int insert(GodTestAaa003VO vo) {
		return insert("GodTestAaa003DAO.insert", vo);
	}

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return
	 */
	public int insert2(GodTestAaa003VO vo) {
		return insert("GodTestAaa003DAO.insert2", vo);
	}

	@Override
	public GodTestAaa003VO select(GodTestAaa003VO vo) {
		return selectOne("GodTestAaa003DAO.select", vo);
	}

	@Override
	public List<GodTestAaa003VO> selectList(GodTestAaa003VO vo) {
		return selectList("GodTestAaa003DAO.selectList", vo);
	}

	@Override
	public int update(GodTestAaa003VO vo) {
		return update("GodTestAaa003DAO.update", vo);
	}

	@Override
	public int delete(GodTestAaa003VO vo) {
		return delete("GodTestAaa003DAO.delete", vo);
	}

	@Override
	public int merge(GodTestAaa003VO vo) {
		return insert("GodTestAaa003DAO.merge", vo);
	}

	@Override
	public int multi(GodTestAaa003VO vo) {
		return insert("GodTestAaa003DAO.multi", vo);
	}

//	@Override
	public int selectListTotCnt(GodTestAaa003VO vo) {
		return selectOne("GodTestAaa003DAO.selectListTotCnt", vo);
	}

}
