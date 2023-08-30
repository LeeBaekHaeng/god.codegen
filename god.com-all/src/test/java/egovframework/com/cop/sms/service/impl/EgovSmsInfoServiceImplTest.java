package egovframework.com.cop.sms.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.sms.service.EgovSmsInfoService;
import egovframework.com.cop.sms.service.Sms;
import egovframework.com.test.EgovTestAbstractDAO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 댓글 DAO 단위 테스트
 * 
 * @author 이백행
 *
 */

@ContextConfiguration(classes = { EgovTestAbstractDAO.class, EgovSmsInfoServiceImplTest.class, })

@Configuration

@ImportResource({

        "classpath*:egovframework/spring/com/idgn/context-idgn-Sms.xml",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "egovframework.com.cop.sms.service.impl",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                                EgovSmsInfoServiceImpl.class,

                                SmsDAO.class,

                        }

                )

        }

)

@NoArgsConstructor
@Slf4j
public class EgovSmsInfoServiceImplTest extends EgovTestAbstractDAO {

    /**
     * 문자메시지를 위한 서비스 인터페이스 클래스
     */
    @Autowired
    private EgovSmsInfoService egovSmsInfoService;

    /**
     * 문자메시지를 전송(등록)한다.
     */
    @Test
    @Commit
    public void insertSmsInf() {
        // given
        final Sms sms = new Sms();
        final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        sms.setTrnsmitTelno("042-481-1241"); // 전송전화번호

        sms.setTrnsmitCn("test 이백행 전송내용 " + LocalDateTime.now()); // 전송내용

        // 수신전화번호
        String[] recptnTelno = { "010-3471-4915", "010-3471-4916" };
        sms.setRecptnTelno(recptnTelno);

        if (loginVO != null) {
            sms.setFrstRegisterId(loginVO.getUniqId());
        }

        // when
        int result = 1;
        try {
            egovSmsInfoService.insertSmsInf(sms);
        } catch (Exception e) {
            result = 0;
            fail("Exception insertSmsInf");
        }

        // then
        log.debug("result={}", result);

        assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
    }

}
