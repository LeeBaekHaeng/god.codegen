package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리.게시판;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [기능추가][셀레늄단위테스트]게시판 목록화면 등록버튼
 * 
 * @author 이백행
 * @since 2024-02-14
 *
 */
@NoArgsConstructor
@Slf4j
class b02_목록화면_페이징_3등록자 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 페이지_예상;

	/**
	 * 
	 */
	private String 페이지_실제;

	/**
	 * 
	 */
	private String 검색어;

	/**
	 * 
	 */
	private String 검색조건;

	@Test
	void 테스트() {
		테스터 = "이백행";

		if (log.isDebugEnabled()) {
			log.debug("테스터={}", 테스터);
		}

		로그인("USER");

		목록화면으로_이동한다();
		검색조건을_선택한다();
		검색어를_입력한다();
		조회버튼을_클릭한다();
		페이지를_클릭한다();

		확인();
	}

	private void 목록화면으로_이동한다() {
		driver.get(GET_URL + "/cop/bbs/selectArticleList.do?bbsId=BBSMSTR_000000000631jtlmrVtuCh");
		정지();
	}

	private void 검색조건을_선택한다() {
		final WebElement element = driver.findElement(By.name("searchCnd"));
		검색조건 = "등록자";
		element.sendKeys(검색조건);
		정지();
	}

	private void 검색어를_입력한다() {
		final WebElement element = driver.findElement(By.name("searchWrd"));
		검색어 = "일반회원";
		element.sendKeys(검색어);
		정지();
	}

	private void 조회버튼을_클릭한다() {
		final WebElement element = driver.findElement(By.className("s_btn"));
		element.click();
		정지();
	}

	private void 페이지를_클릭한다() {
		final WebElement element = driver.findElement(By.cssSelector(".pagination li:nth-child(2)"));
		element.click();
		정지();
	}

	private void 확인() {
		final WebElement element = driver.findElement(By.cssSelector(".pagination li.current"));
		페이지_예상 = "2";
		페이지_실제 = element.getText();
		정지();

		if (log.isDebugEnabled()) {
			log.debug("페이지={}, {}", 페이지_예상, 페이지_실제);
		}

		assertEquals(페이지_예상, 페이지_실제, "페이지");
	}

}
