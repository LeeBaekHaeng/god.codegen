package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리.게시판;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [기능추가][셀레늄단위테스트]게시판 목록화면
 * 
 * @author 이백행
 * @since 2024-02-01
 *
 */
@NoArgsConstructor
@Slf4j
class 목록화면 extends 셀레늄_테스트 {

	@Test
	void 테스트() {
		테스터 = "이백행";

		if (log.isDebugEnabled()) {
			log.debug("테스터={}", 테스터);
		}

		로그인("USER");

		목록_화면이동();

		assert__확인();
	}

	private void 목록_화면이동() {
		driver.get(GET_URL + "/cop/bbs/selectArticleList.do?bbsId=BBSMSTR_000000000631jtlmrVtuCh");
		정지();
	}

	private void assert__확인() {
		final WebElement element = driver.findElement(By.cssSelector(".board h1"));
		final String text = element.getText();
		정지();

		assertEquals("게시글 목록 (test 이백행 게시판명 2024-01-18T08:04:57.204780200)", text, "타이틀");
	}

}
