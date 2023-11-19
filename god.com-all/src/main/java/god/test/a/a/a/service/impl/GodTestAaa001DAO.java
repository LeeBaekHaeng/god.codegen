package god.test.a.a.a.service.impl;

import org.springframework.stereotype.Repository;

import god.com.cmm.service.impl.GodComCmm001DAOImpl;
import god.test.a.a.a.service.GodTestAaa001VO;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO
 * 
 * @author 이백행
 *
 */
@Repository
@Slf4j
public class GodTestAaa001DAO extends GodComCmm001DAOImpl<GodTestAaa001VO, GodTestAaa001VO> {

    /**
     * mapperNamespace 값설정
     */
    public GodTestAaa001DAO() {
        super("GodTestAaa001DAO");
        log.debug("getMapperNamespace={}", getMapperNamespace());
    }

}
