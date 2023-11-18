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
public class GodTestCmm002DAO extends GodAbstractDAO<GodTestCmm001VO, GodTestCmm001VO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestCmm002DAO() {
        super();
        setMapperNamespace("GodTestCmm002DAO");
    }

    @Override
    public int insert(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.insert(vo);
//        return insert("GodTestCmm001DAO.insert2", vo);
    }

    @Override
    public int insert2(final GodTestCmm001VO vo) {
        log.debug("vo={}", vo);
        return super.insert2(vo);
    }

    @Override
    public GodTestCmm001VO select(GodTestCmm001VO vo) {
        return super.select(vo);
    }

    @Override
    public GodTestCmm001VO select2(GodTestCmm001VO vo) {
        // TODO Auto-generated method stub
        return super.select2(vo);
    }

}
