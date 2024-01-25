package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [셀레늄단위테스트]게시판관리 목록화면 등록버튼
 * 
 * @author 이백행
 * @since 2024-01-26
 *
 */
@NoArgsConstructor
@Slf4j
class b03_목록화면_등록버튼 extends 셀레늄_테스트 {

	@Test
	void 등록버튼() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		목록화면(sb);

		등록버튼(sb);

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

	private void 등록버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("btn_b"));
		element.click();
		정지();

		sb.append(로그_번호++);
		sb.append(". 등록 버튼\n");
		sb.append(SB_N_N);
	}

	private void assert__확인(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.cssSelector(".wTableFrm h2"));
		final String text = element.getText();
		정지();

		final String expected = "게시판 등록";

		sb.append(로그_번호++);
		sb.append(". 타이틀\n예상: ");
		sb.append(expected);
		sb.append(", 실제: ");
		sb.append(text);
		sb.append(SB_N_N);

		assertEquals(expected, text, "에러가 발생했습니다!");
	}

}
