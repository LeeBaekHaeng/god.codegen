package god.sample.b.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmV1AbstractDAO;
import god.sample.b.a.service.SampleBa02VO;

/**
 * 게시판 DAO
 * 
 * @author 이백행
 * @since 2023-12-21
 */
@Repository
public class SampleBa02DAO extends GodCoreCmmV1AbstractDAO<SampleBa02VO, SampleBa02VO> {

	/**
	 * 네임스페이스 값설정
	 */
	public SampleBa02DAO() {
		super();
		super.postConstruct(this.getClass().getSimpleName());
	}

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return
	 */
	public int insert3(final SampleBa02VO vo) {
		return insert(namespace + "insert3", vo);
	}

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return
	 */
	public SampleBa02VO select3(final SampleBa02VO vo) {
		return selectOne(namespace + "select3", vo);
	}

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return
	 */
	public List<SampleBa02VO> select3List(final SampleBa02VO vo) {
		return selectList(namespace + "select3List", vo);
	}

	/**
	 * 전체건수
	 * 
	 * @param vo
	 * @return
	 */
	public int select3ListTotCnt(final SampleBa02VO vo) {
		return selectOne(namespace + "select3ListTotCnt", vo);
	}

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return
	 */
	public int update3(final SampleBa02VO vo) {
		return update(namespace + "update3", vo);
	}

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return
	 */
	public int delete3(final SampleBa02VO vo) {
		return delete(namespace + "delete3", vo);
	}

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return
	 */
	public int merge3(final SampleBa02VO vo) {
		return insert(namespace + "merge3", vo);
	}

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return
	 */
	public int multi3(final SampleBa02VO vo) {
		return insert(namespace + "multi3", vo);
	}

}
