package god.test.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmmDAOImpl;
import god.test.cmm.service.GodTestCmm001VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class GodTestCmm001DAO extends GodComCmmDAOImpl<GodTestCmm001VO, GodTestCmm001VO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestCmm001DAO() {
        super("GodTestCmm001DAO");
    }

    @Override
    public int insert(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
    }

    public int insert2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.insert(getMapperNamespace() + ".insert2", vo);
    }

    @Override
    public GodTestCmm001VO select(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    public GodTestCmm001VO select2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.selectOne(super.getMapperNamespace() + ".select2", vo);
    }

    @Override
    public List<GodTestCmm001VO> selectList(GodTestCmm001VO vo) {
        return super.selectList(vo);
    }

    @Override
    public int selectListTotCnt(GodTestCmm001VO vo) {
        return super.selectListTotCnt(vo);
    }

    @Override
    public int update(GodTestCmm001VO vo) {
        return super.update(vo);
    }

    public int update2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + ".update2", vo);
    }

    @Override
    public int delete(GodTestCmm001VO vo) {
        return super.delete(vo);
    }

    public int delete2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.update(super.getMapperNamespace() + ".delete2", vo);
    }

    @Override
    public int merge(GodTestCmm001VO vo) {
        return super.merge(vo);
    }

    @Override
    public int multi(GodTestCmm001VO vo) {
        return super.multi(vo);
    }

}
