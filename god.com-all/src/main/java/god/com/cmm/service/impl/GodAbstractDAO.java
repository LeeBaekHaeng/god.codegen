package god.com.cmm.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.NoArgsConstructor;

/**
 * 
 * @author 이백행
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public abstract class GodAbstractDAO<T, R> extends EgovAbstractMapper {

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

    public String getMapperNamespace() {
        return mapperNamespace;
    }

    public void setMapperNamespace(final String mapperNamespace) {
        this.mapperNamespace = mapperNamespace;
    }

    /**
     * 등록
     * 
     * @param vo
     * @return
     */
    public int insert(final T vo) {
        return super.insert(mapperNamespace + ".insert", vo);
    }

    /**
     * 등록2
     * 
     * @param vo
     * @return
     */
    public int insert2(final T vo) {
        return super.insert(mapperNamespace + ".insert2", vo);
    }

    /**
     * 조회(단건)
     * 
     * @param vo
     * @return
     */
    public R select(final T vo) {
        return super.selectOne(mapperNamespace + ".select", vo);
    }

    /**
     * 조회(단건)2
     * 
     * @param vo
     * @return
     */
    public R select2(final T vo) {
        return super.selectOne(mapperNamespace + ".select2", vo);
    }

}
