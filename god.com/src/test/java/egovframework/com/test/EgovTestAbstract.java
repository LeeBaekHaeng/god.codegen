package egovframework.com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import lombok.RequiredArgsConstructor;

/**
 * 테스트
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

@RequiredArgsConstructor

public class EgovTestAbstract {

    /**
     * Logger
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(EgovTestAbstract.class);

    /**
     * BeforeClass AfterClass
     */
    protected static final StopWatch STOP_WATCH = new StopWatch();

    /**
     * Before After
     */
    protected final StopWatch stopWatch = new StopWatch();

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
     * setUpBeforeClass
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        STOP_WATCH.start();

        LOGGER.debug("setUpBeforeClass start");
    }

    /**
     * tearDownAfterClass
     */
    @AfterClass
    public static void tearDownAfterClass() {
        STOP_WATCH.stop();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("tearDownAfterClass stop");

            LOGGER.debug("totalTimeMillis={}", STOP_WATCH.getTotalTimeMillis());
            LOGGER.debug("totalTimeSeconds={}", STOP_WATCH.getTotalTimeSeconds());
        }
    }

    /**
     * setUp
     */
    @Before
    public void setUp() {
        stopWatch.start();

        LOGGER.debug("setUp start");

        if (beanDefinitionNames == null) {
            beanDefinitionNames = context.getBeanDefinitionNames();
            for (final String beanDefinitionName : beanDefinitionNames) {
                LOGGER.debug("beanDefinitionName={}", beanDefinitionName);
            }
            LOGGER.debug("length={}", beanDefinitionNames.length);
        }
    }

    /**
     * tearDown
     */
    @After
    public void tearDown() {
        stopWatch.stop();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("tearDown stop");

            LOGGER.debug("totalTimeMillis={}", STOP_WATCH.getTotalTimeMillis());
            LOGGER.debug("totalTimeSeconds={}", STOP_WATCH.getTotalTimeSeconds());
        }
    }

}
