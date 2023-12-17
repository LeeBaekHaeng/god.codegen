package god.core.cmm.service.impl;

import java.util.List;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.core.cmm.service.GodCoreCmmV1DAO;
import lombok.NoArgsConstructor;

/**
 * data 처리관련(DAO 공통)
 * 
 * @author 이백행
 * @since 2023-12-15
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public abstract class AbstractGodCoreCmmV1DAO<T, R> extends EgovComAbstractDAO implements GodCoreCmmV1DAO<T, R> {

	/**
	 * 네임스페이스
	 */
	protected String namespace;

	/**
	 * 네임스페이스 값설정
	 * 
	 * @param namespace
	 */
	protected void postConstruct(final String namespace) {
		this.namespace = namespace + ".";
	}

	/**
	 * 네임스페이스 값설정. 포스트 구성.
	 */
	public abstract void postConstruct();

	@Override
	public int insert(final T vo) {
		return insert(namespace + "insert", vo);
	}

	@Override
	public int insert2(final T vo) {
		return insert(namespace + "insert2", vo);
	}

	@Override
	public R select(final T vo) {
		return selectOne(namespace + "select", vo);
	}

	@Override
	public R select2(final T vo) {
		return selectOne(namespace + "select2", vo);
	}

	@Override
	public List<R> selectList(final T vo) {
		return selectList(namespace + "selectList", vo);
	}

	@Override
	public int selectListTotCnt(final T vo) {
		return selectOne(namespace + "selectListTotCnt", vo);
	}

	@Override
	public List<R> select2List(final T vo) {
		return selectList(namespace + "select2List", vo);
	}

	@Override
	public int select2ListTotCnt(final T vo) {
		return selectOne(namespace + "select2ListTotCnt", vo);
	}

	@Override
	public int update(final T vo) {
		return update(namespace + "update", vo);
	}

	@Override
	public int update2(final T vo) {
		return update(namespace + "update2", vo);
	}

	@Override
	public int delete(final T vo) {
		return delete(namespace + "delete", vo);
	}

	@Override
	public int delete2(final T vo) {
		return delete(namespace + "delete2", vo);
	}

	@Override
	public int merge(final T vo) {
		return insert(namespace + "merge", vo);
	}

	@Override
	public int merge2(final T vo) {
		return insert(namespace + "merge2", vo);
	}

	@Override
	public int multi(final T vo) {
		return insert(namespace + "multi", vo);
	}

	@Override
	public int multi2(final T vo) {
		return insert(namespace + "multi2", vo);
	}

}
