package god.sample.b.a.service.impl;

import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.fdl.string.EgovDateUtil;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.test.EgovTestAbstractDAO;
import egovframework.com.utl.sim.service.EgovFileScrty;
import god.sample.b.a.service.SampleBa02.UseAt;
import god.sample.b.a.service.SampleBa02VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 게시판 DAO 테스트
 * 
 * @author 이백행
 * @since 2023-12-20
 *
 */
@ContextConfiguration(classes = { SampleBa02DAOTest.class, EgovTestAbstractDAO.class, })

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

								SampleBa02DAO.class,

						}

				)

		}

)

@NoArgsConstructor
@Slf4j
public class SampleBa02DAOTest extends EgovTestAbstractDAO {

	/**
	 * 게시판 DAO
	 */
	@Resource
	private SampleBa02DAO dao;

	/**
	 * 만족도 ID
	 */
	@Resource(name = "egovCmmntyIdGnrService")
	private EgovIdGnrService egovCmmntyIdGnrService;

	/**
	 * 게시판 등록 테스트
	 */
	@Test
	public void a01insert() {
		// given
		final SampleBa02VO vo = new SampleBa02VO();
		vo.setNttId(0);
//		vo.setBbsId("TEST_A100_BBSMSTR_000000000001");
		vo.setBbsId("BBSMSTR_000000000021nOQNbfsaSM");
		final LocalDateTime now = LocalDateTime.now();
		vo.setNttSj("test 이백행 게시물제목 " + now);
		vo.setNttCn("test 이백행 게시물내용 " + now);
		vo.setAnswerAt("Y");

//		vo.setUseAt("Y");
		vo.setUseAt(UseAt.Y.name());
		if (log.isDebugEnabled()) {
			log.debug("UseAt.Y={}", UseAt.Y);
			log.debug("name={}", UseAt.Y.name());
			log.debug("ordinal={}", UseAt.Y.ordinal());
			log.debug("UseAt.N={}", UseAt.N);

			final UseAt[] values = UseAt.values();
			for (int i = 0; i < values.length; i++) {
				log.debug("values[{}]={}", i, values[i]);
			}
		}

		vo.setParntscttNo(vo.getNttId());
		vo.setAnswerLc(null);
		vo.setSortOrdr(null);
		vo.setRdcnt(0L);
		vo.setNtceBgnde(EgovDateUtil.toString(new Date(), "yyyyMMddHHmmss", null));
		vo.setNtceEndde(vo.getNtceBgnde());
		vo.setPassword(EgovFileScrty.encryptPassword("test 이백행 비밀번호 " + now, ""));
		vo.setAtchFileId(vo.getNtceBgnde());
		vo.setNoticeAt("Y");

		vo.setFrstRegistPnttm(LocalDateTime.now());
		vo.setLastUpdtPnttm(vo.getFrstRegistPnttm());
		final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (loginVO != null) {
			vo.setNtcrId(loginVO.getUniqId());
			vo.setNtcrNm(loginVO.getName());
//			vo.setPassword(EgovFileScrty.encryptPassword("test 이백행 비밀번호 " + now, loginVO.getId()));

			vo.setFrstRegisterId(loginVO.getUniqId());
			vo.setLastUpdusrId(loginVO.getUniqId());
		}

		// when
		final int result = dao.insert(vo);

		// then
		debugResult(result);
		assertEqualsInsert(result);
	}

//	private void setAdministZoneCode(final SampleBa02VO vo) {
//		vo.setAdministZoneCode(EgovDateUtil.toString(new Date(), "yyyyMMddHH", null));
//	}
//
//	private void setOpertSn(final SampleBa02VO vo) {
//		try {
//			vo.setOpertSn(egovCmmntyIdGnrService.getNextLongId());
//		} catch (FdlException e) {
//			throw new BaseRuntimeException(
//					"FdlException egovCmmntyIdGnrService " + egovMessageSource.getMessage("fail.common.msg"), e);
//		}
//
//		if (log.isDebugEnabled()) {
//			log.debug("getOpertSn={}", vo.getOpertSn());
//		}
//	}
//
//	/**
//	 * 테스트 데이터
//	 * 
//	 * @param testData
//	 */
//	private void testData(final SampleBa02VO testData) {
//		// given
//		testData.setAdministZoneSe("1");
//		testData.setAdministZoneCode(EgovDateUtil.toString(new Date(), "yyyyMMddHH", null));
//
//		setOpertSn(testData);
//
//		// when
//		final int result = dao.insert(testData);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 조회(단건) 테스트
//	 */
//	@Test
//	public void a02select() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final SampleBa02VO result = dao.select(vo);
//
//		// then
//		assertSelect(testData, result);
//	}
//
//	private void assertSelect(final SampleBa02VO testData, final SampleBa02VO result) {
//		if (log.isDebugEnabled()) {
//			log.debug("result={}", result);
//			log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
//			log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
//		}
//
//		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getAdministZoneCode(),
//				result.getAdministZoneCode());
//		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_SELECT), testData.getAdministZoneCode(),
//				result.getAdministZoneCode());
//	}
//
//	/**
//	 * 게시판 조회(멀티건) 테스트
//	 */
//	@Test
//	public void a03selectList() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setFirstIndex(0);
//		vo.setRecordCountPerPage(10);
//
////        vo.setSearchCondition("0");
//		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());
//
//		// when
//		final List<SampleBa02VO> resultList = dao.selectList(vo);
//
//		// then
//		assertSelectList(testData, resultList);
//	}
//
//	/**
//	 * 게시판 조회(단건) 전체 건수 테스트
//	 */
//	@Test
//	public void a04selectListTotCnt() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//
//		// when
//		final int totCnt = dao.selectListTotCnt(vo);
//
//		// then
//		debugTotCnt(totCnt);
//		assertTrueTotCnt(totCnt);
//	}
//
//	private void assertSelectList(final SampleBa02VO testData, final List<SampleBa02VO> resultList) {
//		if (log.isDebugEnabled()) {
//			log.debug("resultList={}", resultList);
//
//			int i = 1;
//
//			for (final SampleBa02VO result : resultList) {
//				log.debug("i={}", i);
//
//				log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
//				log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());
//
//				log.debug("getUseAt={}, {}", testData.getUseAt(), result.getUseAt());
//				log.debug("");
//
//				i++;
//			}
//		}
//
//		assertTrueResultListSize(resultList.size());
//	}
//
//	/**
//	 * 게시판 수정 테스트
//	 */
//	@Test
//	public void a05update() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		vo.setUseAt("Y");
//
//		// when
//		final int result = dao.update(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsUpdate(result);
//	}
//
//	/**
//	 * 게시판 삭제 테스트
//	 */
//	@Test
//	public void a06delete() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final int result = dao.delete(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsDelete(result);
//	}
//
//	/**
//	 * 게시판 등록/수정 테스트
//	 */
//	@Test
//	public void a07merge() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.merge(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 등록/수정/삭제 테스트
//	 */
//	@Test
//	public void a08multi() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.multi(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 등록 테스트
//	 */
//	@Test
//	public void b01insert2() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.insert2(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 조회(단건) 테스트
//	 */
//	@Test
//	public void b02select2() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final SampleBa02VO result = dao.select2(vo);
//
//		if (log.isDebugEnabled()) {
//			log.debug("result={}", result);
//		}
//
//		// then
//		assertSelect(testData, result);
//	}
//
//	/**
//	 * 게시판 조회(멀티건) 테스트
//	 */
//	@Test
//	public void b03select2List() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setFirstIndex(0);
//		vo.setRecordCountPerPage(10);
//
//		// vo.setSearchCondition("0");
//		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());
//
//		// when
//		final List<SampleBa02VO> resultList = dao.select2List(vo);
//
//		// then
//		assertSelectList(testData, resultList);
//	}
//
//	/**
//	 * 게시판 조회(단건) 전체 건수 테스트
//	 */
//	@Test
//	public void b04select2ListTotCnt() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//
//		// when
//		final int totCnt = dao.select2ListTotCnt(vo);
//
//		// then
//		debugTotCnt(totCnt);
//		assertTrueTotCnt(totCnt);
//	}
//
//	/**
//	 * 게시판 수정 테스트
//	 */
//	@Test
//	public void b05update2() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		vo.setUseAt("Y");
//
//		// when
//		final int result = dao.update2(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsUpdate(result);
//	}
//
//	/**
//	 * 게시판 삭제 테스트
//	 */
//	@Test
//	public void b06delete2() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final int result = dao.delete2(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsDelete(result);
//	}
//
//	/**
//	 * 게시판 등록/수정 테스트
//	 */
//	@Test
//	public void b07merge2() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.merge2(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 등록/수정/삭제 테스트
//	 */
//	@Test
//	public void b08multi2() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.multi2(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 등록 테스트
//	 */
//	@Test
//	public void c01insert3() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.insert3(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 조회(단건) 테스트
//	 */
//	@Test
//	public void c02select3() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final SampleBa02VO result = dao.select3(vo);
//
//		if (log.isDebugEnabled()) {
//			log.debug("result={}", result);
//		}
//
//		// then
//		assertSelect(testData, result);
//	}
//
//	/**
//	 * 게시판 조회(멀티건) 테스트
//	 */
//	@Test
//	public void c03select3List() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setFirstIndex(0);
//		vo.setRecordCountPerPage(10);
//
//		// vo.setSearchCondition("0");
//		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());
//
//		// when
//		final List<SampleBa02VO> resultList = dao.select3List(vo);
//
//		// then
//		assertSelectList(testData, resultList);
//	}
//
//	/**
//	 * 게시판 조회(단건) 전체 건수 테스트
//	 */
//	@Test
//	public void c04select3ListTotCnt() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//
//		// when
//		final int totCnt = dao.select3ListTotCnt(vo);
//
//		// then
//		debugTotCnt(totCnt);
//		assertTrueTotCnt(totCnt);
//	}
//
//	/**
//	 * 게시판 수정 테스트
//	 */
//	@Test
//	public void c05update3() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		vo.setUseAt("Y");
//
//		// when
//		final int result = dao.update3(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsUpdate(result);
//	}
//
//	/**
//	 * 게시판 삭제 테스트
//	 */
//	@Test
//	public void c06delete3() {
//		// given
//		final SampleBa02VO testData = new SampleBa02VO();
//		testData(testData);
//
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe(testData.getAdministZoneSe());
//		vo.setAdministZoneCode(testData.getAdministZoneCode());
//
//		// when
//		final int result = dao.delete3(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsDelete(result);
//	}
//
//	/**
//	 * 게시판 등록/수정 테스트
//	 */
//	@Test
//	public void c07merge3() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.merge3(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}
//
//	/**
//	 * 게시판 등록/수정/삭제 테스트
//	 */
//	@Test
//	public void c08multi3() {
//		// given
//		final SampleBa02VO vo = new SampleBa02VO();
//		vo.setAdministZoneSe("1");
//		setAdministZoneCode(vo);
//
//		setOpertSn(vo);
//
//		// when
//		final int result = dao.multi3(vo);
//
//		// then
//		debugResult(result);
//		assertEqualsInsert(result);
//	}

}
