package egovframework.com.cmm;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.egovframe.rte.fdl.string.EgovDateUtil;
import org.junit.Test;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import god.com.cmm.enums.DatePattern;
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
		final String nowString2 = EgovDateUtil.toString(new Date(), DatePattern.YYYY_MM_DD_HH_MM_SS.getCode(), null);
		final String nowString3 = EgovDateUtil.toString(new Date(), DatePattern.YYYY_MM_DD.getCode(), null);

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

			log.debug("YYYY_MM_DD_HH_MM_SS={}", DatePattern.YYYY_MM_DD_HH_MM_SS);
			log.debug("name={}", DatePattern.YYYY_MM_DD_HH_MM_SS.name());
			log.debug("ordinal={}", DatePattern.YYYY_MM_DD_HH_MM_SS.ordinal());
			log.debug("getCode={}", DatePattern.YYYY_MM_DD_HH_MM_SS.getCode());
			log.debug("getCodeNm={}", DatePattern.YYYY_MM_DD_HH_MM_SS.getCodeNm());
		}

		// then
		assertEquals("",
				comDefaultVO.getFrstRegistPnttm()
						.format(DateTimeFormatter.ofPattern(DatePattern.YYYY_MM_DD_HH_MM_SS.getCode())),
				comDefaultVO.getFrstRegistPnttm2());
		assertEquals("",
				comDefaultVO.getFrstRegistPnttm().format(DateTimeFormatter.ofPattern(DatePattern.YYYY_MM_DD.getCode())),
				comDefaultVO.getFrstRegistPnttm3());

		assertEquals("",
				comDefaultVO.getFrstRegistPnttm()
						.format(DateTimeFormatter.ofPattern(DatePattern.YYYY_MM_DD_HH_MM_SS.getCode())),
				comDefaultVO.getFrstRegistPnttm2());
		assertEquals("",
				comDefaultVO.getFrstRegistPnttm().format(DateTimeFormatter.ofPattern(DatePattern.YYYY_MM_DD.getCode())),
				comDefaultVO.getFrstRegistPnttm3());
	}

}
