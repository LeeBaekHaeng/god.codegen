package god.test.a.a.a.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import egovframework.com.test.EgovTestAbstractDAO;
import god.test.a.a.a.service.GodTestAaa002VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 DAO 테스트
 * 
 * @author 이백행
 * @since 2023-11-19
 *
 */
@ContextConfiguration(classes = { GodTestAaa002DAOTest.class, EgovTestAbstractDAO.class, })

@Configuration

@ImportResource({

		"classpath*:egovframework/spring/com/idgn/context-idgn-AdministCodeRecptn.xml",

})

@ComponentScan(

		useDefaultFilters = false,

		basePackages = {

				"god.test.a.a.a.service.impl",

		},

		includeFilters = {

				@Filter(

						type = FilterType.ASSIGNABLE_TYPE,

						classes = {

								GodTestAaa002DAO.class,

						}

				)

		}

)

@NoArgsConstructor
@Slf4j
public class GodTestAaa002DAOTest extends EgovTestAbstractDAO {

	/**
	 * 행정코드 DAO
	 */
	@Autowired
	private GodTestAaa002DAO dao;

	/**
	 * egovAdministCodeRecptnIdGnrService
	 */
	@Autowired
	@Qualifier("egovAdministCodeRecptnIdGnrService")
	private EgovIdGnrService egovAdministCodeRecptnIdGnrService;

	/**
	 * `ADMINIST_ZONE_CODE` varchar(10) NOT NULL COMMENT '행정구역코드',
	 */
	private String administZoneCode = "0000000001";

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void a01insert() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = dao.insert(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	private void setOpertSn(final GodTestAaa002VO vo) {
		try {
			vo.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
		} catch (FdlException e) {
			throw new BaseRuntimeException("FdlException egovAdministCodeRecptnIdGnrService "
					+ egovMessageSource.getMessage("fail.common.msg"), e);
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
	private void testData(final GodTestAaa002VO testData) {
		// given
		testData.setAdministZoneSe("1");
		testData.setAdministZoneCode(administZoneCode);

		setOpertSn(testData);

		// when
		final int result = dao.insert(testData);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * 행정코드 조회(단건) 테스트
	 */
	@Test
	public void a02select() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final GodTestAaa002VO result = dao.select(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertSelect(testData, result);
	}

	private void assertSelect(final GodTestAaa002VO testData, final GodTestAaa002VO result) {
		if (log.isDebugEnabled()) {
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
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 2023-11-18");

		// when
		final List<GodTestAaa002VO> resultList = dao.selectList(vo);

		if (log.isDebugEnabled()) {
			log.debug("resultList={}", resultList);
		}

		// then
		assertSelectList(testData, resultList);
	}

	private void assertSelectList(final GodTestAaa002VO testData, final List<GodTestAaa002VO> resultList) {
//        assertFalse(egovMessageSource.getMessage(FAIL_COMMON_SELECT), resultList.isEmpty());
		assertTrue(egovMessageSource.getMessage(FAIL_COMMON_SELECT), resultList.size() > -1);

		int i = 1;

		for (final GodTestAaa002VO result : resultList) {
			if (log.isDebugEnabled()) {
				log.debug("i={}", i);

				log.debug("getAdministZoneSe={}, {}", testData.getAdministZoneSe(), result.getAdministZoneSe());
				log.debug("getAdministZoneCode={}, {}", testData.getAdministZoneCode(), result.getAdministZoneCode());

				log.debug("getUseAt={}, {}", testData.getUseAt(), result.getUseAt());
				log.debug("");
			}

			i++;
		}
	}

	/**
	 * 행정코드 수정 테스트
	 */
	@Test
	public void a04update() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = dao.update(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_UPDATE), 1, result);
	}

	/**
	 * 행정코드 삭제 테스트
	 */
	@Test
	public void a05delete() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = dao.delete(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_DELETE), 1, result);
	}

	/**
	 * 행정코드 등록/수정 테스트
	 */
	@Test
	public void a06merge() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = dao.merge(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * 행정코드 등록/수정/삭제 테스트
	 */
	@Test
	public void a07multi() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = dao.multi(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수 테스트
	 */
	@Test
	public void a08selectListTotCnt() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();

		// when
		final int totCnt = dao.selectListTotCnt(vo);

		if (log.isDebugEnabled()) {
			log.debug("totCnt={}", totCnt);
		}

		// then
		assertTrue(egovMessageSource.getMessage(FAIL_COMMON_SELECT), totCnt > -1);
	}

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void b01insert2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = dao.insert2(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * 행정코드 조회(단건) 테스트
	 */
	@Test
	public void b02select2() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final GodTestAaa002VO result = dao.select2(vo);

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
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

		// vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 2023-11-18");

		// when
		final List<GodTestAaa002VO> resultList = dao.select2List(vo);

		if (log.isDebugEnabled()) {
			log.debug("resultList={}", resultList);
		}

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 행정코드 수정 테스트
	 */
	@Test
	public void b04update2() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = dao.update2(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_UPDATE), 1, result);
	}

	/**
	 * 행정코드 삭제 테스트
	 */
	@Test
	public void b05delete2() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = dao.delete2(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_DELETE), 1, result);
	}

	/**
	 * 행정코드 등록/수정 테스트
	 */
	@Test
	public void b06merge2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = dao.merge2(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * 행정코드 등록/수정/삭제 테스트
	 */
	@Test
	public void b07multi2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = dao.multi2(vo);

		debugIntResult(result);

		// then
		assertEquals(egovMessageSource.getMessage(FAIL_COMMON_INSERT), 1, result);
	}

	/**
	 * 행정코드 조회(단건) 전체 건수 테스트
	 */
	@Test
	public void b08select2ListTotCnt() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();

		// when
		final int totCnt = dao.selectListTotCnt(vo);

		if (log.isDebugEnabled()) {
			log.debug("totCnt={}", totCnt);
		}

		// then
		assertTrue(egovMessageSource.getMessage(FAIL_COMMON_SELECT), totCnt > -1);
	}

}
