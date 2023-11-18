package god.test.cmm.service.impl;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodDAOServiceImpl;
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
public class GodTestCmm002DAO extends GodDAOServiceImpl<GodTestCmm001VO, GodTestCmm001VO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestCmm002DAO() {
        super("GodTestCmm002DAO");
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
    public GodTestCmm001VO select(GodTestCmm001VO vo) {
        return super.select(vo);
    }

    public GodTestCmm001VO select2(GodTestCmm001VO vo) {
        return super.selectOne(getMapperNamespace() + ".select2", vo);
    }

}
