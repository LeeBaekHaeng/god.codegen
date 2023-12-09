package god.test.a.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmAbstractDAO;
import god.test.a.a.a.service.TestAaa002VO;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 * @since 2023-11-19
 */
@Repository
public class TestAaa002DAO2 extends GodCoreCmmAbstractDAO<TestAaa002VO, TestAaa002VO> {

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	private void postConstruct() {
		super.postConstruct(TestAaa002DAO.class.getSimpleName());
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int insert2(final TestAaa002VO vo) {
		return insert(getNamespace() + "insert2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public TestAaa002VO select2(final TestAaa002VO vo) {
		return selectOne(getNamespace() + "select2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public List<TestAaa002VO> select2List(final TestAaa002VO vo) {
		return selectList(getNamespace() + "select2List", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int update2(final TestAaa002VO vo) {
		return insert(getNamespace() + "update2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int delete2(final TestAaa002VO vo) {
		return insert(getNamespace() + "delete2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int merge2(final TestAaa002VO vo) {
		return insert(getNamespace() + "merge2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int multi2(final TestAaa002VO vo) {
		return insert(getNamespace() + "multi2", vo);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public int select2ListTotCnt(final TestAaa002VO vo) {
		return selectOne(getNamespace() + "select2ListTotCnt", vo);
	}

}
