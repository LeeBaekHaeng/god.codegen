package org.egovframe.rte.fdl.cmmn.exception;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cop.sms.service.impl.EgovSmsInfoServiceImplTest;
import egovframework.com.test.EgovTestAbstractDAO;
import lombok.extern.slf4j.Slf4j;

@ContextConfiguration(classes = { EgovTestAbstractDAO.class, EgovSmsInfoServiceImplTest.class, })

@Configuration

@ImportResource({

        "",

})

@ComponentScan(

        useDefaultFilters = false,

        basePackages = {

                "",

        },

        includeFilters = {

                @Filter(

                        type = FilterType.ASSIGNABLE_TYPE,

                        classes = {

                        }

                )

        }

)

@Slf4j
public class BaseRuntimeExceptionTest extends EgovTestAbstractDAO {

    @Autowired
    private EgovMessageSource egovMessageSource;

    @Test
    public void test() {
        log.debug("test 이백행 s");

        try {
            testa();
        } catch (BaseRuntimeException e) {
            log.error("BaseRuntimeException testa");
            log.error("getMessage={}", e.getMessage());
            log.error("getMessageKey={}", e.getMessageKey());
            log.debug("test={}", egovMessageSource.getMessage(e.getMessageKey()));
        } finally {
            log.debug("test 이백행 finally");
        }

        log.debug("test 이백행 e");
    }

    private void testa() {
//        throw new BaseRuntimeException("test");
        log.debug("testa={}", egovMessageSource.getMessage("fail.common.msg"));
        log.debug("testa={}", egovMessageSource.getMessageArgs("fail.common.sql", new Object[] { "0 영", "1 일" }));
        throw new BaseRuntimeException(egovMessageSource, "fail.common.msg");
//        throw new BaseRuntimeException(egovMessageSource, "fail.common.sql");
    }

}
