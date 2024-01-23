package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [셀레늄단위테스트]게시판관리 목록화면 페이징
 * 
 * @author 이백행
 * @since 2024-01-24
 *
 */
@NoArgsConstructor
@Slf4j
class b02_목록화면_페이징 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 현재_페이지_번호;

	@Test
	void 페이징() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		목록화면(sb);

		페이징버튼(sb);

		assert__확인(sb);

		if (log.isDebugEnabled()) {
			log.debug(sb.toString());
		}
	}

	private void 목록화면(final StringBuffer sb) {
		driver.get(GET_URL + "/cop/bbs/selectBBSMasterInfs.do");
		정지();

		sb.append(로그_번호++);
		sb.append(". ");
		sb.append("게시판");
		sb.append(" 목록 화면\n\n");
	}

	private void 페이징버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.cssSelector(".pagination li:nth-child(2)"));
		현재_페이지_번호 = element.getText();
		element.click();
		정지();

		sb.append(로그_번호++);
		sb.append(". 페이징 버튼\n");
		sb.append(SB_N_N);
	}

	private void assert__확인(final StringBuffer sb) {
//		final WebElement currentPageNoElement = driver.findElement(By.id("currentPageNo"));
		final WebElement currentPageNoElement = driver.findElement(By.cssSelector(".pagination li.current"));
		final String currentPageNoString = currentPageNoElement.getText();
		정지();

		sb.append(로그_번호++);
		sb.append(". 확인\n");

		sb.append("현재 페이지 번호=");
		sb.append(현재_페이지_번호);
		sb.append(", ");
		sb.append(currentPageNoString);
		sb.append(SB_N);

		assertEquals(현재_페이지_번호, currentPageNoString, "현재 페이지 번호");
	}

}
