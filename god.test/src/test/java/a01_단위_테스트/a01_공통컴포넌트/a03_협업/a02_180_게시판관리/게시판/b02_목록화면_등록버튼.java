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
class b02_목록화면_등록버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 타이틀_예상;

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
		등록버튼을_클릭한다();

		확인();
	}

	private void 목록화면으로_이동한다() {
		driver.get(GET_URL + "/cop/bbs/selectArticleList.do?bbsId=BBSMSTR_000000000631jtlmrVtuCh");
		정지();
	}

	private void 등록버튼을_클릭한다() {
		final WebElement element = driver.findElement(By.className("btn_b"));
		element.click();
		정지();
	}

	private void 확인() {
		final WebElement element = driver.findElement(By.cssSelector(".wTableFrm h2"));
		타이틀_예상 = "게시글 등록";
		타이틀_실제 = element.getText();
		정지();

		assertEquals(타이틀_예상, 타이틀_실제, "타이틀");

		if (log.isDebugEnabled()) {
			log.debug("타이틀={}, {}", 타이틀_예상, 타이틀_실제);
		}
	}

}
