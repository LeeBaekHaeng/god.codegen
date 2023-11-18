package god.test.cmm.service.impl;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodAbstractDAO;
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
public class GodTestCmm001DAO extends GodAbstractDAO<GodTestCmm001VO, GodTestCmm001VO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestCmm001DAO() {
        super();
        setMapperNamespace("GodTestCmm001DAO");
    }

    @Override
    public int insert(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
//        return insert(getMapperNamespace() + ".insert2", vo);
    }

    @Override
    public int insert2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.insert2(vo);
    }

    @Override
    public GodTestCmm001VO select(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.select(vo);
    }

    @Override
    public GodTestCmm001VO select2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
//        return super.select2(vo);
        return super.selectOne(getMapperNamespace() + ".select2", vo);
    }

}
