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
     * egovCmmntyIdGnrService
     */
    @Autowired
    @Qualifier("egovCmmntyIdGnrService")
    private EgovIdGnrService egovCmmntyIdGnrService;

    private void testData(final Community communityTestData) {
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        if (loginVO != null) {
            communityTestData.setFrstRegisterId(loginVO.getUniqId());
            communityTestData.setLastUpdusrId(loginVO.getUniqId());
        }

        try {
            communityTestData.setCmmntyId(egovCmmntyIdGnrService.getNextStringId());
        } catch (FdlException e) {
            log.error("FdlException egovCmmntyIdGnrService");
        }

        egovCommuMasterDAO.insertCommuMaster(communityTestData);
    }

    private void testData2(final CommunityUser testData) {
        final Community community = new Community();
        testData(community);

        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        testData.setCmmntyId(community.getCmmntyId());

        if (loginVO != null) {
            testData.setEmplyrId(loginVO.getUniqId());
            testData.setFrstRegisterId(loginVO.getUniqId());
            testData.setLastUpdusrId(loginVO.getUniqId());
        }

        testData.setMngrAt("Y");
        testData.setUseAt("Y");

        egovCommuManageDAO.insertCommuUserRqst(testData);
    }

    /**
     * 조회(단건)
     */
    @Test
    public void test_a10_selectSingleCommuUserDetail() {
        // given
        final CommunityUser testData = new CommunityUser();
        testData2(testData);

        final CommunityUser cmmntyUser = new CommunityUser();

        cmmntyUser.setEmplyrId(testData.getEmplyrId());
        cmmntyUser.setCmmntyId(testData.getCmmntyId());

        // when
        final CommunityUser result = egovCommuManageDAO.selectSingleCommuUserDetail(cmmntyUser);

        // then
        if (result != null) {
            assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getMberSttus(),
                    result.getMberSttus());
            assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getUseAt(), result.getUseAt());
        }
    }

    /**
     * 등록
     */
    @Test
    public void test_a40_insertCommuUserRqst() {
        // given
        final Community communityTestData = new Community();
        testData(communityTestData);

        final CommunityUser cmmntyUser = new CommunityUser();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        cmmntyUser.setCmmntyId(communityTestData.getCmmntyId());

        if (loginVO != null) {
            cmmntyUser.setEmplyrId(loginVO.getUniqId());
            cmmntyUser.setFrstRegisterId(loginVO.getUniqId());
            cmmntyUser.setLastUpdusrId(loginVO.getUniqId());
        }

        // when
        int result = 1;
        try {
            egovCommuManageDAO.insertCommuUserRqst(cmmntyUser);
        } catch (DataAccessException e) {
            result = 0;
            error(e);
        }

        // then
        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

}
