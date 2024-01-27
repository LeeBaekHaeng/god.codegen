package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [셀레늄단위테스트]게시판관리 상세화면 수정버튼
 * 
 * @author 이백행
 * @since 2024-01-27
 *
 */
@NoArgsConstructor
@Slf4j
class c01_상세화면_수정버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 게시판명_예상_expected;

	/**
	 * 
	 */
	private String 등록자_예상_expected;

	/**
	 * 
	 */
	private String 등록일_예상_expected;

	/**
	 * 
	 */
	private String 사용여부_예상_expected;

	@Test
	void 수정버튼() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		목록화면(sb);
		상세화면(sb);

		assert__확인(sb);

		수정버튼(sb);

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

	private void 상세화면(final StringBuffer sb) {
		final WebElement 게시판명_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(2)"));
		게시판명_예상_expected = 게시판명_element.getText();

		final WebElement 등록자_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(3)"));
		등록자_예상_expected = 등록자_element.getText();

		final WebElement 등록일_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(4)"));
		등록일_예상_expected = 등록일_element.getText();

		final WebElement 사용여부_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(5)"));
		사용여부_예상_expected = 사용여부_element.getText();

		게시판명_element.click();

		sb.append(로그_번호++);
		sb.append(". ");
		sb.append("게시판");
		sb.append(" 상세 화면\n\n");

		sb.append("게시판명=");
		sb.append(게시판명_예상_expected);
		sb.append(SB_N);

		sb.append("등록자=");
		sb.append(등록자_예상_expected);
		sb.append(SB_N);

		sb.append("등록일=");
		sb.append(등록일_예상_expected);
		sb.append(SB_N);

		sb.append("사용여부=");
		sb.append(사용여부_예상_expected);
		sb.append(SB_N);
	}

	private void assert__확인(final StringBuffer sb) {
		final WebElement 게시판명_element = driver
				.findElement(By.cssSelector(".wTable tbody tr:nth-child(1) td:nth-child(2)"));
		final String 게시판명_실제_actual = 게시판명_element.getText();
		정지();

		final WebElement 등록자_element = driver
				.findElement(By.cssSelector(".wTable tbody tr:nth-child(2) td:nth-child(2)"));
		final String 등록자_실제_actual = 등록자_element.getText();
		정지();

		final WebElement 등록일_element = driver
				.findElement(By.cssSelector(".wTable tbody tr:nth-child(2) td:nth-child(4)"));
		final String 등록일_실제_actual = 등록일_element.getText();
		정지();

		final WebElement 사용여부_element = driver
				.findElement(By.cssSelector(".wTable tbody tr:nth-child(2) td:nth-child(6)"));
		final String 사용여부_실제_actual = 사용여부_element.getText();
		정지();

		sb.append(로그_번호++);
		sb.append(". 타이틀\n예상: ");
		sb.append(게시판명_예상_expected);
		sb.append(", 실제: ");
		sb.append(게시판명_실제_actual);
		sb.append(SB_N_N);

		sb.append(로그_번호++);
		sb.append(". 등록자\n예상: ");
		sb.append(등록자_예상_expected);
		sb.append(", 실제: ");
		sb.append(등록자_실제_actual);
		sb.append(SB_N_N);

		sb.append(로그_번호++);
		sb.append(". 등록일\n예상: ");
		sb.append(등록일_예상_expected);
		sb.append(", 실제: ");
		sb.append(등록일_실제_actual);
		sb.append(SB_N_N);

		sb.append(로그_번호++);
		sb.append(". 사용여부\n예상: ");
		sb.append(사용여부_예상_expected);
		sb.append(", 실제: ");
		sb.append(사용여부_실제_actual);
		sb.append(SB_N_N);

		assertTrue(게시판명_실제_actual.indexOf(게시판명_예상_expected) != -1, "게시판명");
		assertEquals(등록자_예상_expected, 등록자_실제_actual, "등록자");
		assertEquals(등록일_예상_expected, 등록일_실제_actual, "등록일");
		assertEquals(사용여부_예상_expected, 사용여부_실제_actual, "사용여부");
	}

	private void 수정버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("s_submit"));
		element.click();
		정지();

		final WebElement 타이틀_element = driver.findElement(By.cssSelector(".wTableFrm h2"));
		final String 타이틀_실제_actual = 타이틀_element.getText();
		정지();

		sb.append(로그_번호++);
		sb.append(". 수정 버튼\n");
		sb.append(SB_N_N);

		sb.append(로그_번호++);
		sb.append(". 타이틀_실제_actual\n");
		sb.append(타이틀_실제_actual);
		sb.append(SB_N_N);

		assertEquals("게시판 수정", 타이틀_실제_actual, "사용여부");
	}

}
