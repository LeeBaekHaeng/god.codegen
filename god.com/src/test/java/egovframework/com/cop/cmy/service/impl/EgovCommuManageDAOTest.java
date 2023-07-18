package egovframework.com.cop.cmy.service.impl;

import static org.junit.Assert.assertEquals;

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
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.bbs.service.impl.EgovBBSMasterDAO;
import egovframework.com.cop.cmy.service.Community;
import egovframework.com.cop.cmy.service.CommunityUser;
import egovframework.com.test.EgovTestAbstractDAO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 커뮤니티 사용자 및 승인정보 관리를 위한 DAO 단위 테스트
 * 
 * @author 이백행
 *
 */

@ContextConfiguration(classes = { EgovTestAbstractDAO.class, EgovCommuManageDAOTest.class, })

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

                                EgovCommuManageDAO.class,

                                EgovCommuManageServiceImpl.class,

                                EgovCommuMasterDAO.class,

                                EgovBBSMasterDAO.class,

                        }

                )

        }

)

//@Commit

@NoArgsConstructor
@Slf4j
public class EgovCommuManageDAOTest extends EgovTestAbstractDAO {

    /**
     * EgovCommuManageDAO
     */
    @Autowired
    private EgovCommuManageDAO egovCommuManageDAO;

    /**
     * EgovCommuMasterDAO
     */
    @Autowired
    private EgovCommuMasterDAO egovCommuMasterDAO;

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

    private void testData(final Community testData) {
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        if (loginVO != null) {
            testData.setFrstRegisterId(loginVO.getUniqId());
            testData.setLastUpdusrId(loginVO.getUniqId());
        }

        try {
//            testData.setBbsId(egovBBSMstrIdGnrService.getNextStringId());
            testData.setCmmntyId(egovCmmntyIdGnrService.getNextStringId());
        } catch (FdlException e) {
            log.error("FdlException egovBBSMstrIdGnrService");
        }

//        testData.setBbsTyCode("BBST02"); // 블로그형게시판 COM101
//        testData.setBbsNm("test 이백행 게시판마스터 " + LocalDateTime.now());
//
//        testData.setUseAt("Y");
//
//        egovBBSMasterDAO.insertBBSMasterInf(testData);

        egovCommuMasterDAO.insertCommuMaster(testData);
    }

    /**
     * 조회(단건)
     */
    @Test
    public void test_a10_selectSingleCommuUserDetail() {
        // given
//        final BoardMasterVO testData = new BoardMasterVO();
//        testData(testData);

        final CommunityUser cmmntyUser = new CommunityUser();

        // when
        final CommunityUser result = egovCommuManageDAO.selectSingleCommuUserDetail(cmmntyUser);

        // then
        assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), "", "");
    }

    /**
     * 조회(단건)
     */
    @Test
    public void test_a40_insertCommuUserRqst() {
        // given
        final Community testData = new Community();
        testData(testData);

        final CommunityUser cmmntyUser = new CommunityUser();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        cmmntyUser.setCmmntyId(testData.getCmmntyId());

        if (loginVO != null) {
            cmmntyUser.setEmplyrId(loginVO.getUniqId());
            cmmntyUser.setFrstRegisterId(loginVO.getUniqId());
            cmmntyUser.setLastUpdusrId(loginVO.getUniqId());
        }

        // when
        boolean insert = true;
        try {
            egovCommuManageDAO.insertCommuUserRqst(cmmntyUser);
        } catch (DataAccessException e) {
            insert = false;
            error(e);
        }

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, insert);
    }

}
