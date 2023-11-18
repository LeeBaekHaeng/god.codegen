package god.test.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.test.EgovTestAbstractDAO;
import god.test.cmm.service.GodTestCmm001VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author LeeBaekHaeng
 *
 */
@ContextConfiguration(classes = { GodTestCmm001DAOTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-AdministCodeRecptn.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "god.test.cmm.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                GodTestCmm001DAO.class,

                                GodTestCmm002DAO.class,

                        }

                )

        }

)

@NoArgsConstructor
@Slf4j
public class GodTestCmm001DAOTest extends EgovTestAbstractDAO {

    /**
     * 
     */
    @Autowired
    private GodTestCmm001DAO godTestCmm001DAO;

    /**
     * 
     */
    @Autowired
    private GodTestCmm002DAO godTestCmm002DAO;

    /**
     * 
     */
    @Autowired
    @Qualifier("egovAdministCodeRecptnIdGnrService")
    private EgovIdGnrService egovAdministCodeRecptnIdGnrService;

    /**
     * 
     * @param testDataGodTestCmm001VO
     */
    private void testDataGodTestCmm001VO(final GodTestCmm001VO testDataGodTestCmm001VO) {
        // given
        testDataGodTestCmm001VO.setAdministZoneSe("1");
        testDataGodTestCmm001VO.setAdministZoneCode("0000000001");

        try {
            testDataGodTestCmm001VO.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
        } catch (FdlException e) {
            log.error("FdlException egovAdministCodeRecptnIdGnrService");
//        } catch (BaseRuntimeException e) {
//            log.error("BaseRuntimeException egovAdministCodeRecptnIdGnrService");
//        } catch (Exception e) {
//            log.error("Exception egovAdministCodeRecptnIdGnrService");
            throw new BaseRuntimeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("getOpertSn={}", testDataGodTestCmm001VO.getOpertSn());
        }

        // when
        final int result = godTestCmm001DAO.insert(testDataGodTestCmm001VO);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void insert() {
        // given
        final GodTestCmm001VO vo = new GodTestCmm001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        try {
            vo.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
        } catch (FdlException e) {
            log.error("FdlException egovAdministCodeRecptnIdGnrService");
//        } catch (BaseRuntimeException e) {
//            log.error("BaseRuntimeException egovAdministCodeRecptnIdGnrService");
//        } catch (Exception e) {
//            log.error("Exception egovAdministCodeRecptnIdGnrService");
            throw new BaseRuntimeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("getOpertSn={}", vo.getOpertSn());
        }

        // when
        final int result = godTestCmm001DAO.insert(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void select() {
        // given
        final GodTestCmm001VO testDataGodTestCmm001VO = new GodTestCmm001VO();
        testDataGodTestCmm001VO(testDataGodTestCmm001VO);

        final GodTestCmm001VO vo = new GodTestCmm001VO();
        vo.setAdministZoneSe(testDataGodTestCmm001VO.getAdministZoneSe());
        vo.setAdministZoneCode(testDataGodTestCmm001VO.getAdministZoneCode());

        // when
        final GodTestCmm001VO result = godTestCmm001DAO.select(vo);

        // then
        log.debug("result={}", result);

        assertSelect(vo, result);
    }

    private void assertSelect(final GodTestCmm001VO vo, final GodTestCmm001VO result) {
        if (log.isDebugEnabled()) {
            log.debug("getAdministZoneSe={}, {}", vo.getAdministZoneSe(), result.getAdministZoneSe());
            log.debug("getAdministZoneCode={}, {}", vo.getAdministZoneCode(), result.getAdministZoneCode());
        }

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), vo.getAdministZoneCode(),
                result.getAdministZoneCode());
        assertEquals(egovMessageSource.getMessage("fail.common.insert"), vo.getAdministZoneCode(),
                result.getAdministZoneCode());
    }

    /**
     * 
     */
    @Test
    public void select2() {
        // given
        final GodTestCmm001VO testDataGodTestCmm001VO = new GodTestCmm001VO();
        testDataGodTestCmm001VO(testDataGodTestCmm001VO);

        final GodTestCmm001VO vo = new GodTestCmm001VO();
        vo.setAdministZoneSe(testDataGodTestCmm001VO.getAdministZoneSe());
        vo.setAdministZoneCode(testDataGodTestCmm001VO.getAdministZoneCode());

        // when
        final GodTestCmm001VO result = godTestCmm001DAO.select2(vo);
        final GodTestCmm001VO result2 = godTestCmm002DAO.select2(vo);

        // then
        log.debug("result={}", result);
        log.debug("result2={}", result2);

        assertSelect(vo, result);
        assertSelect(vo, result2);
    }

}
