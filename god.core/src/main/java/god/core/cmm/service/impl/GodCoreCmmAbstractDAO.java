package god.core.cmm.service.impl;

import java.util.List;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.core.cmm.service.GodCoreCmmDAO;
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
public class GodCoreCmmAbstractDAO<T, R> extends EgovComAbstractDAO implements GodCoreCmmDAO<T, R> {

	/**
	 * 네임스페이스
	 */
	private String namespace;

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
	protected String getNamespace() {
		return namespace;
	}

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int insert(final T vo) {
		return insert(namespace + "insert", vo);
	}

	/**
	 * 등록
	 * 
	 * @param vo
	 * @return result
	 */
	public int insert2(final T vo) {
		return insert(namespace + "insert2", vo);
	}

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public R select(final T vo) {
		return selectOne(namespace + "select", vo);
	}

	/**
	 * 조회(단건)
	 * 
	 * @param vo
	 * @return result
	 */
	public R select2(final T vo) {
		return selectOne(namespace + "select2", vo);
	}

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	@Override
	public List<R> selectList(final T vo) {
		return selectList(namespace + "selectList", vo);
	}

	/**
	 * 전체건수
	 * 
	 * @param vo
	 * @return totCnt
	 */
	public int selectListTotCnt(final T vo) {
		return selectOne(namespace + "selectListTotCnt", vo);
	}

	/**
	 * 조회(멀티건)
	 * 
	 * @param vo
	 * @return resultList
	 */
	public List<R> select2List(final T vo) {
		return selectList(namespace + "select2List", vo);
	}

	/**
	 * 전체건수
	 * 
	 * @param vo
	 * @return totCnt
	 */
	public int select2ListTotCnt(final T vo) {
		return selectOne(namespace + "select2ListTotCnt", vo);
	}

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int update(final T vo) {
		return update(namespace + "update", vo);
	}

	/**
	 * 수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int update2(final T vo) {
		return update(namespace + "update2", vo);
	}

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int delete(final T vo) {
		return delete(namespace + "delete", vo);
	}

	/**
	 * 삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int delete2(final T vo) {
		return delete(namespace + "delete2", vo);
	}

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int merge(final T vo) {
		return insert(namespace + "merge", vo);
	}

	/**
	 * 등록/수정
	 * 
	 * @param vo
	 * @return result
	 */
	public int merge2(final T vo) {
		return insert(namespace + "merge2", vo);
	}

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	@Override
	public int multi(final T vo) {
		return insert(namespace + "multi", vo);
	}

	/**
	 * 등록/수정/삭제
	 * 
	 * @param vo
	 * @return result
	 */
	public int multi2(final T vo) {
		return insert(namespace + "multi2", vo);
	}

}
