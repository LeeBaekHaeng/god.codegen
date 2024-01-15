package egovframework.com.cmm;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.egovframe.rte.fdl.string.EgovDateUtil;
import org.junit.Test;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Com 기본 VO 단위 테스트
 * 
 * 
 * @author 이백행
 * @since 2024-01-16
 *
 */
@NoArgsConstructor
@Slf4j
public class ComDefaultVOTest {

	/**
	 * Com 기본 VO 단위 테스트
	 */
	@Test
	public void test() {
		// given
		final ComDefaultVO comDefaultVO = new ComDefaultVO();
		comDefaultVO.setFrstRegistPnttm(LocalDateTime.now());

		final String nowString = EgovDateUtil.toString(new Date(), "", null);
		final String nowString2 = EgovDateUtil.toString(new Date(), ComDefaultVO.DATE_TIME_FORMATTER_PATTERN, null);
		final String nowString3 = EgovDateUtil.toString(new Date(), ComDefaultVO.DATE_TIME_FORMATTER_PATTERN2, null);

		final String today = egovframework.com.utl.fcc.service.EgovDateUtil.getToday();

		final String timeStamp = EgovStringUtil.getTimeStamp();

		// when

		if (log.isDebugEnabled()) {
			log.debug("comDefaultVO={}", comDefaultVO);
			log.debug("getFrstRegistPnttm={}", comDefaultVO.getFrstRegistPnttm());
			log.debug("getFrstRegistPnttm2={}", comDefaultVO.getFrstRegistPnttm2());
			log.debug("getFrstRegistPnttm3={}", comDefaultVO.getFrstRegistPnttm3());

			log.debug("nowString={}", nowString);
			log.debug("nowString2={}", nowString2);
			log.debug("nowString3={}", nowString3);

			log.debug("today={}", today);

			log.debug("timeStamp={}", timeStamp);
		}

		// then
		assertEquals("",
				comDefaultVO.getFrstRegistPnttm()
						.format(DateTimeFormatter.ofPattern(ComDefaultVO.DATE_TIME_FORMATTER_PATTERN)),
				comDefaultVO.getFrstRegistPnttm2());
		assertEquals("",
				comDefaultVO.getFrstRegistPnttm()
						.format(DateTimeFormatter.ofPattern(ComDefaultVO.DATE_TIME_FORMATTER_PATTERN2)),
				comDefaultVO.getFrstRegistPnttm3());
	}

}
