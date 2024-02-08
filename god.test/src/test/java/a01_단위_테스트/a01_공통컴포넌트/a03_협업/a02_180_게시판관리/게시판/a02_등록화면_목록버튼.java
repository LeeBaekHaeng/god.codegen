package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리.게시판;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [기능추가][셀레늄단위테스트]게시판 등록화면 목록버튼
 * 
 * @author 이백행
 * @since 2024-02-09
 *
 */
@NoArgsConstructor
@Slf4j
class a02_등록화면_목록버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 타이틀_예상 = "게시글 목록";

	/**
	 * 
	 */
	private String 타이틀_실제;

	@Test
	void 테스트() {
		테스터 = "이백행";

		if (log.isDebugEnabled()) {
			log.debug("테스터={}", 테스터);
		}

		로그인("USER");

		목록화면으로_이동한다();

		목록화면에서_등록버튼을_클릭한다();

		등록화면에서_목록버튼을_클릭한다();

		확인();
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

	private void 등록화면에서_목록버튼을_클릭한다() {
		final WebElement element = driver.findElement(By.className("btn_s"));
		element.click();
		정지();
	}

	private void 확인() {
		final WebElement element = driver.findElement(By.cssSelector(".board h1"));
		타이틀_실제 = element.getText();
		정지();

		assertTrue(타이틀_실제.startsWith(타이틀_예상), "타이틀");
	}

}
