package god.core.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.core.cmm.service.GodCoreCmmDAOV1;
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
public class GodCoreCmmAbstractDAOV1<T, R> extends EgovComAbstractDAO implements GodCoreCmmDAOV1<T, R> {

	/**
	 * 네임스페이스
	 */
	private String namespace;

	/**
	 * egov.sqlSession
	 */
	@Override
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}

	@Override
	public void postConstruct(String namespace) {
		this.namespace = namespace + ".";
	}

	@Override
	public String getNamespace() {
		return namespace;
	}

	@Override
	public int insert(T vo) {
		return insert(namespace + "insert", vo);
	}

	@Override
	public R select(T vo) {
		return selectOne(namespace + "select", vo);
	}

	@Override
	public List<R> selectList(T vo) {
		return selectList(namespace + "selectList", vo);
	}

	@Override
	public int selectListTotCnt(T vo) {
		return selectOne(namespace + "selectListTotCnt", vo);
	}

	@Override
	public int update(T vo) {
		return update(namespace + "update", vo);
	}

	@Override
	public int delete(T vo) {
		return delete(namespace + "delete", vo);
	}

	@Override
	public int merge(T vo) {
		return insert(namespace + "merge", vo);
	}

	@Override
	public int multi(T vo) {
		return insert(namespace + "multi", vo);
	}

}
