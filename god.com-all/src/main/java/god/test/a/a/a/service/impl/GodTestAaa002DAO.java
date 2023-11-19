package god.test.a.a.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.core.cmm.service.impl.GodCoreCmmAbstractDAO;
import god.test.a.a.a.service.GodTestAaa002VO;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 * @since 2023-11-19
 */
@Repository
public class GodTestAaa002DAO extends GodCoreCmmAbstractDAO<GodTestAaa002VO, GodTestAaa002VO> {

    /**
     * 
     */
    public GodTestAaa002DAO() {
        super(GodTestAaa002DAO.class.getSimpleName());
    }

    /**
     * 
     * @param vo
     * @return
     */
    public int insert2(final GodTestAaa002VO vo) {
        return insert(getNamespace() + "insert2", vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public GodTestAaa002VO select2(final GodTestAaa002VO vo) {
        return super.select(vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public List<GodTestAaa002VO> select2List(final GodTestAaa002VO vo) {
        return super.selectList(vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public int update2(final GodTestAaa002VO vo) {
        return super.update(vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public int delete2(final GodTestAaa002VO vo) {
        return super.delete(vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public int merge2(final GodTestAaa002VO vo) {
        return super.merge(vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public int multi2(final GodTestAaa002VO vo) {
        return super.multi(vo);
    }

    /**
     * 
     * @param vo
     * @return
     */
    public int select2ListTotCnt(final GodTestAaa002VO vo) {
        return super.selectListTotCnt(vo);
    }

}
