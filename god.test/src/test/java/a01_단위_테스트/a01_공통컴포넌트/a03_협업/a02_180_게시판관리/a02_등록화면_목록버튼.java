package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [셀레늄단위테스트]게시판관리 등록화면 목록버튼
 * 
 * @author 이백행
 * @since 2024-01-13
 *
 */
@NoArgsConstructor
@Slf4j
class a02_등록화면_목록버튼 extends 셀레늄_테스트 {

	@Test
	void 목록버튼() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		등록화면(sb);

		목록버튼(sb);

		assert__확인(sb);

		if (log.isDebugEnabled()) {
			log.debug(sb.toString());
		}
	}

	private void 등록화면(final StringBuffer sb) {
		driver.get(GET_URL + "/cop/bbs/insertBBSMasterView.do");
		정지();

		sb.append(로그_번호++);
		sb.append(". ");
		sb.append("게시판");
		sb.append(" 등록화면\n\n");
	}

	private void 목록버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("btn_s"));
//		final WebElement element = driver.findElement(By.cssSelector(".btn_s"));
		element.click();
		정지();

		sb.append(로그_번호++);
		sb.append(". 목록버튼\n");
		sb.append(SB_N_N);
	}

	private void assert__확인(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.cssSelector(".board_list tbody tr td:nth-child(2)"));
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판명\n");
		sb.append(element.getText());

		final List<WebElement> elements = driver.findElements(By.cssSelector(".board_list tbody tr"));
		정지();
		for (WebElement tr : elements) {
			sb.append(tr.getText());
			sb.append(SB_N_N);
		}

		assertEquals("", "", "등록화면 목록버튼");
	}

}
