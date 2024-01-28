package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [셀레늄단위테스트]게시판관리 상세화면 목록버튼
 * 
 * @author 이백행
 * @since 2024-01-29
 *
 */
@NoArgsConstructor
@Slf4j
class c02_상세화면_목록버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 타이틀_예상_expected = "게시판 목록";

	@Test
	void 테스트() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		목록화면(sb);
		게시판명_클릭(sb);

		상세화면_목록버튼_클릭(sb);

		assert__확인_목록화면_타이틀(sb);

		if (log.isDebugEnabled()) {
			log.debug(sb.toString());
		}
	}

	private void 목록화면(final StringBuffer sb) {
		driver.get(GET_URL + "/cop/bbs/selectBBSMasterInfs.do");
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판 목록화면");
		sb.append(SB_N_N);
	}

	private void 게시판명_클릭(final StringBuffer sb) {
		final WebElement 게시판명_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(2)"));

		게시판명_element.click();

		sb.append(로그_번호++);
		sb.append(". 게시판명 클릭");
		sb.append(SB_N_N);
	}

	private void 상세화면_목록버튼_클릭(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("btn_s"));
		element.click();
		정지();

		sb.append(로그_번호++);
		sb.append(". 상세화면 목록버튼 클릭");
		sb.append(SB_N_N);
	}

	private void assert__확인_목록화면_타이틀(final StringBuffer sb) {
		final WebElement 타이틀_element = driver.findElement(By.cssSelector(".board h1"));
		final String 타이틀_실제_actual = 타이틀_element.getText();
		정지();

		sb.append(로그_번호++);
		sb.append(". 목록화면 타이틀\n예상: ");
		sb.append(타이틀_예상_expected);
		sb.append(", 실제: ");
		sb.append(타이틀_실제_actual);
		sb.append(SB_N_N);

		assertEquals(타이틀_예상_expected, 타이틀_실제_actual, "타이틀");
	}

}
