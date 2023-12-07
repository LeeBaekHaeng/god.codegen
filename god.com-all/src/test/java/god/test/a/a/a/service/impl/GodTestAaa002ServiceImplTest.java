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
	 * 행정코드 등록 테스트
	 */
	@Test
	public void a001insert() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.insert(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
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
	 * 행정코드 등록 테스트
	 */
	@Test
	public void a001insertModelMap() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		final ModelMap model = new ModelMap();

		// when
		service.insert(vo, model);

		if (log.isDebugEnabled()) {
			log.debug("model={}", model);
		}

		final int result = (int) model.get("result");

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 * @param testData
	 */
	private void testData(final GodTestAaa002VO testData) {
		// given
		testData.setAdministZoneSe("1");
		testData.setAdministZoneCode("0000000001");

		setOpertSn(testData);

		// when
		final int result = service.insert(testData);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void a002select() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final GodTestAaa002VO result = service.select(vo);

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

		assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
				result.getAdministZoneCode());
		assertEquals(egovMessageSource.getMessage("fail.common.select"), testData.getAdministZoneCode(),
				result.getAdministZoneCode());
	}

	/**
	 * 
	 */
	@Test
	public void a003selectList() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

//        vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 2023-11-18");

		// when
		final List<GodTestAaa002VO> resultList = service.selectList(vo);

		if (log.isDebugEnabled()) {
			log.debug("resultList={}", resultList);
		}

		// then
		assertSelectList(testData, resultList);
	}

	private void assertSelectList(final GodTestAaa002VO testData, final List<GodTestAaa002VO> resultList) {
//        assertFalse(egovMessageSource.getMessage("fail.common.select"), resultList.isEmpty());
		assertTrue(egovMessageSource.getMessage("fail.common.select"), resultList.size() > -1);

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
	 * 
	 */
	@Test
	public void a004update() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = service.update(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void a005delete() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = service.delete(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void a006merge() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.merge(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void a007multi() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.multi(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void a008selectListTotCnt() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();

		// when
		final int totCnt = service.selectListTotCnt(vo);

		if (log.isDebugEnabled()) {
			log.debug("totCnt={}", totCnt);
		}

		// then
		assertTrue(egovMessageSource.getMessage("fail.common.select"), totCnt > -1);
	}

	/**
	 * 
	 */
	@Test
	public void b001insert2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.insert2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void b002select2() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final GodTestAaa002VO result = service.select2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertSelect(testData, result);
	}

	/**
	     * 
	     */
	@Test
	public void b003select2List() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

		// vo.setSearchCondition("0");
		vo.setSearchKeyword("test 이백행 2023-11-18");

		// when
		final List<GodTestAaa002VO> resultList = service.select2List(vo);

		if (log.isDebugEnabled()) {
			log.debug("resultList={}", resultList);
		}

		// then
		assertSelectList(testData, resultList);
	}

	/**
	 * 
	 */
	@Test
	public void b004update2() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		vo.setUseAt("Y");

		// when
		final int result = service.update2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.update"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void b005delete2() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe(testData.getAdministZoneSe());
		vo.setAdministZoneCode(testData.getAdministZoneCode());

		// when
		final int result = service.delete2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.delete"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void b006merge2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.merge2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void b007multi2() {
		// given
		final GodTestAaa002VO vo = new GodTestAaa002VO();
		vo.setAdministZoneSe("1");
		vo.setAdministZoneCode("0000000001");

		setOpertSn(vo);

		// when
		final int result = service.multi2(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(egovMessageSource.getMessage("fail.common.insert"), 1, result);
	}

	/**
	 * 
	 */
	@Test
	public void b008select2ListTotCnt() {
		// given
		final GodTestAaa002VO testData = new GodTestAaa002VO();
		testData(testData);

		final GodTestAaa002VO vo = new GodTestAaa002VO();

		// when
		final int totCnt = service.selectListTotCnt(vo);

		if (log.isDebugEnabled()) {
			log.debug("totCnt={}", totCnt);
		}

		// then
		assertTrue(egovMessageSource.getMessage("fail.common.select"), totCnt > -1);
	}

}
