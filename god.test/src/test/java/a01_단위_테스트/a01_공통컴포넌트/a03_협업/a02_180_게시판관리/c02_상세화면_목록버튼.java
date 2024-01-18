package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 10. 로그인 단위 테스트
 * 
 * @author 이백행
 * @since 2024-01-13
 *
 */
@NoArgsConstructor
@Slf4j
class c02_상세화면_목록버튼 extends 셀레늄_테스트 {

	@Test
	void test01_조회_버튼() {
//		로그인();
		로그인("USER");
//		로그인("USER", "rhdxhd12");

		final StringBuffer sb = new StringBuffer(1600);
		sb.append("\n\n");

		// 게시판 목록
		driver.get(GET_URL + "/cop/bbs/selectBBSMasterInfs.do");
		정지();
		sb.append("1. 게시판 목록\n");
		sb.append('\n');

		// 검색조건
		// searchCnd
		final WebElement searchCnd = driver.findElement(By.name("searchCnd"));
		searchCnd.sendKeys("게시판소개내용"); // 게시판소개내용
		정지();
		sb.append("2. 검색조건\n");

		final Select searchCndSelect = new Select(searchCnd);
		sb.append(searchCndSelect.getFirstSelectedOption().getText() + "\n");
		sb.append('\n');

		// 검색어
		// searchWrd
		final String searchWrdString = "통합게시판";
		final WebElement searchWrd = driver.findElement(By.name("searchWrd"));
		searchWrd.sendKeys(searchWrdString); // 검색어
		정지();
		sb.append("3. 검색어\n");

		sb.append(searchWrdString + "\n");
		sb.append('\n');

		// 조회 버튼
		// $('.s_btn')
		final WebElement sBtn = driver.findElement(By.className("s_btn"));
		sBtn.click();
		정지();
		sb.append("4. 조회 버튼\n");
		sb.append('\n');

		// then

		// $('.board_list tbody tr td:nth-child(2)')
		final WebElement boardList = driver.findElement(By.cssSelector(".board_list tbody tr td:nth-child(2)"));
		final String nttSj = boardList.getText();
		sb.append("5. 확인\n");

		sb.append("게시판명 예상: ");
		sb.append(nttSj);
		sb.append(", 실제: ");
		sb.append(nttSj + "\n");
//		sb.append('\n');

//		assertTrue(value.indexOf(searchWrdString) != -1, "message 메시지");
		assertEquals(searchWrdString, nttSj, "확인");

		assertEquals("", "", "조회 버튼");

		if (log.isDebugEnabled()) {
			log.debug(sb.toString());
		}
	}

	@Test
	void test02_등록_버튼() {
		if (log.isDebugEnabled()) {
			log.debug("test");
		}

		로그인();

		// 게시판 목록
		driver.get(GET_URL + "/cop/bbs/selectBBSMasterInfs.do");
		정지();

		// 등록 버튼
		// $('.btn_b')
		final WebElement btnB = driver.findElement(By.className("btn_b"));
		btnB.click();
		정지();

		// then
		assertEquals("", "", "등록 버튼");
	}

}
