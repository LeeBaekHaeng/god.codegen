package god.test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 단위 테스트
 * 
 * @author 이백행
 * @since 2024-01-13
 *
 */
@NoArgsConstructor
@Slf4j
public class 셀레늄_테스트 {

	/**
	 * 
	 */
//	public static final String GET_URL = "http://localhost:8080/com";
//	public static final String GET_URL = "http://127.0.0.1:8080/com";
	public static final String GET_URL = "http://localhost:8080/egovframework-all-in-one";

	/**
	 * 
	 */
	protected String 테스터 = "이백행";

	/**
	 * 현재 년월일시분초
	 */
	protected String 테스트_값_접미어 = LocalDateTime.now().toString();

	/**
	 * 
	 */
	protected int 로그_번호 = 1;

	/**
	 * 
	 */
	protected String SB_N = "\n";

	/**
	 * 
	 */
	protected String SB_N_N = "\n\n";

	/**
	 * WebDriver
	 */
	protected WebDriver driver;

	/**
	 * vars
	 */
	protected Map<String, Object> vars;

	/**
	 * JavascriptExecutor
	 */
	private JavascriptExecutor js;

	@BeforeAll
	static void setUpBeforeClass() {
		if (log.isTraceEnabled()) {
			log.trace("setUpBeforeClass @BeforeAll");
		}
	}

	@AfterAll
	static void tearDownAfterClass() {
		if (log.isTraceEnabled()) {
			log.trace("tearDownAfterClass @AfterAll");
		}
	}

	@BeforeEach
	void setUp() {
		if (log.isTraceEnabled()) {
			log.trace("setUp @BeforeEach");
		}

		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<>();
	}

	@AfterEach
	void tearDown() {
		if (log.isTraceEnabled()) {
			log.trace("tearDown @AfterEach");
		}

//		driver.quit();
	}

	/**
	 * 로그인
	 */
	protected void 로그인() {
		로그인("USER", "rhdxhd12");
	}

	/**
	 * 로그인
	 */
	protected void 로그인(final String 아이디) {
		로그인(아이디, "rhdxhd12");
	}

	/**
	 * 로그인
	 */
	protected void 로그인(final String 아이디, final String 패스워드) {
//		vars.put("id", "USER");// 아이디
		vars.put("id", 아이디);// 아이디

		vars.put("searchKeyword", "일반회원"); // 사용자명검색
//        vars.put("searchKeyword", "테스트1"); // 사용자명검색
//        vars.put("searchKeyword", "NIA"); // 사용자명검색
//        vars.put("searchKeyword", "웹마스터"); // 사용자명검색

		// URL
//		driver.get("http://localhost:8080/com/");
		driver.get(GET_URL + "/uat/uia/egovLoginUsr.do");
//		sleep3second();
		js.executeScript("location.reload()");

		final String title = driver.getTitle();
		if (log.isTraceEnabled()) {
			log.trace("title={}", title);
		}
//		assertEquals("에러가 발생했습니다!", "eGovFrame 공통 컴포넌트", title);
//		assertEquals("로그인", title, "title 로그인");

//		driver.switchTo().frame("_content");

		// 아이디
//        driver.findElement(By.id("id")).sendKeys("USER");
		driver.findElement(By.id("id")).sendKeys((String) vars.get("id"));
//		sleep();

		// 비밀번호
//		driver.findElement(By.id("password")).sendKeys("rhdxhd12");
		driver.findElement(By.id("password")).sendKeys(패스워드);
//		sleep();

		// 로그인 버튼
//		driver.findElement(By.cssSelector(".btn_login:nth-child(1)")).click();
		js.executeScript("actionLogin()");
	}

	/**
	 * 스레드 정지
	 * 
	 * @param millis
	 */
	protected void 정지(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
	}

	/**
	 * 1초 스레드 정지
	 */
	protected void 정지() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 1초 스레드 정지
	 */
	protected void 정지_1초() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep sleep1second", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 2초 스레드 정지
	 */
	protected void 정지_2초() {
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep sleep2second", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 3초 스레드 정지
	 */
	protected void 정지_3초() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep sleep3second", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 
	 * @param 테스트값
	 * @return
	 */
	protected String 테스트_값읽기(final String 테스트값) {
		return "test " + 테스터 + " " + 테스트값 + " " + 테스트_값_접미어;
	}

}
