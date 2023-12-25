package egovframework.com.cop.ems.service.impl;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.impl.FileManageDAO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.ems.service.EgovMultiPartEmail;
import egovframework.com.cop.ems.service.EgovSndngMailRegistService;
import egovframework.com.cop.ems.service.EgovSndngMailService;
import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.test.EgovTestAbstractDAO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 전자우편
 * 
 * 메일솔루션 연동 인터페이스
 * 
 * 발송메일등록, 발송요청XML파일 생성하는 비즈니스 구현 클래스 ServiceImpl 단위 테스트
 * 
 * @author 이백행
 * @since 2023-12-25
 *
 */

@ContextConfiguration(classes = { EgovSndngMailRegistServiceImplTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-MailMsg.xml",

        "classpath*:egovframework/spring/com/context-mail.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "egovframework.com.cop.ems.service.impl",

                "egovframework.com.cmm.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                EgovSndngMailRegistService.class,

                                SndngMailRegistDAO.class,

                                // EgovSndngMailService
                                EgovSndngMailService.class,

                                EgovMultiPartEmail.class,
                                // EgovSndngMailService

                                // EgovFileMngService
                                EgovFileMngService.class,

                                FileManageDAO.class,
                        // EgovFileMngService

                        }

                )

        }

)

@NoArgsConstructor
@Slf4j
public class EgovSndngMailRegistServiceImplTest extends EgovTestAbstractDAO {

    /**
     * 발송메일등록, 발송요청XML파일 생성하는 비즈니스 인터페이스 클래스
     */
    @Resource
    private EgovSndngMailRegistService egovSndngMailRegistService;

    /**
     * 발송할 메일을 등록한다 단위 테스트
     */
    @Test
    public void insertSndngMail() {
        // given
        final SndngMailVO vo = new SndngMailVO();

        // 받는사람
        vo.setRecptnPerson("dlqorgod@naver.com;bhlee@gsitm.com;");
//        vo.setRecptnPerson("dlqorgod@naver.com");
//        vo.setRecptnPerson("bhlee@gsitm.com");

        final LocalDateTime now = LocalDateTime.now();

        // 제목
        vo.setSj("test 이백행 제목 " + now);

        // 발신내용
        vo.setEmailCn("test 이백행 발신내용 " + now);

        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (loginVO != null) {
            vo.setDsptchPerson(loginVO.getId());
        }

        // when
        final boolean result = egovSndngMailRegistService.insertSndngMail(vo);

        // then
        if (log.isDebugEnabled()) {
            log.debug("result={}", result);
        }

        assertTrue(egovMessageSource.getMessage("fail.common.msg"), result);
    }

}
