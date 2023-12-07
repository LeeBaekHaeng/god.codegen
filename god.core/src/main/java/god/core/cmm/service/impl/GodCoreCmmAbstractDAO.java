package god.core.cmm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.NoArgsConstructor;

/**
 * data 처리관련(DAO 공통)
 * 
 * @author 이백행
 * @since 2023-11-19
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public abstract class GodCoreCmmAbstractDAO<T, R> extends EgovAbstractMapper {

	/**
	 * 네임스페이스
	 */
	private String namespace;

	/**
	 * egov.sqlSession
	 */
	@Autowired
	@Qualifier("egov.sqlSession")
	@Override
	public void setSqlSessionFactory(final SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}

	/**
	 * 네임스페이스 값설정
	 * 
	 * @param namespace
	 */
	protected void postConstruct(final String namespace) {
		this.namespace = namespace + ".";
	}

	/**
	 * 네임스페이스 값읽기
	 * 
	 * @return
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	public int insert(final T vo) {
		return insert(namespace + "insert", vo);
	}

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	public R select(final T vo) {
		return selectOne(namespace + "select", vo);
	}

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	public List<R> selectList(final T vo) {
		return selectList(namespace + "selectList", vo);
	}

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int update(final T vo) {
		return update(namespace + "update", vo);
	}

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int delete(final T vo) {
		return delete(namespace + "delete", vo);
	}

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int merge(final T vo) {
		return insert(namespace + "merge", vo);
	}

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int multi(final T vo) {
		return insert(namespace + "multi", vo);
	}

	/**
	 * 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return totCnt
	 */
	public int selectListTotCnt(final T vo) {
		return selectOne(namespace + "selectListTotCnt", vo);
	}

}
