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
 * [셀레늄단위테스트]게시판관리 수정화면 수정버튼
 * 
 * @author 이백행
 * @since 2024-01-30
 *
 */
@NoArgsConstructor
@Slf4j
class d01_수정화면_수정버튼 extends 셀레늄_테스트 {

	/**
	 * 
	 */
	private String 게시판명;

	/**
	 * 
	 */
	private String 게시판소개내용;

	/**
	 * 
	 */
	private String 게시판_유형;

	/**
	 * 
	 */
	private String 파일첨부가능여부;

	/**
	 * 
	 */
	private String 첨부가능파일숫자;

	/**
	 * 
	 */
	private String 사용여부;

	@Test
	void 테스트() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "이백행";

		로그인("USER");

		목록화면(sb);
		게시판명_클릭(sb);

		상세화면_수정버튼_클릭(sb);

		게시판명__입력(sb);
		게시판소개내용__입력(sb);
		게시판_유형__선택(sb);
		파일첨부가능여부__선택(sb);
		첨부가능파일숫자__선택(sb);
		사용여부__선택(sb);

		수정버튼(sb);

		목록화면(sb);

		assert__확인(sb);

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

	private void 상세화면_수정버튼_클릭(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("s_submit"));
		element.click();
		정지();

		sb.append(로그_번호++);
		sb.append(". 상세화면 수정버튼 클릭");
		sb.append(SB_N_N);
	}

	private void 게시판명__입력(final StringBuffer sb) {
		게시판명 = 테스트_값읽기("게시판명 수정");

		final WebElement element = driver.findElement(By.id("bbsNm"));
		element.clear();
		element.sendKeys(게시판명);
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판명\n");
		sb.append(게시판명);
		sb.append(SB_N_N);
	}

	private void 게시판소개내용__입력(final StringBuffer sb) {
		게시판소개내용 = 테스트_값읽기("게시판소개내용 수정");

		final WebElement element = driver.findElement(By.id("bbsIntrcn"));
		element.clear();
		element.sendKeys(게시판소개내용);
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판소개내용\n");
		sb.append(게시판소개내용);
		sb.append(SB_N_N);
	}

	private void 게시판_유형__선택(final StringBuffer sb) {
//		게시판_유형 = "통합게시판";
		게시판_유형 = "블로그형게시판";
//		게시판_유형 = "방명록";

		final WebElement element = driver.findElement(By.id("bbsTyCode"));
		element.sendKeys(게시판_유형);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판 유형\n");
		sb.append(게시판_유형);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 파일첨부가능여부__선택(final StringBuffer sb) {
		파일첨부가능여부 = "예";
//		파일첨부가능여부 = "아니오";

		final WebElement element = driver.findElement(By.id("fileAtchPosblAt"));
		element.sendKeys(파일첨부가능여부);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 파일첨부가능여부\n");
		sb.append(파일첨부가능여부);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 첨부가능파일숫자__선택(final StringBuffer sb) {
//		첨부가능파일숫자 = "1";
		첨부가능파일숫자 = "2";
//		첨부가능파일숫자 = "3";

		final WebElement element = driver.findElement(By.id("atchPosblFileNumber"));
		element.sendKeys(첨부가능파일숫자);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 첨부가능파일숫자\n");
		sb.append(첨부가능파일숫자);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 사용여부__선택(final StringBuffer sb) {
//		사용여부 = "예";
		사용여부 = "아니요";

		final WebElement element = driver.findElement(By.id("useAt"));
		element.sendKeys(사용여부);
		final Select select = new Select(element);
//		사용여부 = select.getFirstSelectedOption().getText();
		사용여부 = select.getFirstSelectedOption().getAttribute("value");
		정지();

		sb.append(로그_번호++);
		sb.append(". 사용여부\n");
		sb.append(사용여부);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 수정버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("s_submit"));
		element.click();
		정지();

		// 확인
		driver.switchTo().alert().accept();

		sb.append(로그_번호++);
		sb.append(". 수정 버튼\n");
		sb.append(SB_N_N);
	}

	private void assert__확인(final StringBuffer sb) {
		final WebElement 게시판명_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(2)"));
		final String 게시판명_실제_actual = 게시판명_element.getText();
		정지();

		final WebElement 사용여부_element = driver
				.findElement(By.cssSelector(".board_list tbody tr:nth-child(1) td:nth-child(5)"));
		final String 사용여부_실제_actual = 사용여부_element.getText();
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판명\n예상: ");
		sb.append(게시판명);
		sb.append(", 실제: ");
		sb.append(게시판명_실제_actual);
		sb.append(SB_N_N);

		sb.append(로그_번호++);
		sb.append(". 사용여부\n예상: ");
		sb.append(사용여부);
		sb.append(", 실제: ");
		sb.append(사용여부_실제_actual);
		sb.append(SB_N_N);

		assertEquals(게시판명, 게시판명_실제_actual, "게시판명");
		assertEquals(사용여부, 사용여부_실제_actual, "사용여부");
	}

}
