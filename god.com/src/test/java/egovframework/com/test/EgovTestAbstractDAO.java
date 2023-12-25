package egovframework.com.test;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import egovframework.com.cmm.EgovMessageSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * DAO 테스트
 * 
 * @author 이백행
 */

@RunWith(SpringJUnit4ClassRunner.class)
@OrderWith(Alphanumeric.class)

@ActiveProfiles({ "mysql", "dummy" })
//@ActiveProfiles({ "oracle", "dummy" })
//@ActiveProfiles({ "altibase", "dummy" })
//@ActiveProfiles({ "tibero", "dummy" })
//@ActiveProfiles({ "cubrid", "dummy" })
//@ActiveProfiles({ "maria", "dummy" })
//@ActiveProfiles({ "postgres", "dummy" })
//@ActiveProfiles({ "goldilocks", "dummy" })

@Transactional

@Configuration

@ImportResource({

//		"classpath*:egovframework/spring/com/**/context-*.xml",

        "classpath*:egovframework/spring/com/test-context-common.xml",

        "classpath*:egovframework/spring/com/context-crypto.xml",
        "classpath*:egovframework/spring/com/context-datasource.xml",
        "classpath*:egovframework/spring/com/context-egovuserdetailshelper.xml",
        "classpath*:egovframework/spring/com/context-mapper.xml",
        "classpath*:egovframework/spring/com/context-transaction.xml",

})

@RequiredArgsConstructor
@Slf4j

public class EgovTestAbstractDAO {

    /**
     * BeforeClass AfterClass
     */
    private static final StopWatch STOP_WATCH = new StopWatch();

    /**
     * Before After
     */
    private final StopWatch stopWatch = new StopWatch();

    /**
     * beanDefinitionNames
     */
    private static String[] beanDefinitionNames;

    /**
     * ApplicationContext
     */
    @Autowired
    private ApplicationContext context;

    /**
     * 메시지 리소스 사용을 위한 MessageSource 인터페이스 및 ReloadableResourceBundleMessageSource
     * 클래스의 구현체
     */
//    @Resource(name = "egovMessageSource")
//    @Autowired
//    @Qualifier("egovMessageSource")
    @Resource
    protected EgovMessageSource egovMessageSource;

    /**
     * 조회에 실패하였습니다.
     */
    protected static final String FAIL_COMMON_SELECT = "fail.common.select";

    /**
     * setUpBeforeClass
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        STOP_WATCH.start();

        log.debug("setUpBeforeClass start");
    }

    /**
     * tearDownAfterClass
     */
    @AfterClass
    public static void tearDownAfterClass() {
        STOP_WATCH.stop();

        if (log.isDebugEnabled()) {
            log.debug("tearDownAfterClass stop");

            log.debug("totalTimeMillis={}", STOP_WATCH.getTotalTimeMillis());
            log.debug("totalTimeSeconds={}", STOP_WATCH.getTotalTimeSeconds());
        }
    }

    /**
     * setUp
     */
    @Before
    public void setUp() {
        stopWatch.start();

        log.debug("setUp start");

        if (beanDefinitionNames == null) {
            beanDefinitionNames = context.getBeanDefinitionNames();
            for (final String beanDefinitionName : beanDefinitionNames) {
                log.debug("beanDefinitionName={}", beanDefinitionName);
            }
            log.debug("length={}", beanDefinitionNames.length);
        }
    }

    /**
     * tearDown
     */
    @After
    public void tearDown() {
        stopWatch.stop();

        if (log.isDebugEnabled()) {
            log.debug("tearDown stop");

            log.debug("totalTimeMillis={}", STOP_WATCH.getTotalTimeMillis());
            log.debug("totalTimeSeconds={}", STOP_WATCH.getTotalTimeSeconds());
        }
    }

    /**
     * error
     * 
     * @param e
     */
    protected void error(final DataAccessException e) {
        final SQLException sqlException = (SQLException) e.getCause();
        if (log.isErrorEnabled()) {
            log.error(egovMessageSource.getMessageArgs("fail.common.sql",
                    new Object[] { sqlException.getErrorCode(), sqlException.getMessage() }));
            log.error(egovMessageSource.getMessageArgs("fail.common.sql",
                    new Object[] { sqlException.getSQLState(), sqlException.getMessage() }));
        }
    }

}
