package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [셀레늄단위테스트]게시판관리 목록화면 조회버튼
 * 
 * @author 이백행
 * @since 2024-01-22
 *
 */
@NoArgsConstructor
@Slf4j
class b01_목록화면_조회버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 검색조건;

	/**
	 * 
	 */
	private String 검색어;

	@Test
	void 조회버튼() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		목록화면(sb);

		검색조건__선택(sb);
		검색어__입력(sb);

		조회버튼(sb);

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

	private void 검색조건__선택(final StringBuffer sb) {
//		검색조건 = "게시판명";
		검색조건 = "게시판소개내용";

		final WebElement element = driver.findElement(By.name("searchCnd"));
		element.sendKeys(검색조건);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 검색조건\n");
		sb.append(검색조건);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 검색어__입력(final StringBuffer sb) {
		if ("게시판명".equals(검색조건)) {
			검색어 = "게시판명";
		} else if ("게시판소개내용".equals(검색조건)) {
			검색어 = "게시판소개내용";
		}

		final WebElement element = driver.findElement(By.name("searchWrd"));
		element.sendKeys(검색어);
		정지();

		sb.append(로그_번호++);
		sb.append(". 검색어\n");
		sb.append(검색어);
		sb.append(SB_N_N);
	}

	private void 조회버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("s_btn"));
		element.click();
		정지();

		sb.append(로그_번호++);
		sb.append(". 조회 버튼\n");
		sb.append(SB_N_N);
	}

	private void assert__확인(final StringBuffer sb) {
		final List<WebElement> elements = driver.findElements(By.cssSelector(".board_list tbody tr"));
		정지();
		for (final WebElement tr : elements) {
			sb.append(tr.getText());
			sb.append(SB_N);

			sb.append("번호=");
			sb.append(tr.findElement(By.cssSelector("td:nth-child(1)")).getText());
			sb.append(", 게시판명=");
			final String 게시판명 = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
			sb.append(게시판명);
			sb.append(", 등록자=");
			sb.append(tr.findElement(By.cssSelector("td:nth-child(3)")).getText());
			sb.append(", 등록일=");
			sb.append(tr.findElement(By.cssSelector("td:nth-child(4)")).getText());
			sb.append(", 사용여부=");
			sb.append(tr.findElement(By.cssSelector("td:nth-child(5)")).getText());
			sb.append(SB_N);

			if ("게시판명".equals(검색조건)) {
				final boolean condition = 게시판명.indexOf(this.검색어) != -1;
				sb.append("확인=");
				sb.append(condition);
				sb.append(SB_N_N);

				assertTrue(condition, "조회버튼");
			}
		}
	}

}
