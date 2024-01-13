package god.test;

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
class EgovTestAbstractSelenium {

	/**
	 * 
	 */
//	public static final String GET_URL = "http://localhost:8080/com";
	public static final String GET_URL = "http://127.0.0.1:8080/com";

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
		if (log.isDebugEnabled()) {
			log.debug("setUpBeforeClass @BeforeAll");
		}
	}

	@AfterAll
	static void tearDownAfterClass() {
		if (log.isDebugEnabled()) {
			log.debug("tearDownAfterClass @AfterAll");
		}
	}

	@BeforeEach
	void setUp() {
		if (log.isDebugEnabled()) {
			log.debug("setUp @BeforeEach");
		}

		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<>();
	}

	@AfterEach
	void tearDown() {
		if (log.isDebugEnabled()) {
			log.debug("tearDown @AfterEach");
		}

//		driver.quit();
	}

	/**
	 * 로그인
	 */
	protected void login() {
		if (log.isDebugEnabled()) {
			log.debug("test");
		}

		vars.put("id", "USER");// 아이디

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
		log.debug("title={}", title);
//		assertEquals("에러가 발생했습니다!", "eGovFrame 공통 컴포넌트", title);
//		assertEquals("로그인", title, "title 로그인");

//		driver.switchTo().frame("_content");

		// 아이디
//        driver.findElement(By.id("id")).sendKeys("USER");
		driver.findElement(By.id("id")).sendKeys((String) vars.get("id"));
//		sleep();

		// 비밀번호
		driver.findElement(By.id("password")).sendKeys("rhdxhd12");
//		sleep();

		// 로그인 버튼
//		driver.findElement(By.cssSelector(".btn_login:nth-child(1)")).click();
		js.executeScript("actionLogin()");
	}

	/**
	 * 스레드 절전
	 * 
	 * @param millis
	 */
	protected void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
	}

	/**
	 * 1초 스레드 절전
	 */
	protected void sleep() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 1초 스레드 절전
	 */
	protected void sleep1second() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep sleep1second", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 2초 스레드 절전
	 */
	protected void sleep2second() {
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep sleep2second", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

	/**
	 * 3초 스레드 절전
	 */
	protected void sleep3second() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			throw new BaseRuntimeException("InterruptedException sleep sleep3second", e);
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
	}

}
