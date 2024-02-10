package a01_단위_테스트.a01_공통컴포넌트.a03_협업.a02_180_게시판관리.게시판;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import god.test.셀레늄_테스트;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [기능추가][셀레늄단위테스트]게시판 목록화면 조회버튼
 * 
 * @author 이백행
 * @since 2024-02-10
 *
 */
@NoArgsConstructor
@Slf4j
class b01_목록화면_조회버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 검색어;

	/**
	 * 
	 */
	private String 해당_데이터가_없습니다_예상;

	/**
	 * 
	 */
	private String 해당_데이터가_없습니다_실제;

	@Test
	void 테스트() {
		테스터 = "이백행";

		if (log.isDebugEnabled()) {
			log.debug("테스터={}", 테스터);
		}

		로그인("USER");

		목록화면으로_이동한다();
		검색어를_입력한다();
		조회버튼을_클릭한다();

//		등록화면에서_목록버튼을_클릭한다();

		확인();
	}

	private void 목록화면으로_이동한다() {
		driver.get(GET_URL + "/cop/bbs/selectArticleList.do?bbsId=BBSMSTR_000000000631jtlmrVtuCh");
		정지();
	}

	private void 검색어를_입력한다() {
		final WebElement element = driver.findElement(By.name("searchWrd"));
		검색어 = 테스트_값읽기("제목");
		element.sendKeys(검색어);
		정지();
	}

	private void 조회버튼을_클릭한다() {
		final WebElement element = driver.findElement(By.className("s_btn"));
		element.click();
		정지();
	}

	private void 확인() {
		final WebElement element = driver.findElement(By.cssSelector(".board_list tbody tr:last-child td"));
		해당_데이터가_없습니다_예상 = "자료가 없습니다. 다른 검색조건을 선택해주세요";
		해당_데이터가_없습니다_실제 = element.getText();
		정지();

		assertEquals(해당_데이터가_없습니다_예상, 해당_데이터가_없습니다_실제, "해당 데이터가 없습니다.");
	}

}
