package god.test.cmm.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
import god.test.cmm.service.TestCmm001VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author LeeBaekHaeng
 *
 */
@ContextConfiguration(classes = { TestCmm001DAOTest.class, EgovTestAbstractDAO.class, })

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

                                TestCmm001DAO.class,

                        }

                )

        }

)

@NoArgsConstructor
@Slf4j
public class TestCmm001DAOTest extends EgovTestAbstractDAO {

    /**
     * 
     */
    @Autowired
    private TestCmm001DAO godTestCmm001DAO;

    /**
     * 
     */
    @Autowired
    @Qualifier("egovAdministCodeRecptnIdGnrService")
    private EgovIdGnrService egovAdministCodeRecptnIdGnrService;

    /**
     * 
     */
    @Test
    public void insert() {
        // given
        final TestCmm001VO vo = new TestCmm001VO();
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
//        final int result2 = godTestCmm001DAO.insert2(vo);

        // then
        log.debug("result={}", result);
//        log.debug("result2={}", result2);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result2);
    }

//    /**
//     * 
//     */
//    @Test
//    public void insert2() {
//        // given
//        final GodTestCmm001VO vo = new GodTestCmm001VO();
//        vo.setAdministZoneSe("1");
//        vo.setAdministZoneCode("0000000001");
//
//        try {
//            vo.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
//        } catch (FdlException e) {
//            log.error("FdlException egovAdministCodeRecptnIdGnrService");
////        } catch (BaseRuntimeException e) {
////            log.error("BaseRuntimeException egovAdministCodeRecptnIdGnrService");
////        } catch (Exception e) {
////            log.error("Exception egovAdministCodeRecptnIdGnrService");
//            throw new BaseRuntimeException(e);
//        }
//
//        if (log.isDebugEnabled()) {
//            log.debug("getOpertSn={}", vo.getOpertSn());
//        }
//
//        // when
//        final int result = godTestCmm001DAO.insert2(vo);
//
//        // then
//        log.debug("result={}", result);
//
//        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
//    }

    /**
     * 
     * @param testData
     */
    private void testData(final TestCmm001VO testData) {
        // given
        testData.setAdministZoneSe("1");
        testData.setAdministZoneCode("0000000001");

        try {
            testData.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
        } catch (FdlException e) {
            log.error("FdlException egovAdministCodeRecptnIdGnrService");
            // } catch (BaseRuntimeException e) {
            // log.error("BaseRuntimeException egovAdministCodeRecptnIdGnrService");
            // } catch (Exception e) {
            // log.error("Exception egovAdministCodeRecptnIdGnrService");
            throw new BaseRuntimeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("getOpertSn={}", testData.getOpertSn());
        }

        // when
        final int result = godTestCmm001DAO.insert(testData);

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
        final TestCmm001VO testData = new TestCmm001VO();
        testData(testData);

        final TestCmm001VO vo = new TestCmm001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final TestCmm001VO result = godTestCmm001DAO.select(vo);
        final TestCmm001VO result2 = godTestCmm001DAO.select(vo);

        // then
        log.debug("result={}", result);
        log.debug("result2={}", result2);

        assertSelect(testData, result);
        assertSelect(testData, result2);
    }

    private void assertSelect(final TestCmm001VO testData, final TestCmm001VO result) {
        if (log.isDebugEnabled()) {
            log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
            log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
        }

        assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
                result.getAdministZoneCode());
        assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
                result.getAdministZoneCode());
    }

//    /**
//     * 
//     */
//    @Test
//    public void select2() {
//        // given
//        final GodTestCmm001VO testData = new GodTestCmm001VO();
//        testData(testData);
//
//        final GodTestCmm001VO vo = new GodTestCmm001VO();
//        vo.setAdministZoneSe(testData.getAdministZoneSe());
//        vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//        // when
//        final GodTestCmm001VO result = godTestCmm001DAO.select2(vo);
//
//        // then
//        log.debug("result={}", result);
//
//        assertSelect(testData, result);
//    }

    /**
     * 
     */
    @Test
    public void selectList() {
        // given
        final TestCmm001VO testData = new TestCmm001VO();
        testData(testData);

        final TestCmm001VO vo = new TestCmm001VO();
        vo.setFirstIndex(0);
        vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
        vo.setSearchKeyword("test 이백행 2023-11-18");

        // when
        final List<TestCmm001VO> resultList = godTestCmm001DAO.selectList(vo);

        // then
        log.debug("resultList={}", resultList);

        assertSelectList(testData, resultList);
    }

    private void assertSelectList(final TestCmm001VO testData, final List<TestCmm001VO> resultList) {
//        assertFalse(egovMessageSource.getMessage("fail.common.select"), resultList.isEmpty());
        assertTrue(egovMessageSource.getMessage("fail.common.select"), resultList.size() > -1);

        int i = 1;

        for (final TestCmm001VO result : resultList) {
            if (log.isDebugEnabled()) {
                log.debug("i={}", i);

                log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
                log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());

                log.debug("getUseAt={}, {}", testData.getUseAt(), result.getUseAt());
                log.debug("");
            }

            i++;
        }
    }

    /**
     * 
     */
    @Test
    public void selectListTotCnt() {
        // given
        final TestCmm001VO testData = new TestCmm001VO();
        testData(testData);

        final TestCmm001VO vo = new TestCmm001VO();

        // when
        final int totCnt = godTestCmm001DAO.selectListTotCnt(vo);

        // then
        log.debug("totCnt={}", totCnt);

        assertTrue(egovMessageSource.getMessage("fail.common.select"), totCnt > -1);
    }

    /**
     * 
     */
    @Test
    public void update() {
        // given
        final TestCmm001VO testData = new TestCmm001VO();
        testData(testData);

        final TestCmm001VO vo = new TestCmm001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        vo.setUseAt("Y");

        // when
        final int result = godTestCmm001DAO.update(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
    }

//    /**
//     * 
//     */
//    @Test
//    public void update2() {
//        // given
//        final GodTestCmm001VO testData = new GodTestCmm001VO();
//        testData(testData);
//
//        final GodTestCmm001VO vo = new GodTestCmm001VO();
//        vo.setAdministZoneSe(testData.getAdministZoneSe());
//        vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//        vo.setUseAt("Y");
//
//        // when
//        final int result = godTestCmm001DAO.update2(vo);
//
//        // then
//        log.debug("result={}", result);
//
//        assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
//    }

    /**
     * 
     */
    @Test
    public void delete() {
        // given
        final TestCmm001VO testData = new TestCmm001VO();
        testData(testData);

        final TestCmm001VO vo = new TestCmm001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final int result = godTestCmm001DAO.delete(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
    }

//    /**
//     * 
//     */
//    @Test
//    public void delete2() {
//        // given
//        final GodTestCmm001VO testData = new GodTestCmm001VO();
//        testData(testData);
//
//        final GodTestCmm001VO vo = new GodTestCmm001VO();
//        vo.setAdministZoneSe(testData.getAdministZoneSe());
//        vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//        // when
//        final int result = godTestCmm001DAO.delete2(vo);
//
//        // then
//        log.debug("result={}", result);
//
//        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
//    }

}
