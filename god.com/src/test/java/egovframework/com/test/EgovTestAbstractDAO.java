package egovframework.com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import egovframework.com.cmm.EgovMessageSource;
import lombok.NoArgsConstructor;
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
		"classpath*:egovframework/spring/com/context-properties.xml",
		"classpath*:egovframework/spring/com/context-transaction.xml",

})

@NoArgsConstructor
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
//	@Autowired
	@Resource
	private ApplicationContext context;

	/**
	 * 메시지 리소스 사용을 위한 MessageSource 인터페이스 및 ReloadableResourceBundleMessageSource
	 * 클래스의 구현체
	 */
//    @Resource(name = "egovMessageSource")
//	@Autowired
//	@Qualifier("egovMessageSource")
	@Resource
	protected EgovMessageSource egovMessageSource;

	/**
	 * fail.common.insert = 생성이 실패하였습니다.
	 */
	public static final String FAIL_COMMON_INSERT = "fail.common.insert";
	/**
	 * fail.common.update = 수정이 실패하였습니다.
	 */
	public static final String FAIL_COMMON_UPDATE = "fail.common.update";

	/**
	 * fail.common.delete = 삭제가 실패하였습니다.
	 */
	public static final String FAIL_COMMON_DELETE = "fail.common.delete";

	/**
	 * fail.common.select = 조회에 실패하였습니다.
	 */
	public static final String FAIL_COMMON_SELECT = "fail.common.select";

	/**
	 * setUpBeforeClass
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		STOP_WATCH.start();

		if (log.isDebugEnabled()) {
			log.debug("setUpBeforeClass start");
		}
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

		if (log.isDebugEnabled()) {
			log.debug("setUp start");

			if (beanDefinitionNames == null) {
				beanDefinitionNames = context.getBeanDefinitionNames();
				for (final String beanDefinitionName : beanDefinitionNames) {
					log.debug("beanDefinitionName={}", beanDefinitionName);
				}
				log.debug("length={}", beanDefinitionNames.length);
			}
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

	/**
	 * Debug Result
	 * 
	 * @param result
	 */
	protected void debugResult(final int result) {
		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}
	}

	/**
	 * Debug TotCnt
	 * 
	 * @param totCnt
	 */
	protected void debugTotCnt(final int totCnt) {
		if (log.isDebugEnabled()) {
			log.debug("totCnt={}", totCnt);
		}
	}

	/**
	 * Debug PaginationInfo
	 * 
	 * @param paginationInfo
	 */
	protected void debugPaginationInfo(final PaginationInfo paginationInfo) {
		if (log.isDebugEnabled()) {
			log.debug("paginationInfo={}", paginationInfo);
			log.debug("");

			log.debug("getCurrentPageNo 현재 페이지 번호={}", paginationInfo.getCurrentPageNo());
			log.debug("getRecordCountPerPage 한 페이지당 게시되는 게시물 건 수={}", paginationInfo.getRecordCountPerPage());
			log.debug("getPageSize 페이지 리스트에 게시되는 페이지 건수={}", paginationInfo.getPageSize());
			log.debug("getTotalRecordCount 전체 게시물 건 수={}", paginationInfo.getTotalRecordCount());
			log.debug("");

			log.debug("getTotalPageCount 페이지 개수={}", paginationInfo.getTotalPageCount());
			log.debug("getFirstPageNoOnPageList 페이지 리스트의 첫 페이지 번호={}", paginationInfo.getFirstPageNoOnPageList());
			log.debug("getLastPageNoOnPageList 페이지 리스트의 마지막 페이지 번호={}", paginationInfo.getLastPageNoOnPageList());
			log.debug("getFirstRecordIndex 페이징 SQL의 조건절에 사용되는 시작 rownum={}", paginationInfo.getFirstRecordIndex());
			log.debug("getLastRecordIndex 페이징 SQL의 조건절에 사용되는 마지막 rownum={}", paginationInfo.getLastRecordIndex());
			log.debug("");
		}
	}

	/**
	 * assertEquals Insert
	 * 
	 * @param totCnt
	 */
	protected void assertEqualsInsert(final int result) {
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * assertEquals Update
	 * 
	 * @param totCnt
	 */
	protected void assertEqualsUpdate(final int result) {
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_UPDATE), 1, result);
	}

	/**
	 * assertEquals Delete
	 * 
	 * @param totCnt
	 */
	protected void assertEqualsDelete(final int result) {
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_DELETE), 1, result);
	}

	/**
	 * assertTrue ResultList Size
	 * 
	 * @param resultListSize
	 */
	protected void assertTrueResultListSize(final int resultListSize) {
		assertTrue(egovMessageSource.getMessage(FAIL_COMMON_SELECT), resultListSize > -1);
	}

	/**
	 * assertTrue TotCnt
	 * 
	 * @param totCnt
	 */
	protected void assertTrueTotCnt(final int totCnt) {
		assertTrue(egovMessageSource.getMessage(FAIL_COMMON_SELECT), totCnt > -1);
	}

}
