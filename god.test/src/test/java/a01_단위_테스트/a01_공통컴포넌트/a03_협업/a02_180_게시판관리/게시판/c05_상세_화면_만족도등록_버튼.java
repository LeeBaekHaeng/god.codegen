package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리.게시판;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [기능추가][셀레늄단위테스트]게시판 상세화면 만족도등록 버튼
 * 
 * @author 이백행
 * @since 2024-02-22
 *
 */
@NoArgsConstructor
@Slf4j
class c05_상세_화면_만족도등록_버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 만족도_예상;

	/**
	 * 
	 */
	private String 만족도_실제;

	@Test
	void 테스트() {
		테스터 = "이백행";

		if (log.isDebugEnabled()) {
			log.debug("테스터={}", 테스터);
		}

		로그인("USER");

		목록화면으로_이동한다();
		제목을_클릭한다();

		만족도를_클릭한다();
		만족도등록_버튼을_클릭한다();

		확인();
	}

	private void 목록화면으로_이동한다() {
		driver.get(GET_URL + "/cop/bbs/selectArticleList.do?bbsId=BBSMSTR_000000000631jtlmrVtuCh");
		정지();
	}

	private void 제목을_클릭한다() {
		final WebElement element = driver.findElement(By.cssSelector(".board_list tbody tr td:nth-child(2)"));
		element.click();
		정지();
	}

	private void 만족도를_클릭한다() {
		final List<WebElement> elements = driver.findElements(By.name("stsfdg"));
		for (WebElement element : elements) {
			if (log.isDebugEnabled()) {
				log.debug("element={}", element);
				log.debug("stsfdg 만족도={}", element.getAttribute("value"));
			}
		}
		final WebElement element = elements.get(0);
		element.click();
		만족도_예상 = 만족도_예상(element.getAttribute("value"));
		정지();
	}

	private void 만족도등록_버튼을_클릭한다() {
		final List<WebElement> elements = driver.findElements(By.cssSelector(".re_btn"));
		if (log.isDebugEnabled()) {
			log.debug("elements={}", elements);
			log.debug("elements.get(0).getText()={}", elements.get(0).getText());
		}
		elements.get(0).click();
		정지();

		driver.switchTo().alert().accept();
	}

	private void 확인() {
		final WebElement element = driver.findElement(By.cssSelector(".reply li:last-child p.txt span"));
//		만족도_예상 = "★★★★★";
		만족도_실제 = element.getText();
		정지();

		if (log.isDebugEnabled()) {
			log.debug("만족도={}, {}", 만족도_예상, 만족도_실제);
		}

		assertTrue(만족도_실제.startsWith(만족도_예상), "만족도");
	}

	private String 만족도_예상(String value) {
		if ("5".equals(value)) {
			return "★★★★★";
		} else if ("4".equals(value)) {
			return "★★★★☆";
		} else if ("3".equals(value)) {
			return "★★★☆☆";
		} else if ("2".equals(value)) {
			return "★★☆☆☆";
		} else if ("1".equals(value)) {
			return "★☆☆☆☆";
		} else {
			return null;
		}
	}

}
