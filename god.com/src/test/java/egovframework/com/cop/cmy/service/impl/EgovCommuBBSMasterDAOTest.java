package egovframework.com.cop.cmy.service.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

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
import egovframework.com.cop.bbs.service.BoardMasterVO;
import egovframework.com.cop.bbs.service.impl.EgovBBSMasterDAO;
import egovframework.com.test.EgovTestAbstractDAO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 커뮤니티 메인페이지 DAO 단위 테스트
 * 
 * @author 이백행
 *
 */

@ContextConfiguration(classes = { EgovTestAbstractDAO.class, EgovCommuBBSMasterDAOTest.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-Cmmnty.xml",

        "classpath*:egovframework/spring/com/idgn/context-idgn-bbs.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "egovframework.com.cop.cmy.service.impl",

                "egovframework.com.cop.bbs.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                EgovCommuBBSMasterDAO.class,

                                EgovCommuBBSMasterServiceImpl.class,

                                EgovBBSMasterDAO.class,

                        }

                )

        }

)

//@Commit

@NoArgsConstructor
@Slf4j
public class EgovCommuBBSMasterDAOTest extends EgovTestAbstractDAO {

    /**
     * EgovCommuBBSMasterDAO
     */
    @Autowired
    private EgovCommuBBSMasterDAO egovCommuBBSMasterDAO;

    /**
     * EgovBBSMasterDAO
     */
    @Autowired
    private EgovBBSMasterDAO egovBBSMasterDAO;

    /**
     * egovBBSMstrIdGnrService
     */
    @Autowired
    @Qualifier("egovBBSMstrIdGnrService")
    private EgovIdGnrService egovBBSMstrIdGnrService;

    /**
     * egovCmmntyIdGnrService
     */
    @Autowired
    @Qualifier("egovCmmntyIdGnrService")
    private EgovIdGnrService egovCmmntyIdGnrService;

    private void testData(final BoardMasterVO testData) {
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        if (loginVO != null) {
            testData.setFrstRegisterId(loginVO.getUniqId());
            testData.setLastUpdusrId(loginVO.getUniqId());
        }

        try {
            testData.setBbsId(egovBBSMstrIdGnrService.getNextStringId());
            testData.setCmmntyId(egovCmmntyIdGnrService.getNextStringId());
        } catch (FdlException e) {
            log.error("FdlException egovBBSMstrIdGnrService");
        }

        testData.setBbsTyCode("BBST02"); // 블로그형게시판 COM101
        testData.setBbsNm("test 이백행 게시판마스터 " + LocalDateTime.now());

        testData.setUseAt("Y");

        egovBBSMasterDAO.insertBBSMasterInf(testData);
    }

    /**
     * 조회(멀티건)
     */
    @Test
    public void selectCommuBBSMasterListMain() {
        // given
        final BoardMasterVO testData = new BoardMasterVO();
        testData(testData);

        final BoardMasterVO boardMasterVO = new BoardMasterVO();
        boardMasterVO.setCmmntyId(testData.getCmmntyId());

        // when
        final List<BoardMasterVO> resultList = egovCommuBBSMasterDAO.selectCommuBBSMasterListMain(boardMasterVO);
        for (final BoardMasterVO result : resultList) {
            debug(result);

            // then
            assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getBbsId(), result.getBbsId());
            assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getBbsTyCode(),
                    result.getBbsTyCode());
            assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getBbsNm(), result.getBbsNm());
        }
    }

    private void debug(final BoardMasterVO result) {
        if (log.isDebugEnabled()) {
            log.debug("result={}", result);
            log.debug("getBbsId={}", result.getBbsId());
            log.debug("getBbsTyCode={}", result.getBbsTyCode());
            log.debug("getBbsNm={}", result.getBbsNm());
        }
    }

}
