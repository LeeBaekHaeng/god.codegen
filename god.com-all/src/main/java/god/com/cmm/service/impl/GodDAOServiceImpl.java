package god.com.cmm.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import god.com.cmm.service.GodDAOService;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 이백행
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public class GodDAOServiceImpl<T, R> extends EgovAbstractMapper implements GodDAOService<T, R> {

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
    public GodDAOServiceImpl(final String mapperNamespace) {
        super();
        this.mapperNamespace = mapperNamespace;
    }

    public String getMapperNamespace() {
        return mapperNamespace;
    }

    @Override
    public int insert(final T vo) {
        return super.insert(getMapperNamespace() + ".insert", vo);
    }

    @Override
    public R select(final T vo) {
        return super.selectOne(getMapperNamespace() + ".select", vo);
    }

    @Override
    public List<R> selectList(T vo) {
        return super.selectList(getMapperNamespace() + ".selectList", vo);
    }

    @Override
    public int selectListTotCnt(T vo) {
        return super.selectOne(getMapperNamespace() + ".selectListTotCnt", vo);
    }

    @Override
    public int update(T vo) {
        return super.insert(getMapperNamespace() + ".update", vo);
    }

    @Override
    public int delete(T vo) {
        return super.insert(getMapperNamespace() + ".delete", vo);
    }

    @Override
    public int merge(T vo) {
        return super.insert(getMapperNamespace() + ".merge", vo);
    }

    @Override
    public int multi(T vo) {
        return super.insert(getMapperNamespace() + ".multi", vo);
    }

}
