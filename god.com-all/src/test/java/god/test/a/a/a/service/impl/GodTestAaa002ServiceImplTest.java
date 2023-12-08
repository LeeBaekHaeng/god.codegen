package god.test.a.a.a.service.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.ModelMap;

import egovframework.com.test.EgovTestAbstractDAO;
import god.test.a.a.a.service.GodTestAaa002Service;
import god.test.a.a.a.service.GodTestAaa002VO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 ServiceImpl 테스트
 * 
 * @author 이백행
 * @since 2023-12-06
 *
 */
@ContextConfiguration(classes = { GodTestAaa002ServiceImplTest.class, EgovTestAbstractDAO.class, })

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

								GodTestAaa002ServiceImpl.class,

								GodTestAaa002DAO.class,

						}

				)

		}

)

@NoArgsConstructor
@Slf4j
public class GodTestAaa002ServiceImplTest extends EgovTestAbstractDAO {

	/**
	 * 행정코드 Service
	 */
	@Autowired
	private GodTestAaa002Service service;

	/**
	 * 행정코드 ID
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
		final int result = service.insert(vo);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	private void setOpertSn(final GodTestAaa002VO vo) {
		try {
			vo.setOpertSn(egovAdministCodeRecptnIdGnrService.getNextLongId());
		} catch (FdlException e) {
			throw new BaseRuntimeException(
					"FdlException egovAdministCodeRecptnIdGnrService " + egovMessageSource.getMessage("에러가 발생했습니다!"),
					e);
		}

		if (log.isDebugEnabled()) {
			log.debug("getOpertSn={}", vo.getOpertSn());
		}
	}

	/**
	 * 
	 * @param testData
	 */
	private void testData(final GodTestAaa002VO testData) {
		// given
		testData.setAdministZoneSe("1");
		testData.setAdministZoneCode(administZoneCode);

		setOpertSn(testData);

		// when
		final int result = service.insert(testData);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 
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
		final GodTestAaa002VO result = service.select(vo);

		// then
		assertSelect(testData, result);
	}

	private void assertSelect(final GodTestAaa002VO testData, final GodTestAaa002VO result) {
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
	 * 
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
		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());

		// when
		final List<GodTestAaa002VO> resultList = service.selectList(vo);

		// then
		assertSelectList(testData, resultList);
	}

	private void assertSelectList(final GodTestAaa002VO testData, final List<GodTestAaa002VO> resultList) {
		if (log.isDebugEnabled()) {
			log.debug("resultList={}", resultList);

			int i = 1;

			for (final GodTestAaa002VO result : resultList) {
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
	 * 
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
		final int result = service.update(vo);

		debugResult(result);

		// then
		assertEqualsUpdate(result);
	}

	/**
	 * 
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
		final int result = service.delete(vo);

		debugResult(result);

		// then
		assertEqualsDelete(result);
	}

	/**
	 * 
	 */
	@Test
	public void a06merge() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = service.merge(vo);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 
	 */
	@Test
	public void a07multi() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = service.multi(vo);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 
	 */
	@Test
	public void a08selectListTotCnt() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();

		// when
		final int totCnt = service.selectListTotCnt(vo);

		debugTotCnt(totCnt);

		// then
		assertTrueTotCnt(totCnt);
	}

	/**
	 * 행정코드 등록 테스트
	 */
	@Test
	public void a09insert() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		final ModelMap model = new ModelMap();

		// when
		service.insert(vo, model);

		if (log.isDebugEnabled()) {
			log.debug("model={}", model);
		}

		final int result = (int) model.get("result");

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 조회(멀티건)
	 */
	@Test
	public void a11selectList() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());

		final ModelMap model = new ModelMap();

		// when
		service.selectList(vo, model);

		final List<GodTestAaa002VO> resultList = (List<GodTestAaa002VO>) model.get("resultList");
		final PaginationInfo paginationInfo = (PaginationInfo) model.get("paginationInfo");

		debugPaginationInfo(paginationInfo);

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 
	 */
	@Test
	public void b01insert2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = service.insert2(vo);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 
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
		final GodTestAaa002VO result = service.select2(vo);

		// then
		assertSelect(testData, result);
	}

	/**
	     * 
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
		vo.setSearchKeyword("test 이백행 검색어 " + LocalDateTime.now());

		// when
		final List<GodTestAaa002VO> resultList = service.select2List(vo);

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 
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
		final int result = service.update2(vo);

		debugResult(result);

		// then
		assertEqualsUpdate(result);
	}

	/**
	 * 
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
		final int result = service.delete2(vo);

		debugResult(result);

		// then
		assertEqualsDelete(result);
	}

	/**
	 * 
	 */
	@Test
	public void b06merge2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = service.merge2(vo);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 
	 */
	@Test
	public void b07multi2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode(administZoneCode);

		setOpertSn(vo);

		// when
		final int result = service.multi2(vo);

		debugResult(result);

		// then
		assertEqualsInsert(result);
	}

	/**
	 * 
	 */
	@Test
	public void b08select2ListTotCnt() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();

		// when
		final int totCnt = service.selectListTotCnt(vo);

		debugTotCnt(totCnt);

		// then
		assertTrueTotCnt(totCnt);
	}

}
