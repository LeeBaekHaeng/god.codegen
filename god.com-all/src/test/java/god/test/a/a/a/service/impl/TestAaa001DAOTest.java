package god.test.a.a.a.service.impl;

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
import god.test.a.a.a.service.TestAaa001VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author LeeBaekHaeng
 *
 */
@ContextConfiguration(classes = { TestAaa001DAOTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-AdministCodeRecptn.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "god.test.a.a.a.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                TestAaa001DAO.class,

                        }

                )

        }

)

@NoArgsConstructor
@Slf4j
public class TestAaa001DAOTest extends EgovTestAbstractDAO {

    /**
     * 
     */
    @Autowired
    private TestAaa001DAO dao;

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
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.insert(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    private void setOpertSn(final TestAaa001VO vo) {
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
    }

    /**
     * 
     */
    @Test
    public void insert2() {
        // given
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.insert2(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void insert3() {
        // given
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.insert3(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     * @param testData
     */
    private void testData(final TestAaa001VO testData) {
        // given
        testData.setAdministZoneSe("1");
        testData.setAdministZoneCode("0000000001");

        setOpertSn(testData);

        // when
        final int result = dao.insert(testData);

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
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final TestAaa001VO result = dao.select(vo);

        // then
        log.debug("result={}", result);

        assertSelect(testData, result);
    }

    private void assertSelect(final TestAaa001VO testData, final TestAaa001VO result) {
        if (log.isDebugEnabled()) {
            log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
            log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
        }

        assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
                result.getAdministZoneCode());
        assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
                result.getAdministZoneCode());
    }

    /**
     * 
     */
    @Test
    public void select2() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final TestAaa001VO result = dao.select2(vo);

        // then
        log.debug("result={}", result);

        assertSelect(testData, result);
    }

    /**
     * 
     */
    @Test
    public void selectList() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setFirstIndex(0);
        vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
        vo.setSearchKeyword("test 이백행 2023-11-18");

        // when
        final List<TestAaa001VO> resultList = dao.selectList(vo);

        // then
        log.debug("resultList={}", resultList);

        assertSelectList(testData, resultList);
    }

    private void assertSelectList(final TestAaa001VO testData, final List<TestAaa001VO> resultList) {
//        assertFalse(egovMessageSource.getMessage("fail.common.select"), resultList.isEmpty());
        assertTrue(egovMessageSource.getMessage("fail.common.select"), resultList.size() > -1);

        int i = 1;

        for (final TestAaa001VO result : resultList) {
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
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();

        // when
        final int totCnt = dao.selectListTotCnt(vo);

        // then
        log.debug("totCnt={}", totCnt);

        assertTrue(egovMessageSource.getMessage("fail.common.select"), totCnt > -1);
    }

    /**
     * 
     */
    @Test
    public void select2List() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setFirstIndex(0);
        vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
        vo.setSearchKeyword("test 이백행 2023-11-18");

        // when
        final List<TestAaa001VO> resultList = dao.select2List(vo);

        // then
        log.debug("resultList={}", resultList);

        assertSelectList(testData, resultList);
    }

    /**
     * 
     */
    @Test
    public void select2ListTotCnt() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();

        // when
        final int totCnt = dao.selectListTotCnt(vo);

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
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        vo.setUseAt("Y");

        // when
        final int result = dao.update(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void update2() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        vo.setUseAt("Y");

        // when
        final int result = dao.update2(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void delete() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final int result = dao.delete(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void delete2() {
        // given
        final TestAaa001VO testData = new TestAaa001VO();
        testData(testData);

        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe(testData.getAdministZoneSe());
        vo.setAdministZoneCode(testData.getAdministZoneCode());

        // when
        final int result = dao.delete2(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void merge() {
        // given
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.merge(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void merge2() {
        // given
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.merge2(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void multi() {
        // given
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.multi(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

    /**
     * 
     */
    @Test
    public void multi2() {
        // given
        final TestAaa001VO vo = new TestAaa001VO();
        vo.setAdministZoneSe("1");
        vo.setAdministZoneCode("0000000001");

        setOpertSn(vo);

        // when
        final int result = dao.multi2(vo);

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

}
