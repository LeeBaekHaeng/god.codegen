package god.test.a.a.b.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.a.a.b.service.GodTestAab001VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class GodTestAab001DAO extends GodComCmmDAOImpl<GodTestAab001VO, GodTestAab001VO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestAab001DAO() {
        super("GodTestAab001DAO");
    }

    @Override
    public int insert(final GodTestAab001VO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
    }

    public int insert2(final GodTestAab001VO vo) {
        log.debug("vo={}", vo);
        return super.insert(getMapperNamespace() + "insert2", vo);
    }

    @Override
    public GodTestAab001VO select(final GodTestAab001VO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    public GodTestAab001VO select2(final GodTestAab001VO vo) {
        log.debug("vo={}", vo);
        return super.selectOne(super.getMapperNamespace() + "select2", vo);
    }

    @Override
    public List<GodTestAab001VO> selectList(GodTestAab001VO vo) {
        return super.selectList(vo);
    }

    @Override
    public int selectListTotCnt(GodTestAab001VO vo) {
        return super.selectListTotCnt(vo);
    }

    @Override
    public int update(GodTestAab001VO vo) {
        return super.update(vo);
    }

    public int update2(final GodTestAab001VO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "update2", vo);
    }

    @Override
    public int delete(GodTestAab001VO vo) {
        return super.delete(vo);
    }

    public int delete2(final GodTestAab001VO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + "delete2", vo);
    }

    @Override
    public int merge(GodTestAab001VO vo) {
        return super.merge(vo);
    }

    @Override
    public int multi(GodTestAab001VO vo) {
        return super.multi(vo);
    }

}
