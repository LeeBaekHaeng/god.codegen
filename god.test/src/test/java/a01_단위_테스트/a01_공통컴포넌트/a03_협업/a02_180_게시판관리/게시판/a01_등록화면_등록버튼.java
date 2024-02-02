package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리.게시판;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [기능추가][셀레늄단위테스트]게시판 등록화면 등록버튼
 * 
 * @author 이백행
 * @since 2024-02-03
 *
 */
@NoArgsConstructor
@Slf4j
class a01_등록화면_등록버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 제목_예상_expected;

	/**
	 * 
	 */
	private String 내용_예상_expected;

	/**
	 * 
	 */
	private String 게시기간_게시시작일_예상_expected;

	/**
	 * 
	 */
	private String 게시기간_게시종료일_예상_expected;

	@Test
	void 테스트() {
		테스터 = "이백행";

		if (log.isDebugEnabled()) {
			log.debug("테스터={}", 테스터);
		}

		로그인("USER");

		목록화면으로_이동한다();

		목록화면에서_등록버튼을_클릭한다();

		등록화면에서_제목을_입력한다();
		등록화면에서_제목_진하게를_클릭한다();
//		등록화면에서_내용을_입력한다();
		등록화면에서_공지등록을_클릭한다();
		등록화면에서_비밀글을_클릭한다();
		등록화면에서_익명등록을_클릭한다();
		등록화면에서_게시기간을_입력한다();

//		assert__확인();
	}

	private void 목록화면으로_이동한다() {
		driver.get(GET_URL + "/cop/bbs/selectArticleList.do?bbsId=BBSMSTR_000000000631jtlmrVtuCh");
		정지();
	}

	private void 목록화면에서_등록버튼을_클릭한다() {
		final WebElement element = driver.findElement(By.className("btn_b"));
		element.click();
		정지();
	}

	private void 등록화면에서_제목을_입력한다() {
		제목_예상_expected = 테스트_값읽기("제목");
		final WebElement element = driver.findElement(By.id("nttSj"));
		element.sendKeys(제목_예상_expected);
		정지();
	}

	private void 등록화면에서_제목_진하게를_클릭한다() {
		final WebElement element = driver.findElement(By.id("sjBoldAt1"));
		element.click();
		정지();
	}

	private void 등록화면에서_내용을_입력한다() {
		내용_예상_expected = 테스트_값읽기("내용");
		final WebElement element = driver.findElement(By.id("nttCn"));
		element.sendKeys(내용_예상_expected);
		정지();
	}

	private void 등록화면에서_공지등록을_클릭한다() {
		final WebElement element = driver.findElement(By.id("noticeAt1"));
		element.click();
		정지();
	}

	private void 등록화면에서_비밀글을_클릭한다() {
		final WebElement element = driver.findElement(By.id("secretAt1"));
		element.click();
		정지();
	}

	private void 등록화면에서_익명등록을_클릭한다() {
		final WebElement element = driver.findElement(By.id("anonymousAt1"));
		element.click();
		정지();
	}

	private void 등록화면에서_게시기간을_입력한다() {
		게시기간_게시시작일_예상_expected = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		WebElement element = driver.findElement(By.id("ntceBgnde"));
		element.sendKeys(게시기간_게시시작일_예상_expected);
		정지();

		게시기간_게시종료일_예상_expected = LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ISO_LOCAL_DATE);
		element = driver.findElement(By.id("ntceEndde"));
		element.sendKeys(게시기간_게시종료일_예상_expected);
		정지();
	}

	private void assert__확인() {
		final WebElement element = driver.findElement(By.cssSelector(".board h1"));
		final String text = element.getText();
		정지();

		assertEquals("게시글 목록 (test 이백행 게시판명 2024-01-18T08:04:57.204780200)", text, "타이틀");
	}

}
