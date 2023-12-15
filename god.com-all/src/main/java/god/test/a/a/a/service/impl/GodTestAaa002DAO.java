package god.test.a.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmAbstractDAO;
import god.test.a.a.a.service.TestAaa002VO;
import lombok.NoArgsConstructor;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 * @since 2023-11-19
 */
@Repository
@NoArgsConstructor
public class GodTestAaa002DAO extends GodCoreCmmAbstractDAO<TestAaa002VO, TestAaa002VO> {

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	protected void postConstruct() {
		super.postConstruct(GodTestAaa002DAO.class.getSimpleName());
	}

	/**
	 * 행정코드 등록
	 * 
	 * @param vo
	 * @return result
	 */
	public int insert3(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "insert3", vo);
	}

	/**
	 * 행정코드 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	public TestAaa002VO select3(final TestAaa002VO vo) {
		return selectOne(super.getNamespace() + "select3", vo);
	}

	/**
	 * 행정코드 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	public List<TestAaa002VO> select3List(final TestAaa002VO vo) {
		return selectList(super.getNamespace() + "select3List", vo);
	}

	/**
	 * 행정코드 전체건수
	 * 
	 * @param vo
	 * @return result
	 */
	public int select3ListTotCnt(final TestAaa002VO vo) {
		return selectOne(super.getNamespace() + "select3ListTotCnt", vo);
	}

	/**
	 * 행정코드 수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int update3(final TestAaa002VO vo) {
		return update(super.getNamespace() + "update3", vo);
	}

	/**
	 * 행정코드 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int delete3(final TestAaa002VO vo) {
		return delete(super.getNamespace() + "delete3", vo);
	}

	/**
	 * 행정코드 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int merge3(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "merge3", vo);
	}

	/**
	 * 행정코드 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int multi3(final TestAaa002VO vo) {
		return insert(super.getNamespace() + "multi3", vo);
	}

}
