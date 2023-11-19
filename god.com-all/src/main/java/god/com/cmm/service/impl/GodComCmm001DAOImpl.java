package god.com.cmm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import god.com.cmm.service.GodComCmm001DAO;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 이백행
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public class GodComCmm001DAOImpl<T, R> extends EgovAbstractMapper implements GodComCmm001DAO<T, R> {

    /**
     * 
     */
    private String mapperNamespace;

    @Override
    @Autowired
    @Qualifier("egov.sqlSession")
    public void setSqlSessionFactory(final SqlSessionFactory sqlSession) {
        super.setSqlSessionFactory(sqlSession);
    }

    /**
     * 
     * @param mapperNamespace
     */
    public GodComCmm001DAOImpl(final String mapperNamespace) {
        super();
        this.mapperNamespace = mapperNamespace + ".";
    }

    @Override
    public String getMapperNamespace() {
        return mapperNamespace;
    }

    @Override
    public int insert(final T vo) {
        return super.insert(getMapperNamespace() + "insert", vo);
    }

    @Override
    public int insert2(final T vo) {
        return super.insert(getMapperNamespace() + "insert2", vo);
    }

    @Override
    public R select(final T vo) {
        return super.selectOne(getMapperNamespace() + "select", vo);
    }

    @Override
    public R select2(final T vo) {
        return super.selectOne(getMapperNamespace() + "select2", vo);
    }

    @Override
    public List<R> selectList(final T vo) {
        return super.selectList(getMapperNamespace() + "selectList", vo);
    }

    @Override
    public int selectListTotCnt(final T vo) {
        return super.selectOne(getMapperNamespace() + "selectListTotCnt", vo);
    }

    @Override
    public List<R> select2List(final T vo) {
        return super.selectList(getMapperNamespace() + "select2List", vo);
    }

    @Override
    public int select2ListTotCnt(final T vo) {
        return super.selectOne(getMapperNamespace() + "selectListTotCnt", vo);
    }

    @Override
    public int update(final T vo) {
        return super.update(getMapperNamespace() + "update", vo);
    }

    @Override
    public int update2(final T vo) {
        return super.update(getMapperNamespace() + "update2", vo);
    }

    @Override
    public int delete(final T vo) {
        return super.delete(getMapperNamespace() + "delete", vo);
    }

    @Override
    public int delete2(final T vo) {
        return super.delete(getMapperNamespace() + "delete2", vo);
    }

    @Override
    public int merge(final T vo) {
        return super.insert(getMapperNamespace() + "merge", vo);
    }

    @Override
    public int merge2(final T vo) {
        return super.insert(getMapperNamespace() + "merge2", vo);
    }

    @Override
    public int multi(final T vo) {
        return super.insert(getMapperNamespace() + "multi", vo);
    }

    @Override
    public int multi2(final T vo) {
        return super.insert(getMapperNamespace() + "multi2", vo);
    }

}
