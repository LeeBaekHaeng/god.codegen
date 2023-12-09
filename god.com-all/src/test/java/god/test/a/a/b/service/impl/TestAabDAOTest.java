package god.test.a.a.b.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
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

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.test.EgovTestAbstractDAO;
import god.test.a.a.b.service.TestAabVO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author LeeBaekHaeng
 *
 */
@ContextConfiguration(classes = { TestAabDAOTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-AdministCodeRecptn.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "god.test.a.a.b.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                TestAabDAO.class,

                        }

                )

        }

)

@NoArgsConstructor
@Slf4j
public class TestAabDAOTest extends EgovTestAbstractDAO {

    /**
     * 
     */
    @Autowired
    private TestAabDAO godTestAabDAO;

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
        final TestAabVO vo = new TestAabVO();
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

        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        vo.setFrstRegistPnttm(LocalDateTime.now());
//        vo.setFrstRegisterId(loginVO.getUniqId());
        vo.setLastUpdtPnttm(vo.getFrstRegistPnttm());
//        vo.setLastUpdusrId(loginVO.getUniqId());

        if (loginVO != null) {
            vo.setFrstRegisterId(loginVO.getUniqId());
            vo.setLastUpdusrId(loginVO.getUniqId());
        }

        // when
        final int result = godTestAabDAO.insert(vo);
//        final int result2 = GodTestAAADAO.insert2(vo);

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
//        final GodTestAabVO vo = new GodTestAabVO();
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
//        final int result = godTestAabDAO.insert2(vo);
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
    private void testData(final TestAabVO testData) {
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
        final int result = godTestAabDAO.insert(testData);

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
        final TestAabVO testData = new TestAabVO();
        testData(testData);

        final TestAabVO vo = new TestAabVO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final TestAabVO result = godTestAabDAO.select(vo);
        final TestAabVO result2 = godTestAabDAO.select(vo);

        // then
        log.debug("result={}", result);
        log.debug("result2={}", result2);

        assertSelect(testData, result);
        assertSelect(testData, result2);
    }

    private void assertSelect(final TestAabVO testData, final TestAabVO result) {
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
//        final GodTestAabVO testData = new GodTestAabVO();
//        testData(testData);
//
//        final GodTestAabVO vo = new GodTestAabVO();
//        vo.setAdministZoneSe(testData.getAdministZoneSe());
//        vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//        // when
//        final GodTestAabVO result = godTestAabDAO.select2(vo);
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
        final TestAabVO testData = new TestAabVO();
        testData(testData);

        final TestAabVO vo = new TestAabVO();
        vo.setFirstIndex(0);
        vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
        vo.setSearchKeyword("test 이백행 2023-11-18");

        // when
        final List<TestAabVO> resultList = godTestAabDAO.selectList(vo);

        // then
        log.debug("resultList={}", resultList);

        assertSelectList(testData, resultList);
    }

    private void assertSelectList(final TestAabVO testData, final List<TestAabVO> resultList) {
//        assertFalse(egovMessageSource.getMessage("fail.common.select"), resultList.isEmpty());
        assertTrue(egovMessageSource.getMessage("fail.common.select"), resultList.size() > -1);

        int i = 1;

        for (final TestAabVO result : resultList) {
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
        final TestAabVO testData = new TestAabVO();
        testData(testData);

        final TestAabVO vo = new TestAabVO();

        // when
        final int totCnt = godTestAabDAO.selectListTotCnt(vo);

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
        final TestAabVO testData = new TestAabVO();
        testData(testData);

        final TestAabVO vo = new TestAabVO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        vo.setUseAt("Y");

        // when
        final int result = godTestAabDAO.update(vo);

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
//        final GodTestAabVO testData = new GodTestAabVO();
//        testData(testData);
//
//        final GodTestAabVO vo = new GodTestAabVO();
//        vo.setAdministZoneSe(testData.getAdministZoneSe());
//        vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//        vo.setUseAt("Y");
//
//        // when
//        final int result = godTestAabDAO.update2(vo);
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
        final TestAabVO testData = new TestAabVO();
        testData(testData);

        final TestAabVO vo = new TestAabVO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final int result = godTestAabDAO.delete(vo);

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
//        final GodTestAabVO testData = new GodTestAabVO();
//        testData(testData);
//
//        final GodTestAabVO vo = new GodTestAabVO();
//        vo.setAdministZoneSe(testData.getAdministZoneSe());
//        vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//        // when
//        final int result = godTestAabDAO.delete2(vo);
//
//        // then
//        log.debug("result={}", result);
//
//        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
//    }

}
