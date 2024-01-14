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
class a01_등록 extends 셀레늄_테스트 {

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
	private String 답장가능여부;

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
	private String 추가선택사항;

	/**
	 * 
	 */
	private String 사용여부;

	@Test
	void 등록_버튼() {
		final StringBuffer sb = new StringBuffer(1600);
		sb.append(SB_N_N);

		테스터 = "홍길동";

		로그인("USER");

		등록__화면(sb);

		게시판명__입력(sb);
		게시판소개내용__입력(sb);
		게시판_유형__선택(sb);
		답장가능여부__선택(sb);
		파일첨부가능여부__선택(sb);
		첨부가능파일숫자__선택(sb);
		추가선택사항__선택(sb);
		사용여부__선택(sb);

		등록_버튼(sb);

		assert__확인();

		if (log.isDebugEnabled()) {
			log.debug(sb.toString());
		}
	}

	private void 등록__화면(final StringBuffer sb) {
		driver.get(GET_URL + "/cop/bbs/insertBBSMasterView.do");
		정지();

		sb.append(로그_번호++);
		sb.append(". ");
		sb.append("게시판");
		sb.append(" 등록 화면\n\n");
	}

	private void 게시판명__입력(final StringBuffer sb) {
		게시판명 = 테스트_값읽기("게시판명");

		final WebElement element = driver.findElement(By.id("bbsNm"));
		element.sendKeys(게시판명);
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판명\n");
		sb.append(게시판명);
		sb.append(SB_N_N);
	}

	private void 게시판소개내용__입력(final StringBuffer sb) {
		게시판소개내용 = 테스트_값읽기("게시판소개내용");

		final WebElement element = driver.findElement(By.id("bbsIntrcn"));
		element.sendKeys(게시판소개내용);
		정지();

		sb.append(로그_번호++);
		sb.append(". 게시판소개내용\n");
		sb.append(게시판소개내용);
		sb.append(SB_N_N);
	}

	private void 게시판_유형__선택(final StringBuffer sb) {
		게시판_유형 = "통합게시판";
//		게시판_유형 = "블로그형게시판";
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

	private void 답장가능여부__선택(final StringBuffer sb) {
//		답장가능여부 = "예";
		답장가능여부 = "아니오";

		final WebElement element = driver.findElement(By.id("replyPosblAt"));
		element.sendKeys(답장가능여부);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 답장가능여부\n");
		sb.append(답장가능여부);
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
//		첨부가능파일숫자 = "2";
		첨부가능파일숫자 = "3";

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

	private void 추가선택사항__선택(final StringBuffer sb) {
//		추가선택사항 = "댓글";
		추가선택사항 = "만족도조사";

		final WebElement element = driver.findElement(By.id("option"));
		element.sendKeys(추가선택사항);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 추가선택사항\n");
		sb.append(추가선택사항);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 사용여부__선택(final StringBuffer sb) {
		사용여부 = "예";
//		사용여부 = "아니요";

		final WebElement element = driver.findElement(By.id("useAt"));
		element.sendKeys(사용여부);
		final Select select = new Select(element);
		정지();

		sb.append(로그_번호++);
		sb.append(". 사용여부\n");
		sb.append(사용여부);
		sb.append(", ");
		sb.append(select.getFirstSelectedOption().getText());
		sb.append(SB_N_N);
	}

	private void 등록_버튼(final StringBuffer sb) {
		final WebElement element = driver.findElement(By.className("s_submit"));
		element.click();
		정지();

		// 확인
		driver.switchTo().alert().accept();

		sb.append(로그_번호++);
		sb.append(". 등록 버튼\n");
		sb.append(SB_N_N);
	}

	private void assert__확인() {
		assertEquals("", "", "등록 버튼");
	}

}
