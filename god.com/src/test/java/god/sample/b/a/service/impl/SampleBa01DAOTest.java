package god.sample.b.a.service.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.fdl.string.EgovDateUtil;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.test.EgovTestAbstractDAO;
import god.sample.b.a.service.SampleBa01VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO 테스트
 * 
 * @author 이백행
 * @since 2023-12-20
 *
 */
@ContextConfiguration(classes = { SampleBa01DAOTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

		"classpath*:egovframework/spring/com/idgn/context-idgn-Cmmnty.xml",

})

@ComponentScan(

		useDefaultFilters = false,

		basePackages = {

				"god.sample.b.a.service.impl",

		},

		includeFilters = {

				@Filter(

						type = FilterType.ASSIGNABLE_TYPE,

						classes = {

								SampleBa01DAO.class,

						}

				)

		}

)

@NoArgsConstructor
@Slf4j
public class SampleBa01DAOTest extends EgovTestAbstractDAO {

	/**
	 * 행정코드 DAO
	 */
	@Resource
	private SampleBa01DAO dao;

	/**
	 * 만족도 ID
	 */
	@Resource(name = "egovCmmntyIdGnrService")
	private EgovIdGnrService egovCmmntyIdGnrService;

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void a01insert() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.insert(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	private void setAdministZoneCode(final SampleBa01VO vo) {
		vo.setAdministZoneCode(EgovDateUtil.toString(new Date(), "yyyyMMddHH", null));
	}

	private void setOpertSn(final SampleBa01VO vo) {
		try {
			vo.setOpertSn(egovCmmntyIdGnrService.getNextLongId());
		} catch (FdlException e) {
			throw new BaseRuntimeException(
					"FdlException egovCmmntyIdGnrService " + egovMessageSource.getMessage("fail.common.msg"), e);
		}

		if (log.isDebugEnabled()) {
			log.debug("getOpertSn={}", vo.getOpertSn());
		}
	}

	/**
	 * 테스트 데이터
	 * 
	 * @param testData
	 */
	private void testData(final SampleBa01VO testData) {
		// given
		testData.setAdministZoneSe("1");
		testData.setAdministZoneCode(EgovDateUtil.toString(new Date(), "yyyyMMddHH", null));

		setOpertSn(testData);

		// when
		final int result = dao.insert(testData);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 조회(단건) 테스트
	 */
	@Test
	public void a02select() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final SampleBa01VO result = dao.select(vo);

		// then
		assertSelect(testData, result);
	}

	private void assertSelect(final SampleBa01VO testData, final SampleBa01VO result) {
		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
			log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
			log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
		}

		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getAdministZoneCode(),
				result.getAdministZoneCode());
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getAdministZoneCode(),
				result.getAdministZoneCode());
	}

	/**
	 * 행정코드 조회(멀티건) 테스트
	 */
	@Test
	public void a03selectList() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());

		// when
		final List<SampleBa01VO> resultList = dao.selectList(vo);

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수 테스트
	 */
	@Test
	public void a04selectListTotCnt() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();

		// when
		final int totCnt = dao.selectListTotCnt(vo);

		// then
		debugTotCnt(totCnt);
		assertTrueTotCnt(totCnt);
	}

	private void assertSelectList(final SampleBa01VO testData, final List<SampleBa01VO> resultList) {
		if (log.isDebugEnabled()) {
			log.debug("resultList={}", resultList);

			int i = 1;

			for (final SampleBa01VO result : resultList) {
				log.debug("i={}", i);

				log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
				log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());

				log.debug("getUseAt={}, {}", testData.getUseAt(), result.getUseAt());
				log.debug("");

				i++;
			}
		}

		assertTrueResultListSize(resultList.size());
	}

	/**
	 * 행정코드 수정 테스트
	 */
	@Test
	public void a05update() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = dao.update(vo);

		// then
		debugResult(result);
		assertEqualsUpdate(result);
	}

	/**
	 * 행정코드 삭제 테스트
	 */
	@Test
	public void a06delete() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = dao.delete(vo);

		// then
		debugResult(result);
		assertEqualsDelete(result);
	}

	/**
	 * 행정코드 등록/수정 테스트
	 */
	@Test
	public void a07merge() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.merge(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 등록/수정/삭제 테스트
	 */
	@Test
	public void a08multi() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.multi(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void b01insert2() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.insert2(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 조회(단건) 테스트
	 */
	@Test
	public void b02select2() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final SampleBa01VO result = dao.select2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertSelect(testData, result);
	}

	/**
	 * 행정코드 조회(멀티건) 테스트
	 */
	@Test
	public void b03select2List() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

		// vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());

		// when
		final List<SampleBa01VO> resultList = dao.select2List(vo);

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수 테스트
	 */
	@Test
	public void b04select2ListTotCnt() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();

		// when
		final int totCnt = dao.select2ListTotCnt(vo);

		// then
		debugTotCnt(totCnt);
		assertTrueTotCnt(totCnt);
	}

	/**
	 * 행정코드 수정 테스트
	 */
	@Test
	public void b05update2() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = dao.update2(vo);

		// then
		debugResult(result);
		assertEqualsUpdate(result);
	}

	/**
	 * 행정코드 삭제 테스트
	 */
	@Test
	public void b06delete2() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = dao.delete2(vo);

		// then
		debugResult(result);
		assertEqualsDelete(result);
	}

	/**
	 * 행정코드 등록/수정 테스트
	 */
	@Test
	public void b07merge2() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.merge2(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 등록/수정/삭제 테스트
	 */
	@Test
	public void b08multi2() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.multi2(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void c01insert3() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.insert3(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 조회(단건) 테스트
	 */
	@Test
	public void c02select3() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final SampleBa01VO result = dao.select3(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertSelect(testData, result);
	}

	/**
	 * 행정코드 조회(멀티건) 테스트
	 */
	@Test
	public void c03select3List() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

		// vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());

		// when
		final List<SampleBa01VO> resultList = dao.select3List(vo);

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수 테스트
	 */
	@Test
	public void c04select3ListTotCnt() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();

		// when
		final int totCnt = dao.select3ListTotCnt(vo);

		// then
		debugTotCnt(totCnt);
		assertTrueTotCnt(totCnt);
	}

	/**
	 * 행정코드 수정 테스트
	 */
	@Test
	public void c05update3() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = dao.update3(vo);

		// then
		debugResult(result);
		assertEqualsUpdate(result);
	}

	/**
	 * 행정코드 삭제 테스트
	 */
	@Test
	public void c06delete3() {
		// given
		final SampleBa01VO testData = new SampleBa01VO();
		testData(testData);

		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = dao.delete3(vo);

		// then
		debugResult(result);
		assertEqualsDelete(result);
	}

	/**
	 * 행정코드 등록/수정 테스트
	 */
	@Test
	public void c07merge3() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.merge3(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

	/**
	 * 행정코드 등록/수정/삭제 테스트
	 */
	@Test
	public void c08multi3() {
		// given
		final SampleBa01VO vo = new SampleBa01VO();
		vo.setAdministZoneSe("1");
		setAdministZoneCode(vo);

		setOpertSn(vo);

		// when
		final int result = dao.multi3(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

}
